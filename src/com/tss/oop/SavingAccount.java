package com.tss.oop;

public class SavingAccount extends Account{
    public static int offerRate;
    public SavingAccount(String name,double balance)
    {
        super(name,balance);
    }
    public void deposit(double amount)
    {
        super.deposit(amount);
        if(amount > 50000)
        {
            super.deposit(amount * (offerRate / 100f));
        }
        System.out.println("Amount Deposit Successfully");

    }

    public boolean withdraw(double amount)
    {
        if(super.showBalance() < amount)
        {
            System.out.println("Insufficient Balance");
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
