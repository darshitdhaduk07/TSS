package com.tss.basics;

import java.util.Scanner;

public class CurrnecyDenomination {
    public static void main(String[] args) {
        Scanner takeAmount = new Scanner(System.in);

        int amount = takeAmount.nextInt();

        if(amount > 50000)
        {
            System.out.println("Please Enter amount less than 50000");
            return;
        }
        else if(amount % 100 != 0)
        {
            System.out.println("Please Enter amount is Multiple of 100");
            return;
        }

        int count2000 = 0;
        int count500 = 0;
        int count100 = 0;



        while(amount > 0)
        {
            if(amount % 2000 == 0)
            {
                count2000++;
                amount -= 2000;
            }else if(amount % 500 == 0)
            {
                count500++;
                amount -= 500;
            }else{
                count100++;
                amount -= 100;
            }
        }

        System.out.println("2000 ruppe "+ count2000 +" Notes");
        System.out.println("500 ruppe "+ count500 +" Notes");
        System.out.println("100 ruppe "+ count100 +" Notes");
    }
}
