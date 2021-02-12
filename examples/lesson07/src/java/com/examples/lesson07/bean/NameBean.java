package com.examples.lesson07.bean;

public class NameBean {

  private String name;

  public String getName() {
    return name == null ? "world" : name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
