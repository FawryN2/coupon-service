package com.example.coupon_api.repository;

import com.example.coupon_api.model.ConsumptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {
}