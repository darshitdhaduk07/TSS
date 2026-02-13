package com.tss.designprinciple.SRP.test;

import com.tss.designprinciple.SRP.model.Invoice;
import com.tss.designprinciple.SRP.model.InvoicePrinter;
import com.tss.designprinciple.SRP.model.TaxCalculator;

import java.util.Arrays;
import java.util.List;

public class InvoiceApp {
    public static void main(String[] args) {
        List<Invoice> invoices = Arrays.asList(

        new Invoice("Laptop Purchase", 1200.00, 15),
        new Invoice("Office Chair", 250.00, 10),
        new Invoice("Software License", 500.00, 18),
        new Invoice("Printer", 300.00, 12),
        new Invoice("Desk", 450.00, 8));


        for(Invoice invoice : invoices)
        {
            TaxCalculator taxCalculator = new TaxCalculator(invoice);
            InvoicePrinter invoicePrinter = new InvoicePrinter(taxCalculator);
            invoicePrinter.invoicePrinter();
        }
    }
}
