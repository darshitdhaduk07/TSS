package com.tss.oop;

public class LifeInsurancePolicy extends InsurancePolicy {

    public LifeInsurancePolicy(String policyNumber, String name,double sumAssured, int duration) {
        super(policyNumber, name, sumAssured, duration);
    }

    public double calculatePremium() {
        return sumAssured * 0.05;
    }

    public void applyClaim() {
        System.out.println("Life insurance claim allowed only after maturity.");
    }
}
