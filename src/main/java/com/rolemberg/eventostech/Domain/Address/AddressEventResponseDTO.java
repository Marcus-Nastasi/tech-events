package com.rolemberg.eventostech.Domain.Address;

import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;

import java.util.UUID;

public record AddressEventResponseDTO(
    UUID id,
    String city,
    String uf,
    EventCleanResponseDTO event
) {}
