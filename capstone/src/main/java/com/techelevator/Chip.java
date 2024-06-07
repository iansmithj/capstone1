package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item {

    public Chip(String slot, String name, BigDecimal price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public String getDispenseMessage() {
        return " Crunch Crunch, Yum!";
    }
}
