package com.examples.lesson12.model;

import java.util.List;

public class QuizStatView {

  private int id;
  private Quiz quiz;
  private List<QuestionStatView> questions;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
  }

  public List<QuestionStatView> getQuestions() {
    return questions;
  }

  public void setQuestions(List<QuestionStatView> questions) {
    this.questions = questions;
  }
}
