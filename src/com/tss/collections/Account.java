package com.tss.collections;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private String accountNumber;
    private String name;
    private AccountType accountType;

    List<Transaction> transactions = new ArrayList<Transaction>();

    public Account(double balance,String accountNumber,String name) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    //override
    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

//    override
    public boolean withdraw(double amount,TransactionType transactionType) {
        this.setBalance(this.getBalance() - amount);
        return true;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

}
