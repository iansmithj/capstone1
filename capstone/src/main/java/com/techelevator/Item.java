package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private String slot;

    private String name;

    private BigDecimal price;

    private String category;

    private int remaining = 5;

    public Item(String slot, String name, BigDecimal price, String category) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.category = category;

    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getRemaining() {
        return remaining;
    }

    public void takeAwayRemaining() {
        if (remaining > 0) {
            remaining--;
        }
    }

    @Override
    public String toString() {
        return slot + " | " + name + " | " + category + " | $" + price + " | QTY: " + getRemaining();

    }

    public String getDispenseMessage(String Category) {
        if(Category.equals("Chip")) {
            return "Crunch Crunch, Yum!";
        } else if (Category.equals("Gum")) {
            return "Chew Chew, Yum!";
        } else if (Category.equals("Drink")) {
            return "Glug Glug, Yum";
        } else {
            return "Munch Munch, Yum!";
        }
    }
}
