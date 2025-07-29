package com.example.coupon_api.exception;

public class CouponExpiredException extends RuntimeException{

    public CouponExpiredException(String message) {
        super(message);
    }
}
