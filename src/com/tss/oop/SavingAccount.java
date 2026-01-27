package com.tss.oop;

public class SavingAccount extends Account{

    public SavingAccount()
    {
    }
    public SavingAccount(String name,double balance,int rate)
    {
        super(name,balance,rate);
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
        if(super.showBalance() < amount || amount < 0)
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
