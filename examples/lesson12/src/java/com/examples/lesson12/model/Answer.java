package com.examples.lesson12.model;

public class Answer extends TextContainer {

  private final int id;
  private final boolean correct;

  Answer(int id, boolean correct) {
    this.id = id;
    this.correct = correct;
  }

  Answer(int id, String text, boolean correct) {
    this(id, correct);
    addText(text, false);
  }

  public final Answer addText(String text, boolean isCode) {
    add(new Text(text.trim(), isCode));
    return this;
  }

  public int getId() {
    return id;
  }

  public boolean isCorrect() {
    return correct;
  }
}
