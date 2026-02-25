package com.tss.designpattern.structural.carservice.model;

public class OilChange extends CarServiceDecorator{
    public OilChange(ICarService iCarService)
    {
        super(iCarService);
    }
    public double getCost()
    {
        return 500;
    }
}
