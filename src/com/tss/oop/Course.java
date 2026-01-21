package com.tss.oop;

public class Course {
    private int id = 0;
    private String name = "";
    private double price = 0;
    private double feesPaid = 0;
    private int duration = 0;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getFeesPaid() {
        return this.feesPaid;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFeesPaid(double fees)
    {
        this.feesPaid = fees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }
}