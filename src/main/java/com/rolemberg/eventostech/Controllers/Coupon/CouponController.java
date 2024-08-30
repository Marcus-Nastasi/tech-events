package com.rolemberg.eventostech.Controllers.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Services.Coupon.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coupon")
@RestControllerAdvice
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all coupons")
    @ApiResponse(responseCode = "200", description = "Found the coupons")
    public ResponseEntity<List<Coupon>> get() {
        return ResponseEntity.ok(couponService.get());
    }



}
