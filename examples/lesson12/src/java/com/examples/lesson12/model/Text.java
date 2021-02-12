package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.List;

public class Text {

  private boolean code;
  private final List<String> lines;

  public Text(String text, boolean code) {
    this();
    setCode(code);
    setText(text);
  }

  public Text() {
    this.lines = new ArrayList<String>();
  }

  public boolean isCode() {
    return code;
  }

  public String getText() {
    StringBuilder str = new StringBuilder();
    for (String line : lines) {
      if (str.length() > 0) {
        str.append('\n');
      }
      str.append(line);
    }
    return str.toString();
  }

  public void setText(String text) {
    if (text != null) {
      for (String line : text.split("\\n")) {
        if (!code) {
          line = line.trim();
        }
        if (line.trim().length() > 0) {
          lines.add(line);
        }
      }
    }
  }

  public List<String> getLines() {
    return lines;
  }

  public boolean isEmpty() {
    return lines.isEmpty();
  }

  public void setCode(boolean code) {
    this.code = code;
  }
}
