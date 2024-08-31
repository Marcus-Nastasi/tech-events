package com.rolemberg.eventostech.Controllers.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.Coupon;
import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CpnResponseEDTO;
import com.rolemberg.eventostech.Services.Coupon.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @PostMapping(value = "/event/{event_id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Create a new coupon")
    @ApiResponse(responseCode = "201", description = "Creating a coupon")
    public ResponseEntity<Map<String, List<Coupon>>> create(
            @PathVariable("event_id") UUID event_id,
            @RequestBody @Valid CouponRegisterDTO data
    ) {
        Coupon c = couponService.create(event_id, data);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Map.of("data", List.of(c)));
    }
}
