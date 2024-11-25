package com.rolemberg.eventostech.resource.services.event;

import com.rolemberg.eventostech.domain.event.Event;
import com.rolemberg.eventostech.application.web.response.event.EventCleanResponseDTO;
import com.rolemberg.eventostech.application.web.request.event.EventRequestDto;
import com.rolemberg.eventostech.application.web.response.event.EventsResponseDTO;
import com.rolemberg.eventostech.web.handlers.AppError;
import com.rolemberg.eventostech.resource.repository.event.EventRepo;
import com.rolemberg.eventostech.resource.services.address.AddressService;
import com.rolemberg.eventostech.resource.util.FileToS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private AddressService addressService;
    @Autowired
    private FileToS3 file;

    public List<EventsResponseDTO> getEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventPage = this.eventRepo.findAll(pageable);
        return eventPage.map(this::mapToEventsResponseDTO).toList();
    }

    public List<EventsResponseDTO> getFilteredEvents(
            int page,
            int size,
            String title,
            String city,
            String uf,
            LocalDate start_date,
            LocalDate end_date
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventPage = this.eventRepo.findFilteredEvents(
            title,
            city,
            uf,
            (start_date != null) ? start_date : LocalDate.of(1970, 1, 1),
            (end_date != null) ? end_date : LocalDate.of(2500, 1, 1),
            pageable
        );
        return eventPage.map(this::mapToEventsResponseDTO).toList();
    }

    public Event createEvent(EventRequestDto data) {
        String image_url = null;
        if (data.image() != null) image_url = this.file.uploadToS3(data.image());
        Event e = new Event();
        e.setTitle(data.title());
        e.setDescription(data.description());
        e.setEvent_url(data.event_url());
        e.setRemote(data.remote());
        e.setDate(data.date());
        e.setImage_url(image_url);
        e.setCoupons(new ArrayList<>());
        e.setAddresses(new ArrayList<>());
        eventRepo.save(e);
        if (!data.remote()) {
            e.getAddresses().add(this.addressService.createFromEvent(data, e));
            eventRepo.save(e);
        }
        return e;
    }

    public Event updateEvent(UUID id, EventRequestDto data) throws NoSuchElementException {
        Event e = eventRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Cannot get the event while trying to update"));
        e.setTitle(data.title());
        e.setDescription(data.description());
        e.setEvent_url(data.event_url());
        e.setRemote(data.remote());
        e.setDate(data.date());
        eventRepo.save(e);
        return e;
    }

    public Event deleteEvent(UUID id) throws NoSuchElementException {
        Event e = eventRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Cannot get the event while trying to delete"));
        boolean deleteFile = file.deleteFromS3(e.getImage_url());
        if (!deleteFile)
            throw new AppError("Not able to delete the image '" + e.getImage_url() + "' from S3");
        eventRepo.deleteById(id);
        return e;
    }

    public EventCleanResponseDTO mapToEventCleanResponseDTO(Event event) {
        return new EventCleanResponseDTO(
            event.getId(),
            event.getTitle(),
            event.getDescription(),
            event.getDate(),
            event.getRemote(),
            event.getImage_url(),
            event.getEvent_url()
        );
    }

    public EventsResponseDTO mapToEventsResponseDTO(Event event) {
        return new EventsResponseDTO(
            event.getId(),
            event.getTitle(),
            event.getDescription(),
            event.getDate(),
            event.getRemote(),
            event.getImage_url(),
            event.getEvent_url(),
            event.getCoupons(),
            event.getAddresses()
        );
    }
}
