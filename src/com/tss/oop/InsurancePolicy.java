package com.tss.oop;
public abstract class InsurancePolicy {

    protected String policyNumber;
    protected String policyHolderName;
    protected double sumAssured;
    protected int policyDuration; // in years
    protected double remainingCoverage;

    public InsurancePolicy(String policyNumber, String policyHolderName,double sumAssured, int policyDuration) {

        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.sumAssured = sumAssured;
        this.policyDuration = policyDuration;
        this.remainingCoverage = sumAssured;
    }

    public abstract double calculatePremium();
    public abstract void applyClaim(double claimAmount);

    public void displayDetails() {
        System.out.println("Policy Number      : " + policyNumber);
        System.out.println("Policy Holder Name : " + policyHolderName);
        System.out.println("Sum Assured        : " + sumAssured);
        System.out.println("Policy Duration    : " + policyDuration + " years");
        System.out.println("Remaining Coverage : " + remainingCoverage);
    }
}
