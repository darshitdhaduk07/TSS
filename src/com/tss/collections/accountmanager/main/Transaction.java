package com.tss.collections.accountmanager.main;

public class Transaction {
    private static long idCounter = 1000000000L;
    private long id;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private double transactionAmount;
    TransactionType transactionType;
    private boolean transactionSuccess;


    public Transaction() {}

    public Transaction(String senderAccountNumber, String receiverAccountNumber, double transactionAmount, TransactionType transactionType) {
        this.id = ++idCounter;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
    }

    public long getId() {
        return id;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }
    public double getTransactionAmount() {
        return transactionAmount;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }
    public boolean isTransactionSuccess() {
        return transactionSuccess;
    }
    public void setTransactionSuccess(boolean transactionSuccess) {
        this.transactionSuccess = transactionSuccess;
    }
}
