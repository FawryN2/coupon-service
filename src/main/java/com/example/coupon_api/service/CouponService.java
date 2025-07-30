package com.example.coupon_api.service;

import com.example.coupon_api.exception.CouponExpiredException;
import com.example.coupon_api.model.Coupon;
import com.example.coupon_api.model.ConsumptionHistory;
import com.example.coupon_api.repository.CouponRepository;
import com.example.coupon_api.repository.ConsumptionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepo;
    private final ConsumptionHistoryRepository historyRepo;

    public Coupon createCoupon(Coupon coupon) {
        return couponRepo.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

    public List<ConsumptionHistory> getAllHistory() {
        return historyRepo.findAll();
    }

    public double consumeCoupon(String code, String orderId, double orderTotal) {
        Coupon coupon = couponRepo.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        if (coupon.getExpiryDate().isBefore(LocalDate.now())) {
            throw new CouponExpiredException("Coupon has expired");
        }

        if (orderTotal < coupon.getMinOrder()) {
            throw new RuntimeException("Order total value must be at least : " + coupon.getMinOrder()  + "for the coupon to be applied");
        }

        if (coupon.getUsedCount() >= coupon.getUsageLimit()) {
            throw new RuntimeException("Coupon usage limit reached");
        }

        coupon.setUsedCount(coupon.getUsedCount() + 1);
        couponRepo.save(coupon);

        ConsumptionHistory history = new ConsumptionHistory();
        history.setCoupon(coupon);
        history.setOrderId(orderId);
        history.setOrderTotal(orderTotal);
        history.setUsedAt(LocalDateTime.now());
        historyRepo.save(history);

        // Calculate discount value

        return switch (coupon.getDiscountType()) {
            case PERCENTAGE -> orderTotal * (coupon.getDiscountValue() / 100);
            case FIXED -> coupon.getDiscountValue();
            default -> throw new RuntimeException("Unknown discount type");
        };
    }

}

