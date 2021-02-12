package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.List;

public class TextContainer {

  private List<Text> texts;

  public TextContainer() {
    texts = new ArrayList<Text>();
  }

  public boolean add(Text text) {
    if (!text.isEmpty()) {
      return texts.add(text);
    }
    return false;
  }

  public Text getText(int index) {
    return texts.get(index);
  }

  public String getTextString(int index) {
    return texts.get(index).getText();
  }

  public List<Text> getTexts() {
    return texts;
  }
}
