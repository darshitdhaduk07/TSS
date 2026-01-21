package com.tss.basics;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int temp = num;
        int ans = 0;
        int size = 0;

        while(temp>0)
        {
            size++;
            temp = temp/10;
        }

        temp = num;

        while(temp>0)
        {
            int last = temp%10;
            temp = temp/10;
            int sum = 1;
            for(int i = 0;i<size;i++)
            {
                sum = sum * last;
            }

            ans += sum;
        }

        if(ans == num)
        {
            System.out.println(num + " is an Armstrong Number");
        }
        else {
            System.out.println(num+" is not an Armstrong Number");
        }
    }
}
