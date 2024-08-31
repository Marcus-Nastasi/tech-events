package com.rolemberg.eventostech.Domain.Coupon;

import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;

import java.time.LocalDate;
import java.util.UUID;

public record CouponEventResponseDTO(
    UUID id,
    String code,
    Double discount,
    LocalDate valid,
    EventCleanResponseDTO event
) {}
