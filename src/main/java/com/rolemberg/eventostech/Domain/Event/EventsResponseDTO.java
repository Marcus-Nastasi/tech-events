package com.rolemberg.eventostech.Domain.Event;

import java.time.LocalDate;
import java.util.UUID;

public record EventsResponseDTO(UUID id, String title, String description, LocalDate date, String city, String state, Boolean remote, String event_url) {
}
