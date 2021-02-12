package com.examples.lesson07.model;

public class Product {

  private final int id;
  private final ProductCategory category;
  private final String name;
  private final double price;

  public Product(int id, ProductCategory category, String name, double price) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public ProductCategory getCategory() {
    return category;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
