package com.tss.temp.adapter.test;

import com.tss.temp.adapter.model.IPaymentProcessor;
import com.tss.temp.adapter.model.PayPal;
import com.tss.temp.adapter.model.PayPalAdapter;
import com.tss.temp.adapter.model.UPIAdapter;

public class Main {
    public static void main(String[] args) {
        IPaymentProcessor paymentProcessor;

        paymentProcessor = new PayPalAdapter();
        paymentProcessor.pay(100);

        paymentProcessor = new UPIAdapter();
        paymentProcessor.pay(100);
    }
}
