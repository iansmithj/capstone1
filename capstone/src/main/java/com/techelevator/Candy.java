package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

    public Candy(String slot, String name, BigDecimal price, String category) {
        super(slot, name, price, category);
    }


    public String getDispenseMessage() {
        return " Munch Munch, Yum!";
    }
}
