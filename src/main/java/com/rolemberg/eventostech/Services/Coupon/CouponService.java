package com.rolemberg.eventostech.Services.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CpnResponseEDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Repository.Coupon.CouponRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private EventRepo eventRepo;

    public List<Coupon> get() {
        List<Coupon> coupons = couponRepo.findAll();
        coupons.forEach(c -> Hibernate.initialize(c.getEvent()));
        return coupons;
    }

    public Coupon create(UUID event_id, CouponRegisterDTO data) {
        Event e = eventRepo
            .findById(event_id)
            .orElseThrow(IllegalArgumentException::new);
        Coupon c = new Coupon();
        c.setCode(data.code());
        c.setDiscount(data.discount());
        c.setValid(data.valid());
        c.setEvent(e);
        couponRepo.save(c);
        List<Coupon> toAddNewCoupon = e.getCoupons();
        toAddNewCoupon.add(c);
        e.setCoupons(toAddNewCoupon);
        return c;
    }
}
