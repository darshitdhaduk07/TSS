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

            System.out.println("\n--- INSURANCE MENU ---");
            System.out.println("1. Create Policy");
            System.out.println("2. Calculate Premium");
            System.out.println("3. Apply Claim");
            System.out.println("4. Show Policy Details");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter valid number: ");
                sc.next();
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("1. Life  2. Health  3. Vehicle");
                    int type = sc.nextInt();


                    while (type <= 0 || type > 3) {
                        System.out.println("Please enter a valid choice: ");
                        type = sc.nextInt();
                    }
                    sc.nextLine();
                    System.out.print("Policy Number: ");
                    String pno = sc.nextLine();

                    System.out.print("Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Sum Assured: ");
                    while (!sc.hasNextDouble()) sc.next();
                    double sum = sc.nextDouble();

                    System.out.print("Duration (years): ");
                    int dur = sc.nextInt();
                    while (true) {
                        if (dur < 0 || dur > 100) {
                            System.out.println("Age must be between 0 and 100");
                            dur = sc.nextInt();
                        } else break;
                    }

                    if (type == 1) {
                        System.out.print("Completed Years: ");
                        while (!sc.hasNextInt()) sc.next();
                        int completed = sc.nextInt();
                        policy = new LifeInsurancePolicy(pno, name, sum, dur, completed);
                    } else if (type == 2) {
                        policy = new HealthInsurancePolicy(pno, name, sum, dur);
                    } else
                        policy = new VehicleInsurancePolicy(pno, name, sum, dur);

                        break;

                        case 2:
                            if (policy != null)
                                System.out.println("Premium: " + policy.calculatePremium());
                            else
                                System.out.println("No policy created.");
                            break;

                        case 3:
                            if (policy == null) {
                                System.out.println("No policy created.");
                                break;
                            }

                            System.out.print("Enter claim amount: ");
                            while (!sc.hasNextDouble()) sc.next();
                            double claim = sc.nextDouble();

                            policy.applyClaim(claim);
                            break;

                        case 4:
                            if (policy != null)
                                policy.displayDetails();
                            else
                                System.out.println("No policy created.");
                            break;

                        case 5:
                            System.out.println("Application closed.");
                            sc.close();
                            return;

                        default:
                            System.out.println("Invalid choice.");
                    }
            }

    }
}
