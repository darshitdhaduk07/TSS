package com.tss.basics;

import java.util.Scanner;

public class PeakElement {
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

        int peak = arr[1];


        for(int i = 1;i<size;i++)
        {
            if(arr[i-1] < arr[i] && arr[i]>arr[i+1])
            {
                System.out.println("Peak Element is :"+arr[i]);
                break;
            }
        }

    }
}
