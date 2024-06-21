package com.mal1as.service.processor;

import com.mal1as.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service("paypal")
public class PayPalPaymentProcessor implements PaymentProcessor {

    @Override
    public void makePayment(double price) {
        makePayment(Integer.valueOf((int) Math.ceil(price)));
    }

    private void makePayment(Integer price) {
        if (price > 100000) throw new ValidationException("Payment error: Price must be <= 100000");
    }
}
