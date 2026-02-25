package com.tss.designpattern.structural.hotelservice.test;

import com.tss.designpattern.structural.hotelservice.model.Reception;

public class Main {
    public static void main(String[] args) {
        Reception reception = new Reception();

        reception.checkIn();
        System.out.println("\n");
        reception.checkOut();
    }
}
