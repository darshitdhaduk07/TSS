package com.tss.collections.accountmanager.main;

public class SavingAccount extends Account {
    private static int offerRate;

    public SavingAccount(double balance, String accountNumber,String holderName ) {
        super(balance,accountNumber,holderName);
    }

    public static void setOfferRate(int rate) {
        offerRate = rate;
    }
    public void deposit(double amount) {
        if(amount > 50000)
        {
            this.setBalance(this.getBalance()+this.getBalance()*(offerRate/100.0) + amount);
            return;

        }
        this.setBalance(this.getBalance()+ amount);

    }
    public boolean withdraw(double amount,TransactionType transactionType) {
        double currentBalance = this.getBalance();

        if(currentBalance >= amount)
        {
            this.setBalance(this.getBalance()-amount);
            System.out.println("Withdraw Success");
            Transaction transaction =  new Transaction(null,null,amount,TransactionType.WITHDRAW);
            transaction.setTransactionSuccess(true);
            this.addTransaction(transaction);
            return true;
        }
        Transaction transaction =  new Transaction(null,null,0,TransactionType.WITHDRAW);
        this.addTransaction(transaction);

        System.out.println("\nInsufficient funds\n");
        return false;

    }

}
