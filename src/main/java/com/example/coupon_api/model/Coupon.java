package com.example.coupon_api.model;

import com.example.coupon_api.enums.DiscountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private int usageLimit;

    private int usedCount = 0;

    private LocalDate expiryDate=LocalDate.now();

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private double discountValue;
}
