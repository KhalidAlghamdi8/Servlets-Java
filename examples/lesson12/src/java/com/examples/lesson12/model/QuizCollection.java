package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizCollection {

  private final Map<Integer, Quiz> quizes;

  public QuizCollection() {
    this.quizes = new HashMap<Integer, Quiz>();
  }

  public Quiz getQuiz(int number) {
    return quizes.get(number);
  }

  public List<Quiz> getQuizes() {
    List<Quiz> quizesList = new ArrayList<Quiz>();
    for (int i = 0; i < quizes.size(); i++) {
      quizesList.add(quizes.get(i + 1));
    }
    return quizesList;
  }

  public void addQuiz(Quiz quiz) {
    this.quizes.put(quiz.getQuizId(), quiz);
  }
}
