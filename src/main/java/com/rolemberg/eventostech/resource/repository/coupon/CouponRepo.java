package com.rolemberg.eventostech.resource.repository.coupon;

import com.rolemberg.eventostech.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepo extends JpaRepository<Coupon, UUID> {
}
