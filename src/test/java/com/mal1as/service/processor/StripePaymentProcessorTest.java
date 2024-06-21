package com.mal1as.service.processor;

import com.mal1as.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StripePaymentProcessorTest {

    @Test
    void makePayment() {
        final StripePaymentProcessor processor = new StripePaymentProcessor();
        assertDoesNotThrow(() -> processor.makePayment(100));
        assertDoesNotThrow(() -> processor.makePayment(100.001));
        assertDoesNotThrow(() -> processor.makePayment(100000));
        assertDoesNotThrow(() -> processor.makePayment(1000000));
    }

    @Test
    void makePaymentWithThrow() {
        final StripePaymentProcessor processor = new StripePaymentProcessor();
        assertThrows(ValidationException.class, () -> processor.makePayment(99.999));
        assertThrows(ValidationException.class, () -> processor.makePayment(99));
        assertThrows(ValidationException.class, () -> processor.makePayment(0));
    }
}