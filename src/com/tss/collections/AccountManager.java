package com.tss.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    static ArrayList<Account> accountList;
    public static Scanner sc = new Scanner(System.in);

    public AccountManager() {
        accountList = new ArrayList<>(100);
    }

    public static String generateAccountNumber(int accountType) {
        long time = System.currentTimeMillis();
        return accountType + String.valueOf(time).substring(4, 13);
    }


    public static Account getAccountFromUser() {

        String accountNumber = InputValidator.readString("Enter account Number: ","\\d+");

        while (true) {
            for (Account account : accountList) {
                if (account.getAccountNumber().equals(accountNumber)) {

                    return account;
                }
            }
            System.out.println("\nAccount not Found\n");
            accountNumber = InputValidator.readString("Enter account Number: ","\\d+");
        }
    }

    public void addAccount() {

        System.out.println("1. Saving");
        System.out.println("2. Current");

        int choice = InputValidator.readInt("Enter your choice: ");

        while (choice < 1 || choice > 2) {
            choice = InputValidator.readInt("Enter Valid choice: ");
        }

        String accountNumber = generateAccountNumber(choice);

        String name = InputValidator.readString("Enter account holder name: ","[A-Za-z ]+");

        double balance = InputValidator.readDouble("Enter account balance: ");

        Transaction transaction = new Transaction(null,null,balance,TransactionType.DEPOSIT);
        transaction.setTransactionSuccess(true);

        if (choice == 1) {
            SavingAccount savingAccount = new SavingAccount(balance, accountNumber, name);
            savingAccount.setAccountType(AccountType.SAVING);
            accountList.add(savingAccount);
            savingAccount.addTransaction(transaction);
        } else {
            CurrentAccount currentAccount = new CurrentAccount(balance, accountNumber, name);
            currentAccount.setAccountType(AccountType.CURRENT);

            accountList.add(currentAccount);
            currentAccount.addTransaction(transaction);

        }
        System.out.println("\nAccount created successfully with account number: " + accountNumber + "\n");

    }

    public void removeAccount() {
        if(accountList.isEmpty()) {
            System.out.println("Please Create Account First\n");
            return;
        }
        Account account = getAccountFromUser();

        accountList.remove(account);

        System.out.println("Account removed successfully with account number: " + account.getAccountNumber());
    }

    public void showAccounts() {
        System.out.println("+----------------+----------------------+------------+--------------+");
        System.out.printf("| %-14s | %-20s | %-10s | %-12s |%n",
                "Account No", "Holder Name", "Balance", "Type");
        System.out.println("+----------------+----------------------+------------+--------------+");

        for (Account account : accountList) {
            System.out.printf("| %-14s | %-20s | ₹%-9.2f | %-12s |%n",
                    account.getAccountNumber(),
                    account.getName(),
                    account.getBalance(),
                    account.getAccountType());
        }

        System.out.println("+----------------+----------------------+------------+--------------+");

    }

    public void showAccountDetail(Account account) {
        System.out.println("\n========== Account Details ==========");
        System.out.println("Account Number      : " + account.getAccountNumber());
        System.out.println("Account Holder Name : " + account.getName());
        System.out.println("Account Balance     : ₹" + account.getBalance());
        System.out.println("Account Type        : " + account.getAccountType());
        System.out.println("=====================================\n");

    }

    public Account searchAccount() {
        String accountNumber = InputValidator.readString("Enter account Number: ","\\d+");

        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("\nAccount not Found\n");
        return null;
    }

    public void deposit() {
        if(accountList.isEmpty()) {
            System.out.println("Please Create Account First\n");
            return;
        }
        Account account = getAccountFromUser();
        double amount = InputValidator.readDouble("Please enter your amount: ");

        account.deposit(amount);
        Transaction transaction = new Transaction(null, null, amount, TransactionType.DEPOSIT);
        transaction.setTransactionSuccess(true);
        account.addTransaction(transaction);
        System.out.println("\nAccount balance has been deposited\n");

    }

    public boolean withdraw() {
        if(accountList.isEmpty()) {
            System.out.println("Please Create Account First\n");
            return false;
        }
        Account account = getAccountFromUser();
        double amount = InputValidator.readDouble("Please enter your amount: ");


        return account.withdraw(amount,TransactionType.WITHDRAW);
    }

    public void transfer() {
        if(accountList.isEmpty()) {
            System.out.println("Please Create Account First\n");
            return;
        }
        System.out.println("For Sender");
        Account sender = getAccountFromUser();

        System.out.println("For Receiver");
        Account receiver = getAccountFromUser();

        double amount = InputValidator.readDouble("Please enter your amount: ");


        if (sender.withdraw(amount,TransactionType.TRANSFER)) {
            receiver.deposit(amount);
            System.out.println("Transfer successful\n");
            System.out.println("₹" + amount + " Transfer from " + sender.getName() + " to " + receiver.getName());
            Transaction transaction = new Transaction(sender.getAccountNumber(),receiver.getAccountNumber(),amount, TransactionType.TRANSFER);

            transaction.setTransactionSuccess(true);
            sender.addTransaction(transaction);
            receiver.addTransaction(transaction);


            return;
        }
        System.out.println("Transfer failed\n");

    }

    public void getAllTransactions() {

        if(accountList.isEmpty()) {
            System.out.println("Please Create Account First\n");
            return;
        }
        Account account = getAccountFromUser();

        System.out.println(
                "+------------+------------------+------------------+------------+------------------+----------+"
        );

        System.out.printf(
                "| %-10s | %-16s | %-16s | %-10s | %-16s | %-8s |%n",
                "Txn ID", "Sender Acc", "Receiver Acc",
                "Amount", "Type", "Status"
        );

        System.out.println(
                "+------------+------------------+------------------+------------+------------------+----------+"
        );


            List<Transaction> transactions = account.getTransactions();

            for (Transaction transaction : transactions) {

                String status = transaction.isTransactionSuccess()
                        ? "SUCCESS"
                        : "FAILED";

                System.out.printf(
                        "| %-10d | %-16s | %-16s | ₹%-9.2f | %-16s | %-8s |%n",
                        transaction.getId(),
                        transaction.getSenderAccountNumber(),
                        transaction.getReceiverAccountNumber(),
                        transaction.getTransactionAmount(),
                        transaction.getTransactionType(),
                        status
                );
            }


        System.out.println(
                "+------------+------------------+------------------+------------+------------------+----------+"
        );


    }


}
