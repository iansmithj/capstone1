package com.techelevator;


import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    private Money money = new Money();

    private Inventory stock = new Inventory();



    public void menuOptions() {
        stock.load();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.printf("Enter your choice number: ");
            String typeIn = userInput.nextLine();

            if (typeIn.equals("1")) {
                displayItems();
            } else if (typeIn.equals("2")) {
                purchaseMenu();
            } else if (typeIn.equals("3")) {
                break;
            } else if (typeIn.equals("4")) {
                secretSalesReport();
            } else {
                System.out.println("Not a correct selection. Try again with either a 1, 2, or 3.");
            }
        }
    }

    private void displayItems() {
        for (Item item : stock.getStockInfo()) {
            if (item.getRemaining() > 0) {
                System.out.println(item);
            } else {
                System.out.println("Slot: " + item.getSlot() + ", Name: " + item.getName() + ", Price: " + item.getPrice() + ", Category: " + item.getCategory() + ", SOLD OUT");
            }
        }
    }

 private void purchaseMenu() {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.printf("Current Money Provided: $%.2f\n", money.getBalance());
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            System.out.printf("Enter your choice number: ");
            String choice = userInput.nextLine();

            if (choice.equals("1")) {
                feedMoney();
            } else if (choice.equals("2")) {
                selectProduct();
            } else if (choice.equals("3")) {
                finishTransaction();
                break;
            } else {
                System.out.println("Not a correct selection. Try again with either 1, 2, or 3.");
            }
        }
    }
    private void feedMoney() {
        Scanner userInput = new Scanner(System.in);
        System.out.printf("Enter amount to deposit (whole dollars): ");
        try {
            String input = userInput.nextLine();
            int amountInt = Integer.parseInt(input);
            if (amountInt > 0) {
                BigDecimal amount = new BigDecimal(amountInt);
                money.feedMoney(amount);
                logTransaction("FEED MONEY", amount);
            } else {
                System.out.println("Not correct amount. Please enter whole dollar amounts only.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Not correct input. Please enter a numeric value.");
        }
    }

    private void selectProduct() {
        Scanner userInput = new Scanner(System.in);
        System.out.printf("Enter item slot: ");
        String slot = userInput.nextLine();

        Item selectedItem = null;
        for (Item item : stock.getStockInfo()) {
            if (item.getSlot().equals(slot)) {
                selectedItem = item;
                break;
            }
        }
        if (selectedItem == null) {
            System.out.println("Not a slot. Please enter a valid slot.");
            return;
        }
        if (selectedItem.getRemaining() <= 0) {
            System.out.println("Selected item is SOLD OUT. Please choose a different item");
            return;
        }
        if (money.getBalance().compareTo(selectedItem.getPrice()) < 0) {
            System.out.println("Not enough money. Please add more money if applicable.");
            return;
        }

        money.setBalance(money.getBalance().subtract(selectedItem.getPrice()));
        selectedItem.takeAwayRemaining();
        logTransaction(selectedItem.getName(), selectedItem.getPrice());
        System.out.println(selectedItem.toString());
        String Category = selectedItem.getCategory();
        System.out.println(selectedItem.getDispenseMessage(Category));
    }

    private void finishTransaction() {
        BigDecimal balance = money.getBalance();
        if (balance.compareTo(BigDecimal.ZERO) > 0) {
            System.out.printf("Change to receive: $%.2f\n", balance);
            logTransaction("GIVE CHANGE", balance);
            money.setBalance(BigDecimal.ZERO);
        }
    }

    private void logTransaction(String action, BigDecimal amount) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Log.txt"), true))){
            writer.printf("%s %s: $%.2f $%.2f\n", new Date().toString(), action, amount, money.getBalance());
        } catch (IOException e) {
            System.out.println("Error writing in the Log.txt file.");
        }
    }

    private void secretSalesReport() {
        String filepath = "Log.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(filepath))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }
    }
}