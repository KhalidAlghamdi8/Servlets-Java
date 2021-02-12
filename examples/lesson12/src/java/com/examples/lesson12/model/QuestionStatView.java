package com.examples.lesson12.model;

public class QuestionStatView {

  private int correct;
  private int incorrect;
  private Question question;
  private int id;

  public int getCorrect() {
    return correct;
  }

  public void setCorrect(int correct) {
    this.correct = correct;
  }

  public int getIncorrect() {
    return incorrect;
  }

  public void setIncorrect(int incorrect) {
    this.incorrect = incorrect;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
