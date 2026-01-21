package com.tss.basics;

import java.util.Scanner;

public class SMART_CITY_UTILITY_CONTROL_SYSTEM {
    private static int takeInput()
    {
        Scanner inputTaker = new Scanner(System.in);

        while (!inputTaker.hasNextInt()) {
            System.out.println("You can't enter String ");
            inputTaker.next(); // clear invalid input
        }
        int input = inputTaker.nextInt();
        return input;
    }
    private static void electricityServices() {


        while (true) {
            System.out.println("Sub Menu:");
            System.out.println("1. Domestic Connection");
            System.out.println("2. Commercial Connection");
            System.out.println("3. Internet Service");
            System.out.println("4. Back");


            System.out.println("Enter you Choice:");


            while(true)
            {
                int subMenuChoice = takeInput();
                switch (subMenuChoice) {

                    case 1:
                        domesticConnection();
                        break;
                    case 2:
                        commercialConnection();
                        break;
                    case 3:
                        industrialConnection();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please Enter Valid Choice(1-4)");
                        continue;

                }
                break;
            }
        }


    }

    private static void display(String connType, int units, float energyCharge, int fixedCharge, float extraCharge, float totalBill, float rebateAmount) {
        System.out.println("\nConnection type :" + connType +"\n");
        System.out.println("Units :" + units);
        System.out.println("Energy Charge :" + energyCharge);
        System.out.println("Fixed Charge : " + fixedCharge);
        System.out.println("Extra Charge : " + extraCharge);
        System.out.println("Rebate amount : " + rebateAmount);
        System.out.println("Total Bill : " + totalBill);
    }

    private static void domesticConnection() {

        System.out.println("Enter unit Consumed:");


        int unitConsumed = takeInput();

        float energyCharge = 0;
        int fixedCharge = 0;
        float extraCharge = 0;
        float rebateAmount = 0;
        float totalBill = 0;

        if (unitConsumed >= 0 && unitConsumed <= 100) {

            energyCharge += (unitConsumed * 2);
        } else if (unitConsumed >= 101 && unitConsumed <= 300) {
            energyCharge += (unitConsumed * 3);
        } else {
            energyCharge += (unitConsumed * 5);
        }
        fixedCharge = 50;

        if (energyCharge > 2000) {
            extraCharge = energyCharge * .10f;
        }
        totalBill = energyCharge + extraCharge - rebateAmount;
        display("Domestic Connection", unitConsumed, energyCharge, fixedCharge, extraCharge, totalBill, rebateAmount);


    }

    private static void commercialConnection() {

        System.out.println("Enter unit Consumed:");

        int unitConsumed = takeInput();

        float energyCharge = 0;
        int fixedCharge = 0;
        float extraCharge = 0;
        float rebateAmount = 0;
        float totalBill = 0;

        if (unitConsumed >= 0 && unitConsumed <= 200) {
            energyCharge += (unitConsumed * 5);
        } else if (unitConsumed >= 201 && unitConsumed <= 500) {
            energyCharge += (unitConsumed * 7);
        } else {
            energyCharge += (unitConsumed * 10);
        }
        fixedCharge = 150;
        totalBill = energyCharge + extraCharge - rebateAmount;

        display("Commercial Connection", unitConsumed, energyCharge, fixedCharge, extraCharge, totalBill, rebateAmount);


    }

    private static void industrialConnection() {
        System.out.println("Enter unit Consumed:");

        int unitConsumed = takeInput();

        float energyCharge = 0;
        int fixedCharge = 0;
        float extraCharge = 0;
        float rebateAmount = 0;
        float totalBill = 0;

        energyCharge = unitConsumed * 12;
        fixedCharge = 500;

        if (unitConsumed > 1000) {
            rebateAmount = (energyCharge * 0.15f);
        }
        totalBill = energyCharge + extraCharge - rebateAmount;
        display("Internet Services", unitConsumed, energyCharge, fixedCharge, extraCharge, totalBill, rebateAmount);
    }

    private static void residentialServices() {
        System.out.println("Enter Number of Persons:");

        int numberOfPersons = takeInput();

        int costPerPersons = 30;

        int totalCost = numberOfPersons * costPerPersons;
        float extraCost = 0;
        if (totalCost > 3000) {
            extraCost += (totalCost * 0.08f);
        }

        System.out.println("Total Cost for Residential Services:" + (totalCost + extraCost));


    }

    private static void societyServices() {
        System.out.println("Enter Number of Tap:");

        int numberOfPersons = takeInput();

        int costPerTap = 25;

        int totalCost = numberOfPersons * costPerTap;
        float extraCost = 0;
        if (totalCost > 3000) {
            extraCost += (totalCost * 0.08f);
        }

        System.out.println("Total Cost for Tap Services:" + (totalCost + extraCost));
    }

    private static void factoryServices() {
        System.out.println("Enter Number of Machine:");

        int numberOfPersons = takeInput();

        int costPerMachine = 100;

        int totalCost = numberOfPersons * costPerMachine;
        float extraCost = 0;
        if (totalCost > 3000) {
            extraCost += (totalCost * 0.08f);
        }

        System.out.println("Total Cost for Machine Services:" + (totalCost + extraCost));
    }

    private static void waterServices() {


        while (true) {
            System.out.println("Sub Menu:");
            System.out.println("1. Residential");
            System.out.println("2. Society");
            System.out.println("3. Factory");
            System.out.println("4. Back");


            System.out.println("Enter you Choice");


            while (true)
            {
                int subMenuChoice = takeInput();
                switch (subMenuChoice) {

                    case 1:
                        residentialServices();
                        break;
                    case 2:
                        societyServices();
                        break;
                    case 3:
                        factoryServices();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please Enter Valid Choice");
                        continue;

                }
                break;
            }
        }

    }

    private static void studentPlan() {
        while (true) {
            System.out.println("Enter Duration (1,2,3) Months for Student Plan:");

            int numberOfMonth = takeInput();

            switch (numberOfMonth) {
                case 1:
                    System.out.println("Your Cost for student Plan 299");
                    return;
                case 3:
                    System.out.println("Your Cost for student Plan 799");
                    return;
                case 6:
                    System.out.println("Your Cost for student Plan is 1499 after discount of 6% become 1424.05");
                    return;
                default:
                    System.out.println("Enter Valid month");

            }
        }
    }

    private static void homePlan() {
        while (true) {
            System.out.println("Enter Duration (1,2,3) Months For Home Plan:");

            int numberOfMonth = takeInput();
            switch (numberOfMonth) {
                case 1:
                    System.out.println("Your Cost for Home Plan 499");
                    return;
                case 3:
                    System.out.println("Your Cost for Home Plan 1399");
                    return;
                case 6:
                    System.out.println("Your Cost for Home Plan 2699");
                    return;
                default:
                    System.out.println("Enter Valid month");

            }
        }
    }

    private static void bussinessPlan() {
        while (true) {
            System.out.println("Enter Duration (1,2,3) Months For Bussiness Plan:");

            int numberOfMonth = takeInput();
            switch (numberOfMonth) {
                case 1:
                    System.out.println("Your Cost for Bussiness Plan 999");
                    return;
                case 3:
                    System.out.println("Your Cost for Bussiness Plan 2799");
                    return;
                case 6:
                    System.out.println("Your Cost for Bussiness Plan 5499");
                    return;
                default:
                    System.out.println("Enter Valid month");

            }
        }
    }

    private static void internatServices() {


        while (true) {
            System.out.println("Sub Menu:");
            System.out.println("1. Student Plan");
            System.out.println("2. Home Plan");
            System.out.println("3. Business Plan");
            System.out.println("4. Back");




            while (true)
            {
                int subMenuChoice = takeInput();

                switch (subMenuChoice) {

                    case 1:
                        studentPlan();
                        break;
                    case 2:
                        homePlan();
                        break;
                    case 3:
                        bussinessPlan();
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Please Enter Valid Choice");
                        continue;
                }
                break;
            }
        }


    }

    public static void main(String[] args) {
        while (true) {

            System.out.println("-------------- MAIN MENU --------------");
            System.out.println("1. Electricity Service");
            System.out.println("2. Water Service");
            System.out.println("3. Internet Service");
            System.out.println("4. Exit");

            System.out.println("Enter Your Choice:");





            while (true)
            {
                int mainMenueChoice = takeInput();
                switch (mainMenueChoice) {
                    case 1:
                        electricityServices();
                        break;
                    case 2:
                        waterServices();
                        break;
                    case 3:
                        internatServices();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please Enter Valid Choice(1-4)");
                        continue;
                }
                break;
            }


        }


    }
}
