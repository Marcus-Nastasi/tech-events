package com.rolemberg.eventostech.resource.services.coupon;

import com.rolemberg.eventostech.domain.coupon.Coupon;
import com.rolemberg.eventostech.application.web.request.coupon.CouponRequestDto;
import com.rolemberg.eventostech.application.web.response.coupon.CouponEventResponseDTO;
import com.rolemberg.eventostech.domain.event.Event;
import com.rolemberg.eventostech.web.handlers.AppError;
import com.rolemberg.eventostech.resource.repository.coupon.CouponRepo;
import com.rolemberg.eventostech.resource.repository.event.EventRepo;
import com.rolemberg.eventostech.resource.services.event.EventService;
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

    public CouponEventResponseDTO create(UUID event_id, CouponRequestDto data) {
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

    public CouponEventResponseDTO update(UUID id, CouponRequestDto data) {
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
