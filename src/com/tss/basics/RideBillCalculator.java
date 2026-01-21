package com.tss.basics;

import java.util.Scanner;

public class RideBillCalculator {
    public static void main(String[] args) {
        Scanner heightTaker = new Scanner(System.in);

        System.out.println("Enter height in cm:");
        int height = heightTaker.nextInt();

        if(height <= 120)
        {
            System.out.println("You can't ride");
            return;
        }
        else
            System.out.println("You can ride");

        Scanner ageTaker = new Scanner(System.in);

        System.out.println("Enter you age: ");

        int age = ageTaker.nextInt();

        int totalBill = 0;
        if(age < 12){
            totalBill += 5;
        }
        else if(age >= 12 && age < 18)
        {
            totalBill+= 7;
        }
        else if(age >= 18 && age <=44)
        {
            totalBill += 12;
        }

        Scanner conditionTaker = new Scanner(System.in);

        System.out.println("Can you Want Photo (true or false):");

        boolean condition = conditionTaker.nextBoolean();



        if(condition == true)
        {
            totalBill += 3;
        }

        System.out.println("Your Total Bill is : $"+totalBill);
    }
}
