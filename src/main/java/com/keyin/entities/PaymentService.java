package com.keyin.entities;

public class PaymentService {

    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public boolean makePayment(double amount){
        if(amount <=0){
            throw  new IllegalArgumentException("Amount Must Be more Than Zero");
        }
        return paymentProcessor.processPayment(amount);
    }

}
