package com.tss.oop;

import java.util.Scanner;

public class Rectangle extends Shape{
    public double area()
    {
        System.out.println("Enter Height: ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();

        System.out.println("Enter Width: ");
        int width = sc.nextInt();

        return height*width;

    }
}
