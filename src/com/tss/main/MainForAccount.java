package com.tss.main;

import com.tss.oop.Accountt;
import com.tss.oop.AccountType;

import java.util.Scanner;

public class MainForAccount {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Accountt a1 = new Accountt();

        System.out.print("Enter Holder Name: ");

        String name = scanner.nextLine();

        System.out.print("Enter amount to add in account: ");
        double amount = scanner.nextDouble();



        System.out.print("Enter id :");
        int id = scanner.nextInt();

        System.out.println("Enter Type of Account");
        System.out.println("1. For SALARY");
        System.out.println("2. For CURRENT");
        System.out.println("3. For SAVING");

        a1.setHolderName(name);
        a1.setId(id);
        a1.setBalance(amount);

        while (true)
        {
            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    a1.setAccountType(AccountType.SALARY);
                    System.out.println("Your Account Type: "+a1.getAccountType());
                    return;
                case 2:
                    a1.setAccountType(AccountType.CURRENT);
                    System.out.println("Your Account Type: "+a1.getAccountType());
                    return;
                case 3:
                    a1.setAccountType(AccountType.SAVING);
                    System.out.println("Your Account Type: "+a1.getAccountType());
                    return;
                default:
                    System.out.println("Please Enter valid choise");


            }
        }
    }
}
