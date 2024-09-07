package com.rolemberg.eventostech.Services.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CouponEventResponseDTO;
import com.rolemberg.eventostech.Domain.Event.Event;
import com.rolemberg.eventostech.Handlers.AppError;
import com.rolemberg.eventostech.Repository.Coupon.CouponRepo;
import com.rolemberg.eventostech.Repository.Event.EventRepo;
import com.rolemberg.eventostech.Services.Event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public List<CouponEventResponseDTO> get(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Coupon> couponPage = couponRepo.findAll(pageable);
        return couponPage.map(this::mapToCouponEventResponseDTO).toList();
    }

    public CouponEventResponseDTO create(UUID event_id, CouponRegisterDTO data) {
        Event e = eventRepo
            .findById(event_id)
            .orElseThrow(() -> new AppError("Error finding associated event while creating the coupon"));
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
        return mapToCouponEventResponseDTO(c);
    }

    public CouponEventResponseDTO update(UUID id, CouponRegisterDTO data) {
        Coupon c = couponRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Error finding the coupon while trying to update"));
        c.setCode(data.code());
        c.setValid(data.valid());
        c.setDiscount(data.discount());
        couponRepo.save(c);
        return mapToCouponEventResponseDTO(c);
    }

    public CouponEventResponseDTO delete(UUID id) {
        Coupon c = couponRepo
            .findById(id)
            .orElseThrow(() -> new AppError("Error finding the coupon while trying to delete"));
        couponRepo.deleteById(id);
        return mapToCouponEventResponseDTO(c);
    }

    public CouponEventResponseDTO mapToCouponEventResponseDTO(Coupon c) {
        return new CouponEventResponseDTO(
            c.getId(),
            c.getCode(),
            c.getDiscount(),
            c.getValid(),
            eventService.mapToEventCleanResponseDTO(c.getEvent())
        );
    }
}
