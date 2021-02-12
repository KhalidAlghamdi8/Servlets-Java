package com.examples.lesson07.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

  private Map<Integer, Integer> items;

  public ShoppingCart() {
    items = new HashMap<Integer, Integer>();
  }

  public void add(int productId) {
    int quantity = getQuantity(productId);
    quantity++;
    items.put(productId, quantity);
  }

  public void remove(int productId) {
    int quantity = getQuantity(productId);
    quantity--;
    if (quantity < 0) {
      items.remove(productId);
    } else {
      items.put(productId, quantity);
    }
  }

  public int getQuantity(int productId) {
    Integer quantity = items.get(productId);
    if (quantity == null) {
      return 0;
    } else {
      return quantity.intValue();
    }
  }
}
