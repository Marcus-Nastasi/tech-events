package com.rolemberg.eventostech.Domain.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import jakarta.persistence.*;

import java.util.UUID;

public record AddressEResponseDTO(
        UUID id,
        String city,
        String uf,
        EventCleanResponseDTO event
) {}
