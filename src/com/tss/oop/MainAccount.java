package com.tss.oop;

import java.util.Scanner;

public class MainAccount {

    public static Scanner sc = new Scanner(System.in);
    public static Account accounts[] = new Account[100];
    public static int numberOfAccounts = 0;


    public static void displayAccountNumber(){
        System.out.println("---- Account Numbers ----");
        for(Account account : accounts)
        {
            if(account == null)
                return;
            System.out.println(account.getAccountNumber());
        }
    }
    public static Account getAccountByAccountNumber()
    {
        System.out.println("Enter Account Number: ");
        double accountNumber = sc.nextDouble();
        while (true)
        {
            for (Account account: accounts)
            {
                if(account == null)
                    continue;

                if(account.getAccountNumber() == accountNumber)
                    return account;
            }
            System.out.print("Please Enter Valid Account Number: ");
            accountNumber = sc.nextDouble();

        }
    }

    public static void createAccount()
    {
        int choice = sc.nextInt();

        if(choice != 1 && choice != 2)
        {
            System.out.print("Please Enter valid choice: ");
            createAccount();
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        if(choice == 1)
        {
            System.out.print("Enter Offer Rate in %: ");
            int offerRate = sc.nextInt();

            while (offerRate < 0 || offerRate > 100)
            {
                System.out.print("Rate is not negative or greater than 100% please Re-Enter: ");
                offerRate = sc.nextInt();

            }
            SavingAccount.offerRate = offerRate;
            accounts[numberOfAccounts++] = new SavingAccount(name,balance);
        }
        else{
            System.out.print("Enter minimum Balance: ");
            CurrentAccount.minimumBalance = sc.nextDouble();
            accounts[numberOfAccounts++] = new CurrentAccount(name,balance);
        }

    }
    public static void deposit()
    {
        if(numberOfAccounts == 0)
        {
            System.out.println("Please Create Account First");
            return;
        }
        //display all account number
        displayAccountNumber();

        //get account by account number
        Account account = getAccountByAccountNumber();
        System.out.print("Enter Amount to Deposit: ");
        double amount = sc.nextDouble();

        // amount validation
        while (amount < 0)
        {
            System.out.print("Please Enter valid amount: ");
            amount = sc.nextDouble();
        }
        account.deposit(amount);
    }
    public static void withdraw()
    {
        if(numberOfAccounts == 0)
        {
            System.out.println("Please Create Account First");
            return;
        }
        //display all account number
        displayAccountNumber();

        //get account by account number
        Account account = getAccountByAccountNumber();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        while (amount < 0)
        {
            System.out.println("Please Enter valid amount: ");
            amount = sc.nextDouble();
        }
        account.withdraw(amount);
    }
    public static void showBalance(){
        if(numberOfAccounts == 0)
        {
            System.out.println("Please Create Account First");
            return;
        }
        displayAccountNumber();
        Account account = getAccountByAccountNumber();
        System.out.println("Balance is: "+account.showBalance());
    }

    public static void transferAmount(){
        if(numberOfAccounts <= 1)
        {
            System.out.println("You must have at least two account to transfer Money");
            return;
        }
        displayAccountNumber();

        //get sender
        System.out.println("---- For Sender Account ----");
        Account sender = getAccountByAccountNumber();

        //get receiver
        System.out.println("---- For Receiver Account ----");
        Account receiver = getAccountByAccountNumber();

        if(sender == receiver)
        {
            System.out.println("You cant send or receive with same account");
            return;
        }
        System.out.println("Enter amount to send");
        double amount = sc.nextDouble();

        if(sender.withdraw(amount))
        {
            receiver.deposit(amount);
            System.out.println("Amount Transferred From "+sender.getName()+" to "+receiver.getName());
        }
        else
        {
            System.out.println("Sender can't Send This amount");
        }

    }
    public static void main(String[] args) {


       while (true)
       {
           System.out.println("1. Create Account");
           System.out.println("2. Deposit");
           System.out.println("3. Withdraw");
           System.out.println("4. Show Balance");
           System.out.println("5. Transfer Amount");
           System.out.println("6. Exit");

           int choice = sc.nextInt();
           switch (choice)
           {
               case 1:
                   System.out.println("1. For Saving account");
                   System.out.println("2. For Current account");
                   createAccount();
                   break;
               case 2:
                   deposit();
                   break;
               case 3:
                   withdraw();
                   break;
               case 4:
                   showBalance();
                   break;
               case 5:
                   transferAmount();
                   break;
               case 6:
                   return;
               default:
                   System.out.println("Enter Valid Choice");

           }
       }
    }
}
