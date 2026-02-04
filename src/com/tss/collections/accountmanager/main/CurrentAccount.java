package com.tss.collections.accountmanager.main;


public class CurrentAccount extends Account {
    public static double minimumBalance;

    public CurrentAccount(double balance, String accountNumber,String holderName ) {
        super(balance,accountNumber,holderName);
    }

    public boolean withdraw(double amount,TransactionType type) {
        double currentBalance = this.getBalance();
        Transaction transaction;
        if(currentBalance - minimumBalance >= amount) {
            this.setBalance(this.getBalance() - amount);
            if(type == TransactionType.TRANSFER) {
                return true;
            }
            transaction = new Transaction(null,null,this.getBalance(),TransactionType.WITHDRAW);
            this.addTransaction(transaction);
            System.out.println("Withdraw Success");
            return true;
        }
        System.out.println("\nInsufficient funds\n");

        if(TransactionType.TRANSFER == type)
            return false;

        transaction = new Transaction(null,null,this.getBalance(),TransactionType.WITHDRAW);
        transaction.setTransactionSuccess(false);
        this.addTransaction(transaction);
        return false;

    }
}
