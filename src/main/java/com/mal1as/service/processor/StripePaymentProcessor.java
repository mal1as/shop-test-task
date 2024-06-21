package com.mal1as.service.processor;

import com.mal1as.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentProcessor implements PaymentProcessor {

    @Override
    public void makePayment(double price) {
        if (!pay((float) price)) throw new ValidationException("Payment error");
    }

    private boolean pay(Float price) {
        return price >= 100;
    }
}
