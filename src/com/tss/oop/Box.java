package com.tss.oop;

public class Box {
    private double depth;
    private double height;
    private double width;

    public Box() {
        depth = 0;
        height = 0;
        width = 0;
    }

    public Box(double depth, double height, double width) {
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getDepth() {
        return this.depth;
    }

    public double getVolume()
    {
        return this.depth*this.height*this.width;
    }

}
