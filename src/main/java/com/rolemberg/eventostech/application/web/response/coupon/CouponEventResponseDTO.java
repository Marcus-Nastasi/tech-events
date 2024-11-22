package com.rolemberg.eventostech.application.web.response.coupon;

import com.rolemberg.eventostech.application.web.response.event.EventCleanResponseDTO;

import java.time.LocalDate;
import java.util.UUID;

public record CouponEventResponseDTO(
    UUID id,
    String code,
    Double discount,
    LocalDate valid,
    EventCleanResponseDTO event
) {}
