package com.tss.oop;

import java.util.Scanner;

public class Triangle extends Shape{

    public double area()
    {
        System.out.println("Enter base : ");
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();

        System.out.println("Enter height: ");
        int height = sc.nextInt();

        return .5*base*height;
    }
}
