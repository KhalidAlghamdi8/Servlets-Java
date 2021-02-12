package com.examples.lesson07.model;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {

  private final String name;
  private final List<Product> products;

  public ProductCategory(String name) {
    this.name = name;
    products = new ArrayList<Product>();
  }

  public String getName() {
    return name;
  }

  public List<Product> getProducts() {
    return products;
  }
}
