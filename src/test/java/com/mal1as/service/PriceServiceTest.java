package com.mal1as.service;

import com.mal1as.model.dto.request.PriceRequest;
import com.mal1as.model.entity.CouponFixed;
import com.mal1as.model.entity.CouponPercent;
import com.mal1as.model.entity.Product;
import com.mal1as.model.entity.Tax;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private ProductService productService;

    @Mock
    private TaxService taxService;

    @Mock
    private CouponService couponService;

    @InjectMocks
    private PriceService priceService;

    @Test
    void calculatePriceWithPercentCoupon() {
        when(productService.findById(1L)).thenReturn(Product.builder().price(100.0).build());
        when(taxService.findByNumber("GR123456789")).thenReturn(Tax.builder().percent(24).build());
        when(taxService.findByNumber("MC123456789")).thenReturn(Tax.builder().percent(0).build());
        when(taxService.findByNumber("UV123456789")).thenReturn(Tax.builder().percent(150).build());
        when(couponService.findByCode("P10")).thenReturn(CouponPercent.builder().percent(10).build());
        when(couponService.findByCode("P25")).thenReturn(CouponPercent.builder().percent(25).build());
        when(couponService.findByCode("P100")).thenReturn(CouponPercent.builder().percent(100).build());

        final PriceRequest request1 = PriceRequest.builder()
                .product(1L)
                .taxNumber("GR123456789")
                .couponCode("P10")
                .build();
        assertEquals(111.6, priceService.calculatePrice(request1));

        final PriceRequest request2 = PriceRequest.builder()
                .product(1L)
                .taxNumber("GR123456789")
                .couponCode("P25")
                .build();
        assertEquals(93, priceService.calculatePrice(request2));

        final PriceRequest request3 = PriceRequest.builder()
                .product(1L)
                .taxNumber("GR123456789")
                .couponCode("P100")
                .build();
        assertEquals(0, priceService.calculatePrice(request3));

        final PriceRequest request4 = PriceRequest.builder()
                .product(1L)
                .taxNumber("MC123456789")
                .couponCode("P10")
                .build();
        assertEquals(90, priceService.calculatePrice(request4));

        final PriceRequest request5 = PriceRequest.builder()
                .product(1L)
                .taxNumber("UV123456789")
                .couponCode("P10")
                .build();
        assertEquals(225, priceService.calculatePrice(request5));

        final PriceRequest request6 = PriceRequest.builder()
                .product(1L)
                .taxNumber("UV123456789")
                .couponCode("P25")
                .build();
        assertEquals(187.5, priceService.calculatePrice(request6));
    }

    @Test
    void calculatePriceWithFixedCoupon() {
        when(productService.findById(1L)).thenReturn(Product.builder().price(100.0).build());
        when(taxService.findByNumber("GR123456789")).thenReturn(Tax.builder().percent(24).build());
        when(taxService.findByNumber("MC123456789")).thenReturn(Tax.builder().percent(0).build());
        when(taxService.findByNumber("UV123456789")).thenReturn(Tax.builder().percent(150).build());
        when(couponService.findByCode("F20")).thenReturn(CouponFixed.builder().sum(20).build());
        when(couponService.findByCode("F100")).thenReturn(CouponFixed.builder().sum(100).build());

        final PriceRequest request1 = PriceRequest.builder()
                .product(1L)
                .taxNumber("GR123456789")
                .couponCode("F20")
                .build();
        assertEquals(99.2, priceService.calculatePrice(request1));

        final PriceRequest request2 = PriceRequest.builder()
                .product(1L)
                .taxNumber("GR123456789")
                .couponCode("F100")
                .build();
        assertEquals(0, priceService.calculatePrice(request2));

        final PriceRequest request3 = PriceRequest.builder()
                .product(1L)
                .taxNumber("MC123456789")
                .couponCode("F20")
                .build();
        assertEquals(80, priceService.calculatePrice(request3));

        final PriceRequest request4 = PriceRequest.builder()
                .product(1L)
                .taxNumber("UV123456789")
                .couponCode("F20")
                .build();
        assertEquals(200, priceService.calculatePrice(request4));
    }
}