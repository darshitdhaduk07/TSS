package com.tss.stream.account;

import java.util.Comparator;
import java.util.List;

public class AccountApp {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account(2005001L, "Swapnil sir", 150000.00),
                new Account(2005002L, "Sonia", 72000.50),
                new Account(2005003L, "Ravi", 31000.25),
                new Account(2005004L, "Pooja", 9800.00),
                new Account(1001001L, "Rahul", 25000.50),
                new Account(1001002L, "Anita", 48000.00),
                new Account(1001003L, "Vikram kumar", 12000.75),
                new Account(1001004L, "Neha", 90000.00)

        );

        System.out.println("Minimum Balance: ");
        //print minimum balance
        accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance))
                .limit(1)
                .forEach(System.out::println);

        System.out.println("\n\n");

        //print maximum balance
        System.out.println("Maximum balance: ");
        accounts.stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .limit(1)
                .forEach(System.out::println);

        System.out.println("\n\n");



        System.out.println("name greater than 6 char: ");
        accounts.stream()
                .filter(account -> account.getName().length() > 6)
                .forEach(System.out::println);

        System.out.println("\n\n");



        double totalBal =  accounts.stream()
                .map(Account::getBalance)
                .reduce(0.0,Double::sum);

        System.out.println("Total BAl: "+totalBal);
    }
}
