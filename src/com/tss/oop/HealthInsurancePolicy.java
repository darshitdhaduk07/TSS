package com.tss.oop;

public class HealthInsurancePolicy extends InsurancePolicy {

    public HealthInsurancePolicy(String policyNumber, String name,double sumAssured, int duration) {
        super(policyNumber, name, sumAssured, duration);
    }

    public double calculatePremium() {
        return sumAssured * 0.07;
    }

    public void applyClaim(double claimAmount) {

        if (claimAmount <= 0) {
            System.out.println("Invalid claim amount.");
            return;
        }

        if (remainingCoverage <= 0) {
            System.out.println("No coverage remaining.");
            return;
        }

        if (claimAmount > remainingCoverage) {
            System.out.println("Claim exceeds remaining coverage.");
            return;
        }

        remainingCoverage -= claimAmount;
        System.out.println("Health claim approved: " + claimAmount);
        System.out.println("Remaining coverage: " + remainingCoverage);
    }
}
