package com.rolemberg.eventostech.Services.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.EventsResponseDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private AddressService addressService;

    public List<EventsResponseDTO> getEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventPage = this.eventRepo.findAll(pageable);
        return eventPage.map(this::mapToEventsResponseDTO).toList();
    }

    public Event createEvent(EventRegisterDTO data) {
        Event e = new Event();
        e.setTitle(data.title());
        e.setDescription(data.description());
        e.setImage_url(null);
        e.setEvent_url(data.event_url());
        e.setRemote(data.remote());
        e.setDate(data.date());
        e.setCoupons(new ArrayList<>());
        e.setAddresses(new ArrayList<>());
        eventRepo.save(e);
        if (!data.remote()) {
            e.getAddresses().add(this.addressService.create(data, e));
            eventRepo.save(e);
        }
        return e;
    }

    public Event updateEvent(UUID id, EventRegisterDTO data) throws NoSuchElementException {
        Event e = eventRepo.findById(id).orElseThrow();
        e.setTitle(data.title());
        e.setDescription(data.description());
        e.setImage_url(null);
        e.setEvent_url(data.event_url());
        e.setRemote(data.remote());
        e.setDate(data.date());
        eventRepo.save(e);
        return e;
    }

    public Event deleteEvent(UUID id) throws NoSuchElementException {
        Event e = eventRepo.findById(id).orElseThrow();
        eventRepo.deleteById(id);
        return e;
    }

    private String uploadToS3(MultipartFile image) {
        return "";
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
