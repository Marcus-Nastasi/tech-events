package com.rolemberg.eventostech.Controllers.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.EventsResponseDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/events")
@RestControllerAdvice
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get events")
    @ApiResponse(responseCode = "200", description = "Finding events")
    public ResponseEntity<List<EventsResponseDTO>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity
            .ok(eventService.getEvents(page, size));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get single address")
    @ApiResponse(responseCode = "200", description = "Finding one event")
    public ResponseEntity<Event> getSingle(@PathVariable("id") UUID id) {
        return ResponseEntity
            .ok(eventRepo.findById(id).orElseThrow());
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating address")
    @ApiResponse(responseCode = "201", description = "Creating the event")
    public ResponseEntity<Event> create(@RequestBody EventRegisterDTO data) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(eventService.createEvent(data));
    }

    @PatchMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Updating address")
    @ApiResponse(responseCode = "200", description = "Updating one event")
    public ResponseEntity<Event> update(
            @PathVariable("id") UUID id,
            @RequestBody EventRegisterDTO data
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(eventService.updateEvent(id, data));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deleting event")
    @ApiResponse(responseCode = "200", description = "Deleting one event")
    public ResponseEntity<Event> delete(@PathVariable("id") UUID id) {
        Event e = eventService.deleteEvent(id);
        if (e == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(e);
    }
}
