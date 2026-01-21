package com.tss.basics;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int a = num;

        int sum = 1;
        int i = 2;

        while(a>1)
        {
            while(a > 1 && (a%i) == 0)
            {
                sum = sum + i;
                a = a/i;
            }
            i++;
        }

        if(sum == num)
            System.out.println("It is Perfect Number");
        else
            System.out.println("It is not Perfect Number");
    }
}
