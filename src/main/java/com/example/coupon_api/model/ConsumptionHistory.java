package com.example.coupon_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerEmail;
    private String orderId;

    @ManyToOne
    private Coupon coupon;

    private LocalDateTime usedAt = LocalDateTime.now();
}
