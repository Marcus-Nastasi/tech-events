package com.rolemberg.eventostech.Domain.Event;

import com.rolemberg.eventostech.Domain.Address.Address;
import com.rolemberg.eventostech.Domain.Coupon.Coupon;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record EventsResponseDTO(
    UUID id,
    String title,
    String description,
    LocalDate date,
    Boolean remote,
    String image_url,
    String event_url,
    List<Coupon> coupons,
    List<Address> addresses
) {}
