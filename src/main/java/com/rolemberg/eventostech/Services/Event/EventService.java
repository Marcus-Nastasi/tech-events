package com.rolemberg.eventostech.Services.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.EventsResponseDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Address.AddressService;
import com.rolemberg.eventostech.Util.FileToS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        Timestamp sqlCurrentDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());
        Timestamp sqlStartDate = (start_date != null) ? Timestamp.valueOf(start_date.atStartOfDay()) : null;
        Timestamp sqlEndDate = (end_date != null) ? Timestamp.valueOf(end_date.atStartOfDay()) : null;
        Page<Event> eventPage = this.eventRepo.findFilteredEvents(
            sqlCurrentDate,
            title,
            city,
            uf,
            sqlStartDate,
            sqlEndDate,
            pageable
        );
        return eventPage.map(this::mapToEventsResponseDTO).toList();
    }

    public Event createEvent(EventRegisterDTO data) {
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

    public Event updateEvent(UUID id, EventRegisterDTO data) throws NoSuchElementException {
        Event e = eventRepo
            .findById(id)
            .orElseThrow();
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
            .orElseThrow();
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
