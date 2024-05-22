package com.keyin.services;
//Added Maven Package

import com.keyin.interfaces.PaymentProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Mock
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentProcessor);
    }

    @Test
    public void testMakePayment_Success(){
        double amount = 100.0;
        when(paymentProcessor.processPayment(amount)).thenReturn(true);

        boolean result = paymentService.makePayment(amount);

        Assertions.assertTrue(result);
        verify(paymentProcessor).processPayment(amount);

    }

    @Test
    public void testMakePayment_Failure() {
        // Arrange
        double amount = 100.0;
        when(paymentProcessor.processPayment(amount)).thenReturn(false);

        // Act
        boolean result = paymentService.makePayment(amount);

        // Assert
        Assertions.assertFalse(result);
        verify(paymentProcessor).processPayment(amount);
    }

    @Test
    public void testMakePayment_InvalidAmount() {
        // Arrange
        double invalidAmount = -50.0;

        // Act & Assert
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            paymentService.makePayment(invalidAmount);
        });
        assertEquals("Amount Must Be more Than Zero", exception.getMessage());

        // Verify that the processor was never called
        verify(paymentProcessor, never()).processPayment(anyDouble());
    }


}

//    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,()->{

