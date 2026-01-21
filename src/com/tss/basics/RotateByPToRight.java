package com.tss.basics;

import java.util.Scanner;

public class RotateByPToRight {
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

        int i,j;

        for(i = 0;i<size;i++)
        {
            System.out.println("Enter "+(i+1)+" Element of array:");
            arr[i] = takeInput.nextInt();
        }

        System.out.println("Enter position to Rotate your array: ");
        int position = takeInput.nextInt();

        position = position % size;

         i = 0;
        j = size-1;

        while(i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        i = 0;
        j = position-1;

        while(i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        i = position;
        j = size-1;

        while(i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println("Your array is:");
        for(i = 0;i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}
