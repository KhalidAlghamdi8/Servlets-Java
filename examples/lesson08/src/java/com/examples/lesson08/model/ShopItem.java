package com.examples.lesson08.model;

public class ShopItem {

  private int id;
  private String name;
  private String category;
  private int count;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void add() {
    count++;
  }

  public void remove() {
    count--;
  }
}
