package com.tss.collections.main;

import com.tss.collections.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountApp {
    static AccountManager accountManager = new AccountManager();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int rate = InputValidator.readInt("Enter offer Rate: ");
        SavingAccount.setOfferRate(rate);

        CurrentAccount.minimumBalance = InputValidator.readDouble("Enter Minimum amount: ");

        while (true) {
            System.out.println("\n==================== BANK MANAGEMENT SYSTEM ====================");
            System.out.println(" 1. Add Account");
            System.out.println(" 2. View All Accounts");
            System.out.println(" 3. Delete Account");
            System.out.println(" 4. Search Account");
            System.out.println(" 5. Deposit Money");
            System.out.println(" 6. Withdraw Money");
            System.out.println(" 7. Transfer Money");
            System.out.println(" 8. View All Transactions");
            System.out.println(" 9. Exit");
            System.out.println("================================================================");
            System.out.print("Enter your choice: ");


            int choice = InputValidator.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    accountManager.addAccount();
                    break;
                case 2:
                    accountManager.showAccounts();
                    break;
                case 3:
                    accountManager.removeAccount();
                    break;
                case 4:
                    Account account = accountManager.searchAccount();
                    if(account!=null){
                        accountManager.showAccountDetail(account);
                    }
                    break;
                case 5:
                    accountManager.deposit();
                    break;
                case 6:
                    accountManager.withdraw();
                    break;
                case 7:
                    accountManager.transfer();
                    break;
                case 8:
                    accountManager.getAllTransactions();
                    break;
                case 9:
                    return;
            }
        }
    }
}
