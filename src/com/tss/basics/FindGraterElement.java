package com.tss.basics;

import java.util.Scanner;

public class FindGraterElement {
    public static void main(String[] args) {
        System.out.println("Enter Three number");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int b = sc.nextInt();

        int c = sc.nextInt();

        if(a>b){
            if(a>c)
                System.out.println(a+" is a greater Element");
            else
                System.out.println(c+" is a greater Element");
        }
        else if(b>c)
        {
            System.out.println(b+" is a greater Element");
        }
        else {
            System.out.println(c+" is a greater Element");
        }

    }
}
