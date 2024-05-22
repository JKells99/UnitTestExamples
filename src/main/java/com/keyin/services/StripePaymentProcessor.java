package com.keyin.services;

import com.keyin.interfaces.PaymentProcessor;

public class StripePaymentProcessor implements PaymentProcessor {


    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
