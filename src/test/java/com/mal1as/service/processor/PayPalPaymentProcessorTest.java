package com.mal1as.service.processor;

import com.mal1as.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PayPalPaymentProcessorTest {

    @Test
    void makePayment() {
        final PayPalPaymentProcessor processor = new PayPalPaymentProcessor();
        assertDoesNotThrow(() -> processor.makePayment(0));
        assertDoesNotThrow(() -> processor.makePayment(0.1));
        assertDoesNotThrow(() -> processor.makePayment(100));
        assertDoesNotThrow(() -> processor.makePayment(100000));
    }

    @Test
    void makePaymentWithThrow() {
        final PayPalPaymentProcessor processor = new PayPalPaymentProcessor();
        assertThrows(ValidationException.class, () -> processor.makePayment(100000.000001));
        assertThrows(ValidationException.class, () -> processor.makePayment(100001));
        assertThrows(ValidationException.class, () -> processor.makePayment(1000000));
    }
}