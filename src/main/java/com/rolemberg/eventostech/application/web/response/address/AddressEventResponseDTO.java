package com.rolemberg.eventostech.application.web.response.address;

import com.rolemberg.eventostech.application.web.response.event.EventCleanResponseDTO;

import java.util.UUID;

public record AddressEventResponseDTO(
    UUID id,
    String city,
    String uf,
    EventCleanResponseDTO event
) {}
