package com.examples.lesson12.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuestionResult {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "QuestionResultID")
  private int id;
  private int questionId;
  private boolean correct;
  @ManyToOne
  @JoinColumn(name = "QuizResultID")
  private QuizResult quizResult;

  public QuestionResult() {
  }

  public QuestionResult(int questionId, boolean correct, QuizResult result) {
    this.questionId = questionId;
    this.correct = correct;
    this.quizResult = result;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public boolean isCorrect() {
    return correct;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }
}
