package com.rolemberg.eventostech.domain.coupon;

import com.rolemberg.eventostech.domain.event.EventCleanResponseDTO;

import java.time.LocalDate;
import java.util.UUID;

public record CouponEventResponseDTO(
    UUID id,
    String code,
    Double discount,
    LocalDate valid,
    EventCleanResponseDTO event
) {}
