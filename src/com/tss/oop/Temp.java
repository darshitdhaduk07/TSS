package com.tss.oop;

import java.util.Scanner;


class A{
    int a ,b;

    public A(int a,int b)
    {
        System.out.println("inside A");
    }
    public static void display()
    {
        System.out.println("Inside A");
    }

}

class B extends A{
    int a,b;
    public B()
    {
        super(10,3);
        System.out.println("inside B");
    }
    public static void display()
    {
        System.out.println("Inside B");

    }


}

public class Temp {
    public static void main(String[] args) {



    }
}
