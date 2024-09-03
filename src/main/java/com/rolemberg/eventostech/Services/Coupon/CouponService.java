package com.rolemberg.eventostech.Services.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CouponEventResponseDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Repository.Coupon.CouponRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private EventService eventService;

    public List<CouponEventResponseDTO> get() {
        List<Coupon> coupons = couponRepo.findAll();
        List<CouponEventResponseDTO> couponEventResponseDTOS = new ArrayList<>();
        coupons.forEach(c -> {
            couponEventResponseDTOS
                .add(new CouponEventResponseDTO(
                    c.getId(), c.getCode(), c.getDiscount(), c.getValid(),
                    eventService.mapToEventCleanResponseDTO(c.getEvent())
                ));
        });
        return couponEventResponseDTOS;
    }

    public CouponEventResponseDTO create(UUID event_id, CouponRegisterDTO data) {
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
        eventRepo.save(e);
        return new CouponEventResponseDTO(
            c.getId(),
            c.getCode(),
            c.getDiscount(),
            c.getValid(),
            eventService.mapToEventCleanResponseDTO(c.getEvent())
        );
    }

    public CouponEventResponseDTO update(UUID id, CouponRegisterDTO data) {
        Coupon c = couponRepo
            .findById(id)
            .orElseThrow(IllegalArgumentException::new);
        c.setCode(data.code());
        c.setValid(data.valid());
        c.setDiscount(data.discount());
        couponRepo.save(c);
        return new CouponEventResponseDTO(
            c.getId(),
            c.getCode(),
            c.getDiscount(),
            c.getValid(),
            eventService.mapToEventCleanResponseDTO(c.getEvent())
        );
    }

    public CouponEventResponseDTO delete(UUID id) {
        Coupon c = couponRepo
            .findById(id)
            .orElseThrow(IllegalArgumentException::new);
        couponRepo.deleteById(id);
        return new CouponEventResponseDTO(
            c.getId(),
            c.getCode(),
            c.getDiscount(),
            c.getValid(),
            eventService.mapToEventCleanResponseDTO(c.getEvent())
        );
    }
}
