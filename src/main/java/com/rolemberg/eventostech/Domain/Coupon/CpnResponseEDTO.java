package com.rolemberg.eventostech.Domain.Coupon;

import com.rolemberg.eventostech.Domain.Event.Event;

import java.time.LocalDate;
import java.util.UUID;

public record CpnResponseEDTO(
    UUID id,
    String code,
    Double discount,
    LocalDate valid,
    Event event
) {}
