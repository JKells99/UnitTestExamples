package com.keyin.entities;

import com.keyin.services.PaymentProcessor;
import com.keyin.services.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Mock
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentProcessor);
    }

    @Test
    public void testMakePayment_Success() {
        double amount = 100.0;
        when(paymentProcessor.processPayment(amount)).thenReturn(true);

        boolean result = paymentService.makePayment(amount);

        Assertions.assertTrue(result);
        verify(paymentProcessor).processPayment(amount);
    }

    @Test
    public void testMakePayment_Failure() {
        double amount = 100.0;
        when(paymentProcessor.processPayment(amount)).thenReturn(false);

        boolean result = paymentService.makePayment(amount);

        Assertions.assertFalse(result);
        verify(paymentProcessor).processPayment(amount);
    }

    @Test
    public void testMakePayment_InvalidAmount() {
        double invalidAmount = -50.0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            paymentService.makePayment(invalidAmount);
        });
        Assertions.assertEquals("Amount Must Be more Than Zero", exception.getMessage());

        verify(paymentProcessor, never()).processPayment(anyDouble());
    }
}
