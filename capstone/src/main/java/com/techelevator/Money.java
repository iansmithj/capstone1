package com.techelevator;

import java.math.BigDecimal;

public class Money {

    private BigDecimal balance = BigDecimal.ZERO;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney(BigDecimal feedMoney) {
        balance = balance.add(feedMoney);
    }
}
