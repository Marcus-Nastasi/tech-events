package com.rolemberg.eventostech.application.web.controllers.event;

import com.rolemberg.eventostech.domain.event.Event;
import com.rolemberg.eventostech.application.web.request.event.EventRequestDto;
import com.rolemberg.eventostech.application.web.response.event.EventsResponseDTO;
import com.rolemberg.eventostech.web.handlers.AppError;
import com.rolemberg.eventostech.resource.repository.event.EventRepo;
import com.rolemberg.eventostech.resource.services.event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RestControllerAdvice
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping(value = "/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepo eventRepo;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get filtered events", description = "You can get all events, paginating, and filtering.")
    @ApiResponse(responseCode = "200", description = "Finding filtered events")
    public ResponseEntity<List<EventsResponseDTO>> getFilteredEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String uf,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  start_date,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  end_date
    ) {
        List<EventsResponseDTO> e = eventService
            .getFilteredEvents(page, size, title, city, uf, start_date, end_date);
        if (e == null) throw new AppError("Error while getting the events.");
        return ResponseEntity.ok(e);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get single event", description = "You can get a single event.")
    @ApiResponse(responseCode = "200", description = "Finding one event")
    public ResponseEntity<Event> getSingle(@PathVariable("id") UUID id) {
        Event e = eventRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Error finding the event."));
        return ResponseEntity.ok(e);
    }

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creating event", description = "You can get register an event.")
    @ApiResponse(responseCode = "201", description = "Creating the event")
    public ResponseEntity<Event> create(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("date") LocalDate date,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("remote") Boolean remote,
            @RequestParam("event_url") String event_url,
            @Parameter(description = "Imagem a ser enviada", required = true)
            @RequestParam("image") MultipartFile image
    ) {
        if (image.isEmpty()) throw new AppError("Need to send an image");
        EventRequestDto eventRegisterDTO = new EventRequestDto(
            title, description, date, city, state, remote, event_url, image
        );
        Event e = eventService.createEvent(eventRegisterDTO);
        if (e == null) throw new AppError("Error while creating the event.");
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(e);
    }

    @PatchMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Updating event")
    @ApiResponse(responseCode = "200", description = "Updating event")
    public ResponseEntity<Event> update(
            @PathVariable("id") UUID id,
            @RequestBody @Valid EventRequestDto data) {
        Event e = eventService.updateEvent(id, data);
        if (e == null) throw new AppError("Error while updating the event.");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(e);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Deleting event")
    @ApiResponse(responseCode = "200", description = "Deleting event")
    public ResponseEntity<Event> delete(@PathVariable("id") UUID id) {
        Event e = eventService.deleteEvent(id);
        if (e == null) throw new AppError("Error while deleting the event.");
        return ResponseEntity.ok(e);
    }
}
