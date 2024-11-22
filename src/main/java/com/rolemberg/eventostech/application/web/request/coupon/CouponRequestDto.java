package com.rolemberg.eventostech.application.web.request.coupon;

import java.time.LocalDate;

public record CouponRequestDto(String code, Double discount, LocalDate valid) {}
