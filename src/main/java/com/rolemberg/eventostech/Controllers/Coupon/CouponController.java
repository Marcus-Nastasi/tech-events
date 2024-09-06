package com.rolemberg.eventostech.Controllers.Coupon;

import com.rolemberg.eventostech.Domain.Coupon.CouponRegisterDTO;
import com.rolemberg.eventostech.Domain.Coupon.CouponEventResponseDTO;
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
    public ResponseEntity<Map<String, List<CouponEventResponseDTO>>> get(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(Map.of("data", couponService.get(page, size)));
    }

    @PostMapping(value = "/event/{event_id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "Create a new coupon")
    @ApiResponse(responseCode = "201", description = "Creating a coupon")
    public ResponseEntity<Map<String, List<CouponEventResponseDTO>>> create(
                @PathVariable("event_id") UUID event_id,
                @RequestBody @Valid CouponRegisterDTO data
    ) {
        CouponEventResponseDTO c = couponService.create(event_id, data);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(Map.of("data", List.of(c)));
    }

    @PatchMapping(value = "/update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Update a coupon")
    @ApiResponse(responseCode = "200", description = "Updating a coupon")
    public ResponseEntity<Map<String, CouponEventResponseDTO>> update(
                @PathVariable("id") UUID id,
                @RequestBody @Valid CouponRegisterDTO data
    ) {
        CouponEventResponseDTO c = couponService.update(id, data);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(Map.of("data", c));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "Delete a coupon")
    @ApiResponse(responseCode = "200", description = "Deleting a coupon")
    public ResponseEntity<Map<String, CouponEventResponseDTO>> delete(@PathVariable("id") UUID id) {
        CouponEventResponseDTO c = couponService.delete(id);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(Map.of("data", c));
    }
}
