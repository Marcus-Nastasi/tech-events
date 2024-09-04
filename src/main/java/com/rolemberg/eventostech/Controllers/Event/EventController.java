package com.rolemberg.eventostech.Controllers.Event;

import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventRegisterDTO;
import com.rolemberg.eventostech.Domain.Event.EventsResponseDTO;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Map<String, List<EventsResponseDTO>>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity
            .ok(Map.of("data", eventService.getEvents(page, size)));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get single address")
    @ApiResponse(responseCode = "200", description = "Finding one event")
    public ResponseEntity<Map<String, Event>> getSingle(@PathVariable("id") UUID id) {
        return ResponseEntity
            .ok(Map.of("data", eventRepo.findById(id).orElseThrow()));
    }

    @GetMapping(value = "/filter")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get filtered events")
    @ApiResponse(responseCode = "200", description = "Finding filtered events")
    public ResponseEntity<Map<String, List<EventsResponseDTO>>> getFilteredEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String uf,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  start_date,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  end_date
    ) {
        return ResponseEntity
            .ok(Map.of("data", eventService.getFilteredEvents(page, size, title, city, uf, start_date, end_date)));
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating address")
    @ApiResponse(responseCode = "201", description = "Creating the event")
    public ResponseEntity<Map<String, Event>> create(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("date") LocalDate date,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("remote") Boolean remote,
            @RequestParam("event_url") String event_url,
            @RequestParam("image") MultipartFile image
    ) {
        EventRegisterDTO eventRegisterDTO = new EventRegisterDTO(
            title, description, date, city, state, remote, event_url, image
        );
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Map.of("data", eventService.createEvent(eventRegisterDTO)));
    }

    @PatchMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Updating address")
    @ApiResponse(responseCode = "200", description = "Updating one event")
    public ResponseEntity<Map<String, Event>> update(
            @PathVariable("id") UUID id,
            @RequestBody EventRegisterDTO data
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(Map.of("data", eventService.updateEvent(id, data)));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deleting event")
    @ApiResponse(responseCode = "200", description = "Deleting one event")
    public ResponseEntity<Map<String, Event>> delete(@PathVariable("id") UUID id) {
        Event e = eventService.deleteEvent(id);
        if (e == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(Map.of("data", e));
    }
}
