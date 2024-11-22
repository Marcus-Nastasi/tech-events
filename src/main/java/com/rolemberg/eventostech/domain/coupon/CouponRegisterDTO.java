package com.rolemberg.eventostech.domain.coupon;

import java.time.LocalDate;

public record CouponRegisterDTO(String code, Double discount, LocalDate valid) {
}
