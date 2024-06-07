package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item {

    public Gum(String slot, String name, BigDecimal price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public String getDispenseMessage() {
        return " Chew Chew, Yum!";
    }
}
