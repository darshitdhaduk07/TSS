package com.tss.oop;

public class HealthInsurancePolicy extends InsurancePolicy {

    public HealthInsurancePolicy(String policyNumber, String name,double sumAssured, int duration) {
        super(policyNumber, name, sumAssured, duration);
    }

    public double calculatePremium() {
        return sumAssured * 0.07;
    }

    public void applyClaim() {
        System.out.println("Health insurance claim applied successfully.");
    }
}
