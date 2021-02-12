package com.examples.lesson07.view;

import com.examples.lesson07.model.Product;

public class ProductView {

  private final Product product;
  private final int quantity;

  public ProductView(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getTotalPrice() {
    return product.getPrice() * quantity;
  }
}
