package com.rolemberg.eventostech.application.web.request.event;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record EventRequestDto(
    String title,
    String description,
    LocalDate date,
    String city,
    String state,
    Boolean remote,
    String event_url,
    MultipartFile image
) {}
