package com.tss.designprinciple.SRP.model;

public class TaxCalculator {
    private Invoice invoice;

    public TaxCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public double taxCalculator()
    {
        double amount = invoice.getAmount();
        double texpercentage = invoice.getTexprcentage()/100.0;

        return amount*texpercentage;
    }
}
