package com.tss.oop;

import com.tss.basics.Main;

import java.util.Random;

public class Account {
    private int id = 0;
    private static int incrementor = 0;
    private double accountNumber;
    private String name;
    private double balance;
    private long digits = 10000000000L;
    private double offerRate;

    public Account()
    {

    }
    public Account(String name,double balance)
    {
        this.id = ++incrementor;
        this.accountNumber =  (Math.random()* digits)+incrementor;
        this.name = name;
        this.balance = balance;
    }
    public Account(String name,double balance,int rate)
    {
        this.id = ++incrementor;
        this.accountNumber =  (Math.random()* digits)+incrementor;
        this.name = name;
        this.balance = balance;
        this.offerRate = rate/100f;
    }

    public int getId() {
        return id;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double showBalance() {
        return balance;
    }

    public void deposit(double amount)
    {
        this.balance += amount;
        if(amount > 50000)
        {
            this.balance += (amount*offerRate);
        }

    }

    public void withdraw(double amount)
    {
        this.balance -= amount;
    }





}
