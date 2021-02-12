package com.examples.lesson12.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class QuizResult implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "QuizResultID")
  private int id;
  private int quizId;
  @Column(name = "Title")
  private String name;
  @Column(name = "UserName")
  private String user;
  @OneToMany(mappedBy = "quizResult", cascade = {CascadeType.ALL})
  private Set<QuestionResult> askedQuestions;
  @Transient
  private int questionsToAsk;
  @Transient
  private int quizPoints;
  @Transient
  private boolean saved = false;

  public QuizResult() {
    askedQuestions = new HashSet<QuestionResult>();
  }

  public QuizResult(int id, String name, int questionsToAsk) {
    this();
    this.quizId = id;
    this.name = name;
    this.questionsToAsk = questionsToAsk;
  }

  public int getId() {
    return quizId;
  }

  public String getName() {
    return name;
  }

  public int getQuizPoints() {
    return quizPoints;
  }

  public int getQuizQuestions() {
    return askedQuestions.size();
  }

  public boolean isComplete() {
    return askedQuestions.size() >= questionsToAsk;
  }

  public Set<QuestionResult> getAskedQuestions() {
    return askedQuestions;
  }

  public void addAnswer(int questionId, boolean correct) {
    askedQuestions.add(new QuestionResult(questionId, correct, this));
    if (correct) {
      quizPoints++;
    }
  }

  public int getQuestionsToAsk() {
    return questionsToAsk;
  }

  public int getCorrectPercent() {
    if (askedQuestions.isEmpty()) {
      return 0;
    }
    return ((quizPoints * 100) / askedQuestions.size());
  }

  public int getRemainingQuestions() {
    return questionsToAsk - askedQuestions.size();
  }

  public int getCellWidth() {
    if (questionsToAsk > 0) {
      int width = (int) (150 / questionsToAsk);
      return Math.min(10, Math.max(width, 1));
    }
    return 10;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public boolean isSaved() {
    return saved;
  }

  public void setSaved(boolean saved) {
    this.saved = saved;
  }
}
