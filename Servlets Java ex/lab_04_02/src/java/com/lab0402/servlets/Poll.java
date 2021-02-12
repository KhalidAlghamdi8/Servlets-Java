package com.lab0402.servlets;

import java.util.HashMap;
import java.util.Map;

public class Poll extends HashMap<String, Integer> implements Map<String, Integer> {

  private final String name;

  public Poll(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
