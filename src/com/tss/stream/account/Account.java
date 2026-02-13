package com.tss.stream.account;

public class Account {

    private long accountNumber;
    private String name;
    private double balance;

    public Account(long accountNumber,String name,double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
