package com.rolemberg.eventostech.Domain.Event;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public record EventRegisterDTO(String title, String description, LocalDate date, String city, String state, Boolean remote, String event_url) {
}
