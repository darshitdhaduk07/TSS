package com.tss.oop;

import java.util.Scanner;

public class Circle extends Shape{
    public double area()
    {
        System.out.println("Enter Radious: ");
        Scanner sc = new Scanner(System.in);
        int radious = sc.nextInt();
        return 3.14*radious*radious;
    }
}
