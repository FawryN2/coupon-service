//package com.example.coupon_api.service;
//
//import com.example.coupon_api.enums.DiscountType;
//import com.example.coupon_api.model.Coupon;
//import com.example.coupon_api.repository.CouponRepository;
//import com.example.coupon_api.repository.ConsumptionHistoryRepository;
//import lombok.AllArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@AllArgsConstructor
//class CouponServiceTest {
//
//    @MockBean
//    private CouponRepository couponRepository;
//
//    @MockBean
//    private ConsumptionHistoryRepository historyRepository;
//
//    private final CouponService couponService;
//
//    @Test
//    void testCreateCoupon() {
//        Coupon c = new Coupon(null, "SAVE10", 10, 0, LocalDate.now().plusDays(5), DiscountType.FIXED, 10.0);
//        when(couponRepository.save(any())).thenReturn(c);
//
//        Coupon result = couponService.createCoupon(c);
//
//        assertEquals("SAVE10", result.getCode());
//    }
//}
