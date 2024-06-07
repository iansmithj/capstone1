package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

    public Drink(String slot, String name, BigDecimal price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public String getDispenseMessage() {
        return " Glug Glug, Yum!";
    }
}
