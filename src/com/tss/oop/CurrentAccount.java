package com.tss.oop;

public class CurrentAccount extends Account{
    public static double minimumBalance;

    public CurrentAccount()
    {

    }
    public CurrentAccount (String name,double balance,double minAmount)
    {
        super(name,balance);
        minimumBalance = minAmount;

    }

    public void deposit(double amount)
    {
        if(amount < 0)
        {
            System.out.println("Please Enter valid amount");
            return;
        }
        super.deposit(amount);
        System.out.println("Amount Deposit Successfully");

    }

    public void withdraw(double amount)
    {
        if(super.showBalance() < minimumBalance || super.showBalance()-minimumBalance < amount || amount < 0)
        {
            System.out.println("Please Enter valid amount");
            return;
        }
        else
            super.withdraw(amount);
        System.out.println("Amount Withdraw Successfully");
    }

    public double showBalance()
    {
        return super.showBalance();
    }
}
