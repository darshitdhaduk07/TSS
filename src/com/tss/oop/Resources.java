package com.tss.oop;

abstract public class Resources {
    public long resourceId;
    public String departmentName;
    public double baseRate;
    private long usage;

    public abstract boolean validateUsage();

    public abstract double calculateCost();

    public abstract void generateBill();

    public abstract void enterUsageDetails();


}
