package com.teachmeskills.lesson_8.task1.model.account;

public class Account {

    private String accountNumber;
    private double amount;

    public Account(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAddToCard(int amount){
        this.amount += amount;
    }

    public void setFromCardToCard(int amount){
        this.amount -= amount;
    }
}