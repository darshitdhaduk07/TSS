package com.tss.oop;

public abstract class InsurancePolicy {

    protected String policyNumber;
    protected String policyHolderName;
    protected double sumAssured;
    protected int duration;

    public InsurancePolicy(String policyNumber, String policyHolderName, double sumAssured, int duration) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.sumAssured = sumAssured;
        this.duration = duration;
    }

    public abstract double calculatePremium();
    public abstract void applyClaim();

    public void displayDetails() {
        System.out.println("Policy Number : " + policyNumber);
        System.out.println("Holder Name   : " + policyHolderName);
        System.out.println("Sum Assured   : " + sumAssured);
        System.out.println("Duration      : " + duration + " years");
    }
}
