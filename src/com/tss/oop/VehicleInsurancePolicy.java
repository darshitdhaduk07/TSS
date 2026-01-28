package com.tss.oop;

public class VehicleInsurancePolicy extends InsurancePolicy {

    private boolean isActive = true;

    public VehicleInsurancePolicy(String policyNumber, String name,double sumAssured, int duration) {
        super(policyNumber, name, sumAssured, duration);
    }

    public double calculatePremium() {
        return sumAssured * 0.03;
    }

    public void applyClaim(double claimAmount) {

        if (!isActive) {
            System.out.println("Policy inactive. Claim rejected.");
            return;
        }

        if (claimAmount <= 0) {
            System.out.println("Invalid claim amount.");
            return;
        }

        if (claimAmount > remainingCoverage) {
            System.out.println("Claim exceeds remaining coverage.");
            return;
        }

        remainingCoverage -= claimAmount;
        System.out.println("Vehicle claim approved: " + claimAmount);
        System.out.println("Remaining coverage: " + remainingCoverage);

        if (remainingCoverage == 0) {
            isActive = false;
            System.out.println("Policy closed after full utilization.");
        }
    }
}
