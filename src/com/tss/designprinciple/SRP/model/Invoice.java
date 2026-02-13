package com.tss.designprinciple.SRP.model;

public class Invoice {
    private int id;
    private String description;
    private double amount;
    private int texprcentage;
    private static int counter = 0;

    public Invoice(String description, double amount, int texprcentage) {
        this.description = description;
        this.amount = amount;
        this.texprcentage = texprcentage;
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTexprcentage() {
        return texprcentage;
    }

    public void setTexprcentage(int texprcentage) {
        this.texprcentage = texprcentage;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Invoice.counter = counter;
    }
}
