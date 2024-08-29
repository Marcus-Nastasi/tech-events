package com.rolemberg.eventostech.Repository.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, String> {
}
