package com.rolemberg.eventostech.Domain.Coupon;

import java.time.LocalDate;

public record CouponRegisterDTO(String code, Double discount, LocalDate valid) {
}
