package com.tss.main;

import com.tss.exception.MinimumBalanceException;
import com.tss.exception.NegativeAmountException;
import com.tss.oop.Accountt;
import com.tss.oop.AccountType;

import java.util.Scanner;

public class MainForAccount {

    public static Scanner scanner = new Scanner(System.in);
    public static double getAmount()
    {
        System.out.print("Enter amount to add in account: ");
        double amount = scanner.nextDouble();
        while (amount < 0)
        {
            amount = scanner.nextDouble();

            try
            {
                if(amount < 0)
                    throw new NegativeAmountException("Amount should be Positive");
                else break;
            }
            catch (NegativeAmountException n)
            {
                System.out.println(n);
            }
            System.out.println("Please Enter valid amount");
        }
        return amount;
    }

    public static void main(String[] args) {



            Accountt a1 = new Accountt();

            System.out.print("Enter Holder Name: ");

            String name = scanner.nextLine();


            double amount = getAmount();

            System.out.print("Enter id :");
            int id = scanner.nextInt();

            System.out.println("Enter Type of Account");
            System.out.println("1. For SALARY");
            System.out.println("2. For CURRENT");
            System.out.println("3. For SAVING");

            a1.setHolderName(name);
            a1.setId(id);
            a1.setBalance(amount);

            while (true) {
                int choise = scanner.nextInt();

                switch (choise) {
                    case 1:
                        a1.setAccountType(AccountType.SALARY);
                        System.out.println("Your Account Type: " + a1.getAccountType());
                        return;
                    case 2:
                        a1.setAccountType(AccountType.CURRENT);
                        System.out.println("Your Account Type: " + a1.getAccountType());
                        return;
                    case 3:
                        a1.setAccountType(AccountType.SAVING);
                        System.out.println("Your Account Type: " + a1.getAccountType());
                        return;
                    default:
                        System.out.println("Please Enter valid choise");


                }
            }



    }
}
