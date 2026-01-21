package com.tss.oop;

public class Course {
    private int id = 0;
    private String name = "";
    private double price = 0;
    private int duration = 0;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
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