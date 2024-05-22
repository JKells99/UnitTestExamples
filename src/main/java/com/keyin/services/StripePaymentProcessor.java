package com.keyin.services;

public class StripePaymentProcessor implements PaymentProcessor {


    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
