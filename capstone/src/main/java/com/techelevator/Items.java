package com.techelevator;

public class Items extends Stock {

    private String code;

    private String name;

    private double price;

    private String category;

    public Items(String code, String name, double price, String category){
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

}
