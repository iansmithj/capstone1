package com.techelevator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stock {

    public List<String[]> pullSplit() {
        String nameFilesplit = "vendingmachine.csv";
        List<String[]> stockInfo = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(nameFilesplit))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                stockInfo.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockInfo;
    }

    // Example usage
    public static void main(String[] args) {
        Stock stock = new Stock();
        List<String[]> stockInfo = stock.pullSplit();
        for (String[] info : stockInfo) {

            System.out.println(Arrays.toString(info));
        }
    }
}




