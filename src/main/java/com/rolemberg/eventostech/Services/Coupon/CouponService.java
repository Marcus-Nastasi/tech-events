package com.rolemberg.eventostech.Services.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Repository.Coupon.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepo couponRepo;

    public List<Coupon> get() {
        return couponRepo.findAll();
    }
}
