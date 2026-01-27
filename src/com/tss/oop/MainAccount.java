package com.tss.oop;

import java.util.Scanner;

public class MainAccount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SavingAccount savingAccount = null;
        CurrentAccount currentAccount = null;
       while (true)
       {
           System.out.println("1. Create Account");
           System.out.println("2. Deposit");
           System.out.println("3. Withdraw");
           System.out.println("4. Show Balance");
           System.out.println("5. Exit");


           double amount = 0;
           int choice = sc.nextInt();
           switch (choice)
           {
               case 1:
                   System.out.println("1. Saving");
                   System.out.println("2. Current");
                   int c = sc.nextInt();

                   if(c == 1)
                   {
                       System.out.print("Enter name");
                       sc.nextLine();
                       String name = sc.nextLine();
                       System.out.print("Enter Balance");
                       double balance = sc.nextDouble();
                       System.out.print("Enter offerRate");
                       int offerRate = sc.nextInt();
                       savingAccount = new SavingAccount(name,balance,offerRate);

                   }
                   else
                   {
                       System.out.print("Enter name");
                       sc.nextLine();

                       String name = sc.nextLine();
                       System.out.print("Enter Balance");
                       double balance = sc.nextDouble();
                       System.out.print("Enter minimum amount:");
                       double minAmount = sc.nextDouble();
                       currentAccount = new CurrentAccount(name,balance,minAmount);
                   }
                   System.out.println("Account Created successfully");
                   break;
               case 2:
                   if(savingAccount == null && currentAccount == null)
                   {
                       System.out.println("Please Create account First");
                       break;
                   }
                   System.out.println("Enter amount to Deposit");
                   amount = sc.nextDouble();
                   if(savingAccount != null)
                   {
                       savingAccount.deposit(amount);
                   }
                   else
                   {
                       currentAccount.deposit(amount);
                   }

                   break;
               case 3:
                   if(savingAccount == null && currentAccount == null)
                   {
                       System.out.println("Please Create account First");
                       break;

                   }
                   System.out.println("Enter amount to withdraw");
                   amount = sc.nextDouble();


                   if(savingAccount != null)
                   {
                       savingAccount.withdraw(amount);

                   }
                   else
                   {
                       currentAccount.withdraw(amount);
                   }

                   break;
               case 4:
                   if(savingAccount != null)
                   {
                       System.out.println("Balance: "+ savingAccount.showBalance());

                   }
                   else if(currentAccount != null)
                   {
                       System.out.println("Balance: "+ currentAccount.showBalance());

                   }
                   else
                       System.out.println("Please Create account First");
                   break;
               case 5:
                   return;
               default:
                   System.out.println("Enter Valid Choice");

           }
       }
    }
}
