package com.mal1as.service;

import com.mal1as.model.dto.request.PriceRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final ProductService productService;
    private final TaxService taxService;
    private final CouponService couponService;

    @Transactional(readOnly = true)
    public Double calculatePrice(PriceRequest priceRequest) {
        final Double productPrice = productService.findById(priceRequest.getProduct()).getPrice();
        final Integer taxPercent = taxService.findByNumber(priceRequest.getTaxNumber()).getPercent();
        final Integer discountPercent = priceRequest.getCouponCode() == null ? 0 :
                couponService.findByCode(priceRequest.getCouponCode()).getPercent();
        return calculatePrice(productPrice, taxPercent, discountPercent);
    }

    private Double calculatePrice(Double productPrice, Integer taxPercent, Integer discountPercent) {
        final double priceWithDiscount = productPrice - discountPercent * productPrice / 100;
        return Precision.round(priceWithDiscount + priceWithDiscount * taxPercent / 100, 3);
    }
}
