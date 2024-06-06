package com.techelevator;

public class Money extends Application{

    private double balance;
    private double amountDeposited;
    private double totalAmountDue;
    private double remainingAmount;

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmountDeposited() {
        return amountDeposited;
    }
    public void setAmountDeposited(double amountDeposited) {
        this.amountDeposited = amountDeposited;
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }
    public void setTotalAmountDue(double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }
    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public void feedMoney(double feedMoney) {
        balance += feedMoney;
    }
}
