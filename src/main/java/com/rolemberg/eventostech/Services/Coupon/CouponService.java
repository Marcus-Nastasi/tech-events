package com.rolemberg.eventostech.Services.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CouponEventResponseDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Domain.Event.EventCleanResponseDTO;
import com.rolemberg.eventostech.Repository.Coupon.CouponRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
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

    public List<CouponEventResponseDTO> get() {
        List<Coupon> coupons = couponRepo.findAll();
        List<CouponEventResponseDTO> couponEventResponseDTOS = new ArrayList<>();
        coupons.forEach(c -> {
            EventCleanResponseDTO eventCleanResponseDTO = new EventCleanResponseDTO(
                c.getEvent().getId(), c.getEvent().getTitle(), c.getEvent().getDescription(),
                c.getEvent().getDate(), c.getEvent().getRemote(), c.getEvent().getImage_url(),
                c.getEvent().getEvent_url()
            );
            couponEventResponseDTOS
                .add(new CouponEventResponseDTO(
                    c.getId(), c.getCode(), c.getDiscount(), c.getValid(), eventCleanResponseDTO
                ));
        });
        return couponEventResponseDTOS;
    }

    public CouponEventResponseDTO create(UUID event_id, CouponRegisterDTO data) {
        Event e = eventRepo.findById(event_id).orElseThrow(IllegalArgumentException::new);
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
        EventCleanResponseDTO eventCleanResponseDTO = new EventCleanResponseDTO(
            e.getId(), e.getTitle(), e.getDescription(), e.getDate(),
            e.getRemote(), e.getImage_url(), e.getEvent_url()
        );
        return new CouponEventResponseDTO(
            c.getId(),
            c.getCode(),
            c.getDiscount(),
            c.getValid(),
            eventCleanResponseDTO
        );
    }
}
