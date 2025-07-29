package com.example.coupon_api.controller;

import com.example.coupon_api.model.Coupon;
import com.example.coupon_api.model.ConsumptionHistory;
import com.example.coupon_api.service.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid Coupon coupon) {
        return ResponseEntity.ok(couponService.createCoupon(coupon));
    }

    @PostMapping("/consume")
    public ResponseEntity<String> consumeCoupon(@RequestParam String code,
                                                @RequestParam String orderId) {
        couponService.consumeCoupon(code, orderId);
        return ResponseEntity.ok("Coupon consumed successfully");
    }


    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/history")
    public List<ConsumptionHistory> getAllHistory() {
        return couponService.getAllHistory();
    }
}
