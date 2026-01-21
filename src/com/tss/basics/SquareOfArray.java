package com.tss.basics;

import java.util.Scanner;

public class SquareOfArray {
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


        for(int i = 0;i<size;i++)
        {
            arr[i] = arr[i]*arr[i];
        }

        int i = 0,j = size-1;
        int arr1[] = new int[size];
        int t = size-1;
        while(i<=j)
        {
            if(arr[i]<=arr[j])
            {
                arr1[t] = arr[j];
                t--;
                j--;
            }
            else {
                arr1[j] = arr[i];
                i++;
                t--;
            }
        }
        System.out.println("Sorted Array:");
        for(i = 0;i<size;i++)
        {
            System.out.print(arr1[i]+" ");
        }

    }
}
