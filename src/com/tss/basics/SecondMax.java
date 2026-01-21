package com.tss.basics;

import java.util.Scanner;

public class SecondMax {
    public static void main(String[] args) {

        Scanner takeInput = new Scanner(System.in);

        System.out.println("Enter a Size of Array");

        while(!takeInput.hasNextInt())
        {
            System.out.println("Please Enter a number");
            takeInput.next();
        }
        int size = takeInput.nextInt();


        int arr[] = new int[size];

        for(int i = 0;i<size;i++)
        {
            System.out.println("Enter "+(i+1)+" Element of array:");
            arr[i] = takeInput.nextInt();
        }

        int n = arr.length;
        int maxi1 = arr[0];
        int maxi2 = arr[0];
        for(int i = 0;i<n;i++)
        {
            if(maxi2 <= arr[i])
            {
                maxi1 = maxi2;
                maxi2 = arr[i];
            }
        }

        System.out.println("Second MAX element is:"+maxi1);

    }
}
