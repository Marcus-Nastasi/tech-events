package com.rolemberg.eventostech.Domain.Event;

import java.time.LocalDate;
import java.util.UUID;

public record EventCleanResponseDTO(
    UUID id,
    String title,
    String description,
    LocalDate date,
    Boolean remote,
    String image_url,
    String event_url
) {}
