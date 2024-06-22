package com.mal1as.service;

import com.mal1as.exception.ValidationException;
import com.mal1as.model.dto.request.PurchaseRequest;
import com.mal1as.service.processor.PaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PriceService priceService;
    private final Map<String, PaymentProcessor> paymentProcessors;

    @Transactional(readOnly = true)
    public void makePurchase(PurchaseRequest purchaseRequest) {
        final Double price = priceService.calculatePrice(purchaseRequest);
        Optional.ofNullable(paymentProcessors.get(purchaseRequest.getPaymentProcessor()))
                .orElseThrow(() -> new ValidationException("Payment processor not found by name = " +
                        purchaseRequest.getPaymentProcessor()))
                .makePayment(price);
    }
}
