package com.tss.oop;

public class LifeInsurancePolicy extends InsurancePolicy {

    private int completedYears;
    private boolean claimed = false;

    public LifeInsurancePolicy(String policyNumber, String name,double sumAssured, int duration,int completedYears) {
        super(policyNumber, name, sumAssured, duration);
        this.completedYears = completedYears;
    }

    public double calculatePremium() {
        return sumAssured * 0.05;
    }

    public void applyClaim(double claimAmount) {

        if (claimed) {
            System.out.println("Claim already processed.");
            return;
        }

        if (completedYears < policyDuration) {
            System.out.println("Claim rejected: Policy not matured.");
            return;
        }

        if (claimAmount != sumAssured) {
            System.out.println("Claim rejected: Full sum assured must be claimed.");
            return;
        }

        claimed = true;
        remainingCoverage = 0;
        System.out.println("Life insurance claim approved: " + claimAmount);
    }
}
