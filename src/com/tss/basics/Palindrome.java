package com.tss.basics;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int b = num;
        int a = 0;
        while(b>0)
        {
            a = a*10;
            a = a+(b%10);
            b = b/10;
        }

        if(a == num)
            System.out.println("Number is Palindrome");
        else
            System.out.println("Number is not a Palindrome");

    }
}
