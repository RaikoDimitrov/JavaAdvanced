package com.company.DefiningClasses.BankAccount;

public class BankAccount {
    private static final double RATE_DEFAULT_VALUE = 0.02;
    private static int counter = 0;
    private int id;
    private double balance;
    private static double interestRate = RATE_DEFAULT_VALUE;

    public BankAccount() {
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public void deposit(double money) {
        this.balance += money;
    }
}
