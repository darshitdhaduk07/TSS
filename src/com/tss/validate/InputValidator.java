package com.tss.validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Scanner sc = new Scanner(System.in);

    // ---------- STRING VALIDATION ----------
    public static String readString(String message) {
        String regex = "^[A-Za-z]+( +[A-Za-z]+)*$";
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (Pattern.matches(regex, input)) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
    }

    public static String readAccountNumber(String message) {
        String regex = "\\d+";
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (Pattern.matches(regex, input)) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
    }

    // ---------- INTEGER VALIDATION ----------
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid integer. Numbers only allowed.");
            }
        }
    }


    // ---------- DOUBLE VALIDATION ----------
    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();

            if (input.matches("\\d+(\\.\\d+)?")) {
                if(Double.parseDouble(input) == 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                return Double.parseDouble(input);
            } else {
                System.out.println("Invalid number. Enter a valid amount.");
            }
        }
    }

    // ---------- EMAIL VALIDATION ----------
    public static String readEmail(String message) {

        String emailRegex =
                "^[a-z0-9+_.-]+@[a-z0-9.-]+\\.[a-z]{2,}$";

        while (true) {
            System.out.print(message);
            String email = sc.nextLine().trim();

            if (email.matches(emailRegex)) {
                return email;
            } else {
                System.out.println("Invalid email. Use lowercase letters only.");
            }
        }
    }

}
