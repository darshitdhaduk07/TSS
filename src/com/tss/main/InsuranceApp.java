package com.tss.main;

import com.tss.oop.HealthInsurancePolicy;
import com.tss.oop.InsurancePolicy;
import com.tss.oop.LifeInsurancePolicy;
import com.tss.oop.VehicleInsurancePolicy;

import java.util.Scanner;

public class InsuranceApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InsurancePolicy policy = null;

        while (true) {
            System.out.println("\n--- INSURANCE POLICY MENU ---");
            System.out.println("1. Create Policy");
            System.out.println("2. Calculate Premium");
            System.out.println("3. Apply Claim");
            System.out.println("4. Show Policy Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Select Policy Type:");
                    System.out.println("1. Life");
                    System.out.println("2. Health");
                    System.out.println("3. Vehicle");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Policy Number: ");
                    String pno = sc.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Sum Assured: ");
                    double sum = sc.nextDouble();

                    System.out.print("Enter Duration (years): ");
                    int dur = sc.nextInt();

                    if (type == 1)
                        policy = new LifeInsurancePolicy(pno, name, sum, dur);
                    else if (type == 2)
                        policy = new HealthInsurancePolicy(pno, name, sum, dur);
                    else if (type == 3)
                        policy = new VehicleInsurancePolicy(pno, name, sum, dur);
                    else
                        System.out.println("Invalid policy type!");

                    break;

                case 2:
                    if (policy != null)
                        System.out.println("Premium: " + policy.calculatePremium());
                    else
                        System.out.println("No policy created!");
                    break;

                case 3:
                    if (policy != null)
                        policy.applyClaim();
                    else
                        System.out.println("No policy created!");
                    break;

                case 4:
                    if (policy != null)
                        policy.displayDetails();
                    else
                        System.out.println("No policy created!");
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
