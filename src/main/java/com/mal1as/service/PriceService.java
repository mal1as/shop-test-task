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

        final Double priceWithDiscount = calculatePriceWithDiscount(productPrice, priceRequest.getCouponCode());
        return calculatePriceWithTax(priceWithDiscount, taxPercent);
    }

    private Double calculatePriceWithDiscount(Double productPrice, String couponCode) {
        if (couponCode == null) return productPrice;
        return couponService.findByCode(couponCode).calculatePriceWithDiscount(productPrice);
    }

    private Double calculatePriceWithTax(Double price, Integer taxPercent) {
        return Precision.round(price + price * taxPercent / 100, 3);
    }
}
