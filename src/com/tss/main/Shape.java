package com.tss.main;

import com.tss.oop.Circle;
import com.tss.oop.Rectangle;
import com.tss.oop.Triangle;

public class Shape {
    public static void main(String[] args) {
        Circle c = new Circle();

        System.out.println("Area :"+c.area());

        Rectangle r = new Rectangle();
        System.out.println("Area: "+r.area());

        Triangle t = new Triangle();
        System.out.println("Area: "+t.area());
    }
}
