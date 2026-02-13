package com.tss.functionalinterface.payment;

import java.util.Scanner;

public class PaymentApp {
    static boolean processPayment(Payment payment, double amount)
    {
        return payment.pay(amount);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment creadit = amount -> amount <= 100000 && amount >0;
        Payment upi = amount -> amount <= 50000 && amount >0;
        Payment netBanking = amount -> amount > 0;


        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();

        System.out.println("Enter Your amount");
        double amount = sc.nextDouble();

        boolean status = false;
        switch (choice)
        {
            case 1:
                System.out.println("payment by Creadit Card");
                status = processPayment(creadit,amount);
                break;

            case 2:
                System.out.println("payment by Upi");

                status = processPayment(upi,amount);
                break;
            case 3:
                System.out.println("payment by NetBanking");
                status = processPayment(netBanking,amount);
                break;
            default:
                System.out.println("Enter valid choice");
                return;

        }

        if(status)
        {
            System.out.println("payment success full");
        }
        else System.out.println("payment failed");
    }
}
