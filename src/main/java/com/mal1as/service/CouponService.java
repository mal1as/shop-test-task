package com.mal1as.service;

import com.mal1as.exception.ValidationException;
import com.mal1as.model.entity.Coupon;
import com.mal1as.model.enums.CouponType;
import com.mal1as.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional(readOnly = true)
    public Coupon findByCode(String code) {
        return couponRepository.findByCode(code)
                .orElseThrow(() -> new ValidationException("Coupon not found by code = " + code));
    }
}
