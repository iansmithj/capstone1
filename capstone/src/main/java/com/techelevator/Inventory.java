package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Item> stockInfo = new ArrayList<>();

    public List<Item> getStockInfo() {
        return stockInfo;
    }

    public void load() {
        String nameFileSplit = "vendingmachine.csv";

        try (Scanner scanner = new Scanner(new File(nameFileSplit))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                BigDecimal price = new BigDecimal(parts[2]);
                stockInfo.add(new Item(parts[0], parts[1], price , parts[3]));
            }
        } catch (IOException e) {
            System.out.println("This is not an appropriate file.");
        }

    }
}





