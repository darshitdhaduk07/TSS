package com.tss.designpattern.creationaldesignpattern.abstractfactory.model;

public class KIAFactory implements ICarFactory{
    public KIA createCar()
    {
        return new KIA();
    }
}
