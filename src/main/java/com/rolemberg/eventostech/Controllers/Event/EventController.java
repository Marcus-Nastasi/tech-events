package com.rolemberg.eventostech.Controllers.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "")
    public ResponseEntity<List<Event>> get() {
        return ResponseEntity
            .ok(eventRepo.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Event> create(@RequestBody EventRegisterDTO data) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(eventService.createEvent(data));
    }
}
