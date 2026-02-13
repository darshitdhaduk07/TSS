package com.tss.designprinciple.SRP.model;

public class InvoicePrinter {

    TaxCalculator taxCalculator;

    public InvoicePrinter(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void invoicePrinter()
    {
        System.out.println("----- Invoice Details -----");
        System.out.println("ID: "+taxCalculator.getInvoice().getId());
        System.out.println("Description: "+taxCalculator.getInvoice().getDescription());
        System.out.println("Amount: "+taxCalculator.getInvoice().getAmount());
        System.out.println("Total Amount: "+(taxCalculator.getInvoice().getAmount()+taxCalculator.taxCalculator()));
        System.out.println("TAX: "+taxCalculator.taxCalculator());
        System.out.println("\n\n");
    }
}
