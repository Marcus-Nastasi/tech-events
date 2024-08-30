package com.rolemberg.eventostech.Controllers.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.EventsResponseDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "")
    public ResponseEntity<List<EventsResponseDTO>> get(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity
            .ok(eventService.getEvents(page, size));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getSingle(
        @PathVariable("id") UUID id
    ) {
        return ResponseEntity
            .ok(eventRepo.findById(id).orElseThrow());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Event> create(
        @RequestBody EventRegisterDTO data
    ) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(eventService.createEvent(data));
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Event> update(
        @PathVariable("id") UUID id,
        @RequestBody EventRegisterDTO data
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(eventService.updateEvent(id, data));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Event> delete(
        @PathVariable("id") UUID id
    ) {
        return ResponseEntity
            .ok(eventService.deleteEvent(id));
    }
}
