//package com.example.coupon_api.integration;
//
//import com.example.coupon_api.model.Coupon;
//import com.example.coupon_api.enums.DiscountType;
//import com.example.coupon_api.repository.CouponRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//
//import java.time.LocalDate;
//
////import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class CouponApiIntegrationTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private CouponRepository couponRepository;
//
//    @Test
//    void testCreateAndFetchCoupon() {
//        Coupon coupon = new Coupon(null, "INTSAVE", 5, 0, LocalDate.now().plusDays(7), DiscountType.FIXED, 20.0);
//        ResponseEntity<Coupon> response = restTemplate.postForEntity("http://localhost:" + port + "/api/coupons", coupon, Coupon.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        Coupon saved = response.getBody();
//        assertThat(saved).isNotNull();
//        assertThat(saved.getCode()).isEqualTo("INTSAVE");
//
//        ResponseEntity<Coupon[]> allCoupons = restTemplate.getForEntity("http://localhost:" + port + "/api/coupons", Coupon[].class);
//        assertThat(allCoupons.getBody()).isNotEmpty();
//    }
//}
