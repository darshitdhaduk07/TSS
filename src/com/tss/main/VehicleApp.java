package com.tss.main;

import com.tss.oop.*;

import java.util.Scanner;

public class VehicleApp {

    public static int numberOfVehicle = 0;
    public static Vehicle[] vehicle = new Vehicle[10];
    public static Scanner sc = new Scanner(System.in);

    public static Vehicle getVehicleById() {
        if (numberOfVehicle == 0) {
            return null;
        }
        System.out.print("Enter vehicle id: ");
        int id = sc.nextInt();

        while (true) {
            for (Vehicle vehicle1 : vehicle) {
                if (vehicle1 == null)
                    continue;
                else if (vehicle1.getId() == id)
                    return vehicle1;
            }

            System.out.print("Please Enter valid Id: ");
            id = sc.nextInt();
        }
    }


    public static void addVehicle() {
        if (numberOfVehicle > 10) {
            System.out.println("\nYou can't add vehicle");
            return;
        }

        System.out.println("----- Select Vehicle -----");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.println("4. Electric Vehicle");

        int choice = sc.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.print("Enter valid choice: ");
            choice = sc.nextInt();
        }

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        while (true) {
            int flag = 0;
            for (Vehicle vehicle1 : vehicle) {
                if (vehicle1 == null)
                    continue;
                else if (vehicle1.getId() == id) {
                    System.out.print("Please Enter unique id: ");
                    id = sc.nextInt();
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }

        System.out.print("If you want to add horn in your vehicle (true/false): ");
        boolean isHorn = sc.nextBoolean();

        System.out.print("If you want to add music Player in your vehicle(true/false): ");
        boolean isPlayMusic = sc.nextBoolean();


        switch (choice) {
            case 1:
                vehicle[numberOfVehicle++] = new Car(id, isHorn, isPlayMusic);
                break;
            case 2:
                vehicle[numberOfVehicle++] = new Bike(id, isHorn, isPlayMusic);
                break;
            case 3:
                vehicle[numberOfVehicle++] = new Truck(id, isHorn, isPlayMusic);
                break;
            case 4:
                System.out.println("1. For EV-Bike");
                System.out.println("2. For EV-Car");
                int c = sc.nextInt();
                while (c < 0 || c > 2) {
                    System.out.print("Please Enter Valid Choice: ");
                    c = sc.nextInt();
                }
                if (c == 1)
                    vehicle[numberOfVehicle] = new EVBike(id, isHorn, isPlayMusic);
                else
                    vehicle[numberOfVehicle] = new EVCar(id, isHorn, isPlayMusic);
        }

        System.out.println("\nYour Vehicle id is: " + id);
        System.out.println("Congratulations! Vehicle Added in your Collection\n");
    }

    public static void startVehicle() {
        Vehicle vehicle1 = getVehicleById();

        if (vehicle1 == null) {
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }


        vehicle1.start();

    }

    public static void stopVehicle()
    {
        Vehicle vehicle1 = getVehicleById();

        if (vehicle1 == null) {
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }


        vehicle1.stop();
    }
    public static void playHorn(){
        Vehicle vehicle1 = getVehicleById();

        if (vehicle1 == null) {
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }


        vehicle1.horn();
    }
    public static void playMusic(){
        Vehicle vehicle1 = getVehicleById();

        if (vehicle1 == null) {
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }
        vehicle1.playMusic();
    }
    public static void vehicleinspection(){
        Vehicle vehicle1 = getVehicleById();

        if (vehicle1 == null) {
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }
        vehicle1.inspection();
    }
    public static void chargeBattery(){
        Vehicle vehicle1 = getVehicleById();

        if(vehicle1 == null){
            System.out.println("\nPlease Add a vehicle first\n");
            return;
        }
        vehicle1.chargeBattery();
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("----------- Vehicle -----------");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Start a vehicle");
            System.out.println("3. Stop a Vehicle");
            System.out.println("4. Charge Battery");
            System.out.println("5. Play horn");
            System.out.println("6. Play Music");
            System.out.println("7. Perform vehicle inspection");
            System.out.println("8. Exit");

            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();

            while (choice < 0 || choice > 7) {
                System.out.println("Enter valid Choice: ");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    startVehicle();
                    break;
                case 3:
                    stopVehicle();
                    break;
                case 4:
                    chargeBattery();
                    break;
                case 5:
                    playHorn();
                    break;
                case 6:
                    playMusic();
                    break;
                case 7:
                    vehicleinspection();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }
}
