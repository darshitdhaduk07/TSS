package com.tss.basics;

import java.util.Scanner;

public class ProductExceptCurr {
    private static void print(int arr[])
    {
        int size = arr.length;

        for(int i = 0;i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
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

        int countzero = 0;

        for(int i = 0;i<size;i++)
        {
            if(arr[i] == 0)
                countzero++;
        }
        int product = 1;

        for(int i = 0;i<size;i++){
            if(arr[i] == 0)
            {
                continue;
            }
            else product *= arr[i];
        }

        if(countzero >= 2)
        {
            for(int i = 0;i<size;i++)
            {
                arr[i] = 0;
            }

        }
        else if(countzero == 1)
        {
            for (int i = 0;i<size;i++)
            {
                if(arr[i] == 0)
                    arr[i] = product;
                else arr[i] = 0;
            }
        }
        else
        {
            for (int i = 0;i<size;i++)
            {
                arr[i] = product/arr[i];
            }
        }
        System.out.println("Your Array is :");
        print(arr);
    }
}
