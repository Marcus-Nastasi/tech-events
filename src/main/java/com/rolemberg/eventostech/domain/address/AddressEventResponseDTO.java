package com.rolemberg.eventostech.domain.address;

import com.rolemberg.eventostech.domain.event.EventCleanResponseDTO;

import java.util.UUID;

public record AddressEventResponseDTO(
    UUID id,
    String city,
    String uf,
    EventCleanResponseDTO event
) {}
