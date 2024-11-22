package com.rolemberg.eventostech.application.web.request.address;

import com.rolemberg.eventostech.domain.event.Event;

public record AddressRequestDto(
    String city,
    String uf,
    Event event
) {}
