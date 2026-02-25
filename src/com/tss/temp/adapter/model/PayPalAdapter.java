package com.tss.temp.adapter.model;

public class PayPalAdapter implements IPaymentProcessor {
    private PayPal payPal = new PayPal();
    @Override
    public void pay(int amount) {
        payPal.pay(amount);
    }
}
