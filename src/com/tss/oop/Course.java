package com.tss.oop;

public class Course {
    private int id = 0;
    private String name = "";
    private double fees = 0;
    private double feesPaid = 0;
    private int duration = 0;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getFees() {
        return this.fees;
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
        this.feesPaid += fees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }
}