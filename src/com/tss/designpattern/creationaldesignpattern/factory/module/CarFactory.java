package com.tss.designpattern.creationaldesignpattern.factory.module;

public class CarFactory {

    public static Car getCar(String type) {

        if (type == null) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "Kia":
                return new KIA();
            case "Maruti":
                return new Maruti();
            
            default:
                throw new IllegalArgumentException("Unknown car type");
        }
    }
}
