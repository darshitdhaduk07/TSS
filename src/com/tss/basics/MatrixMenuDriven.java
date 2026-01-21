package com.tss.basics;

import java.util.Scanner;

public class MatrixMenuDriven {
    private static boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static boolean primeHarmonic(int arr[][]) {
        if(arr == null)
            return false;
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (isPrime(arr[i][j]) == true)
                    count++;


            }
            if (count != 3) {
                System.out.println("This Matrix is not Prime-Harmonic");
                return false;
            }
        }
        return true;



    }

    private static boolean checkMagicalMatrix(int arr[][]) {

        if(arr == null)
            return false;

        int n = arr.length;
        int m = arr[0].length;


        if (n != m) {
            System.out.println("Column and Row of Matrix Should be Equal");
            return false;
        }

        int sum = 0;
        int flag = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += arr[i][j];
            }
            if (flag == 0) {
                sum = temp;
                flag = 1;
            } else if (sum != temp) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += arr[j][i];
            }

            if (sum != temp) {
                System.out.println("This is not Magical Matrix");
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            int temp1 = 0;
            int temp2 = 0;
            for (int j = 0; j < m; j++) {
                if (i == j)
                    temp1 += arr[j][i];
                else if (j == (n - 1 - i))
                    temp2 += arr[i][n - i - 1];
            }

            if (sum != temp1 || sum != temp2) {
                System.out.println("This is not Magical Matrix");
                return false;
            }
        }


        return true;

    }

    private static int[][] multiplicationOfMatrix(int arr1[][], int arr2[][]) {
        if (arr1 == null || arr2 == null) {
            System.out.println("Please Create Array First");
            return null;
        }
        int n = arr2.length;
        int m = arr1[0].length;

        if (n != m) {
            System.out.println("You can't multiply this two matrix");
            return new int[][]{{}};
        }

        int mul[][] = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    mul[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return mul;

    }

    private static int[][] additionOfMatrix(int arr1[][], int arr2[][]) {
        if (arr1 == null || arr2 == null) {
            System.out.println("Please Create Array First");
            return null;
        }

        int n1 = arr1.length;
        int m1 = arr1[0].length;

        int n2 = arr2.length;
        int m2 = arr2[0].length;

        if (n1 != n2 || m1 != m2) {
            System.out.println("You can't Add this both matrix");
            return new int[][]{{}};
        }

        int sum[][] = new int[n1][m1];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return sum;
    }

    private static void displayMatrix(int arr[][]) {

        if (arr == null) {
            System.out.println("Please Perform Operation First");
            return;
        }
        int n = arr.length;
        int m = arr[0].length;

        System.out.println("Your Result Matrix is:");

        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    private static int[][] createMatrix() {

        System.out.println("Enter size of Matrix (n,m): ");
        Scanner takeInput = new Scanner(System.in);

        int size1 = takeInput.nextInt();
        int size2 = takeInput.nextInt();

        int arr[][] = new int[size1][size2];

        System.out.println("Enter element of Matrix:");
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                arr[i][j] = takeInput.nextInt();

            }

        }
        return arr;

    }

    public static void main(String[] args) {
        int arr1[][] = null;

        int arr2[][] = null;
        int result[][] = null;

        while (true) {
            System.out.println("---------*****---------");
            System.out.println("1. Create Matrix");
            System.out.println("2. Display Matrix");
            System.out.println("3. Addition Matrix");
            System.out.println("4. Multiplication Matrix");
            System.out.println("5. Magical Matrix");
            System.out.println("6. Prime Harmonic Matrix");
            System.out.println("7. Break");

            System.out.println("Enter Your Choice: ");

            Scanner takeInput = new Scanner(System.in);

            int choice = takeInput.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("For Matrix 1:");
                    arr1 = createMatrix();
                    System.out.println("For Matrix 2:");
                    arr2 = createMatrix();
                    break;
                case 2:
                    displayMatrix(result);
                    break;
                case 3:
                    result = additionOfMatrix(arr1, arr2);
                    break;
                case 4:
                    result = multiplicationOfMatrix(arr1, arr2);
                    break;
                case 5:
                    if(checkMagicalMatrix(arr1))
                        System.out.println("Matrix 1 is Magical");
                    else
                        System.out.println("Matrix 1 is not Magical");
                    if(checkMagicalMatrix(arr2))
                        System.out.println("Matrix 2 is Magical");
                    else
                        System.out.println("Matrix 2 is not Magical");
                    break;
                case 6:
                    if(primeHarmonic(arr1))
                        System.out.println("Matrix 1 is Prime-Harmonic");
                    else
                        System.out.println("Matrix 1 is not Prime-Harmonic");
                    if(primeHarmonic(arr2))
                        System.out.println("Matrix 2 is Prime-Harmonic");
                    else
                        System.out.println("Matrix 2 is not Prime-Harmonic");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please Enter Valid Choice:");
            }

        }

    }
}
