package com.tss.designprinciple.OCP.model;

public class FixedDeposit {
    private long accountNumber;
    private int duration;
    private FestivalTyep festivalTyep;
    private double amount;

    public FixedDeposit(long accountNumber, int duration, FestivalTyep festivalTyep, double amount) {
        this.accountNumber = accountNumber;
        this.duration = duration;
        this.festivalTyep = festivalTyep;
        this.amount = amount;
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FestivalTyep getFestivalTyep() {
        return festivalTyep;
    }

    public void setFestivalTyep(FestivalTyep festivalTyep) {
        this.festivalTyep = festivalTyep;
    }

    public double calculateInterest()
    {
        int rate = festivalTyep.getRate();
        int duration = getDuration();
        double amount = getAmount();

        return  (amount * duration * rate) / 100.0;

    }
    public void getDetails()
    {
        System.out.println("----- FD -----");
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Amount Invested: "+getAmount());
        System.out.println("Interest you get: "+calculateInterest());
        System.out.println("Total amount you get after FD mature: "+(getAmount()+calculateInterest()));
        System.out.println("Festival Type: "+festivalTyep);

    }
}
