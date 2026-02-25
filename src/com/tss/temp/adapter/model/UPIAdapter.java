package com.tss.temp.adapter.model;

public class UPIAdapter implements IPaymentProcessor {
    private UPI upi = new UPI();

    @Override
    public void pay(int amount) {
        upi.pay(amount);
    }
}
