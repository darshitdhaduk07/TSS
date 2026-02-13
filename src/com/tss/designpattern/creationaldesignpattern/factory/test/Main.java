package com.tss.designpattern.creationaldesignpattern.factory.test;

import com.tss.designpattern.creationaldesignpattern.factory.module.Car;
import com.tss.designpattern.creationaldesignpattern.factory.module.CarFactory;

public class Main {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("bmw");

        Car car2 = CarFactory.getCar("tesla");



    }
}
