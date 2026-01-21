package com.tss.basics;

import java.util.Scanner;

public class WaterBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int units = sc.nextInt();

        int Meter_charge = 75;
        int Total_water_bill = 0;
        int charge = 0;

        if(units <= 100)
        {
            charge = units*5;


        }
        else if(units <= 250)
        {
            charge = units*10;
        }
        else {
            charge = units *20;
        }
        Total_water_bill = charge + Meter_charge;
        System.out.println(Total_water_bill);
    }
}
