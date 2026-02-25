package com.tss.designpattern.structural.carservice.model;

public class WheelAlign extends CarServiceDecorator{
    public WheelAlign(ICarService carInspection)
    {
        super(carInspection);
    }
    public double getCost()
    {
        return 200;
    }
}
