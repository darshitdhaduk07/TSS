package com.tss.oop;

import com.tss.exception.NegativeAmountException;

public class CurrentAccount extends Account{
    public static double minimumBalance;

    public CurrentAccount (String name,double balance)
    {
        super(name,balance);
    }
    public void deposit(double amount)
    {

        super.deposit(amount);
        System.out.println("Amount Deposit Successfully");

    }

    public boolean withdraw(double amount)
    {

        if(super.showBalance()-amount < minimumBalance)
        {
            System.out.println("You can't withdraw you should contain"+minimumBalance+" in your account");
            return false;
        }
        else
            super.withdraw(amount);
        System.out.println("Amount Withdraw Successfully");
        return true;
    }

    public double showBalance()
    {
        return super.showBalance();
    }
}
