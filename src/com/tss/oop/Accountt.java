package com.tss.oop;

public class Accountt {
    public static int numberOfAccount;
    public String holderName;
    private int id;
    private AccountType accountType;
    private double balance;

    public Accountt(){
        numberOfAccount++;
    }
    public Accountt(int id, String holderName, AccountType accountType, double balance){
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        numberOfAccount++;
        this.holderName = holderName;
    }

    public int getNumberOfAccount()
    {
        return numberOfAccount;
    }
    public String getHolderName()
    {
        return this.holderName;
    }

    public void setHolderName(String holderName)
    {
        this.holderName = holderName;
    }

    public int getId() {
        return id;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
