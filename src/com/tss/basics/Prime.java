package com.tss.basics;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int flag = 0;
        for(int i = 2;i*i<=num;i++)
        {
            if(num % i == 0)
            {
                flag = 1;


            }
        }
        if(flag == 0)
            System.out.println("Number is Prime");
        else
            System.out.println("Number is not Prime");
    }
}
