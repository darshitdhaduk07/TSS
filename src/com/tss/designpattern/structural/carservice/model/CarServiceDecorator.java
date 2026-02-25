package com.tss.designpattern.structural.carservice.model;

public  class CarServiceDecorator implements ICarService{
    ICarService iCarService;

    CarServiceDecorator(ICarService iCarService)
    {
        this.iCarService = iCarService;
    }
    public double getCost() {
        return 0;
    }

}
