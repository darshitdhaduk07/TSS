package com.tss.designpattern.structural.carservice.temp;

import com.tss.designpattern.structural.carservice.model.CarInspection;
import com.tss.designpattern.structural.carservice.model.ICarService;
import com.tss.designpattern.structural.carservice.model.OilChange;
import com.tss.designpattern.structural.carservice.model.WheelAlign;

public class Main {
    public static void main(String[] args) {

        ICarService iCarService = new CarInspection();

        WheelAlign wheelAlign = new WheelAlign(iCarService);
        OilChange oilChange = new OilChange(iCarService);

        System.out.println("Total Cost: "+(wheelAlign.getCost()+oilChange.getCost()+iCarService.getCost()));
    }
}
