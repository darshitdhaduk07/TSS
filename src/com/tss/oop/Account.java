package com.tss.oop;

import com.tss.basics.Main;

import java.util.Random;

public class Account {
    private int id = 0;
    private static int incrementor = 0;
    private long accountNumber = 1000000000L;
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.id = ++incrementor;
        this.accountNumber += incrementor;
        this.name = name;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double showBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        balance += amount;
    }

    public void deposit(double amount) {
        setBalance(amount);

    }

    public boolean withdraw(double amount) {
        balance -= amount;
        return true;
    }


}
