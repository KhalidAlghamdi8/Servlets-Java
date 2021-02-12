package com.examples.lesson08.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShopList {

  private int id = 1;
  private String name;
  private final List<ShopItem> items;

  public ShopList() {
    items = new ArrayList<ShopItem>();
  }

  public void add(ShopItem item) {
    item.setId(id);
    id++;
    items.add(item);
  }

  public ShopItem get(int id) {
    for (ShopItem item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public ShopItem remove(int id) {
    for (Iterator<ShopItem> iterator = items.iterator(); iterator.hasNext();) {
      ShopItem item = iterator.next();
      if (item.getId() == id) {
        iterator.remove();
        return item;
      }
    }
    return null;
  }

  public List<ShopItem> getItems() {
    return items;
  }

  public String getName() {
    return name;
  }
}
