package com.techelevator;

import java.io.File;

public class Inventory {

 private double price;

 private String name;

 private String code;

 private String itemCategory;

 private String pipe1;

 private String pipe2;

 private String pipe3;





 public Inventory(String code, String pipe1, String name, String pipe2, double price, String pipe3, String itemCategory) {
this.price = price;
this.name = name;
this.code = code;
this.itemCategory = itemCategory;
this.pipe1 = pipe1;
  this.pipe2 = pipe2;
  this.pipe3 = pipe3;
 }

 public double getPrice() {
return price;
 }

 public String getName() {
  return name;
 }

 public String getCode() {
  return code;
 }

 public String getItemCategory() {
  return itemCategory;
 }

 public String getPipe1() {
  return pipe1;
 }
 public String getPipe2() {
  return pipe2;
 }
 public String getPipe3() {
  return pipe3;
 }







}
