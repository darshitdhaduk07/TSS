package com.tss.oop;

public class VehicleInsurancePolicy extends InsurancePolicy {

    private boolean isActive = true;

    public VehicleInsurancePolicy(String policyNumber, String name, double sumAssured, int duration) {
        super(policyNumber, name, sumAssured, duration);
    }

    public double calculatePremium() {
        return sumAssured * 0.03;
    }

    public void applyClaim() {
        if (isActive)
            System.out.println("Vehicle insurance claim approved.");
        else
            System.out.println("Policy expired. Claim rejected.");
    }
}
