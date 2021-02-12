package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.List;

public class QuizResultCollection {

  private List<QuizResult> results = new ArrayList<QuizResult>();

  public QuizResult get(int quizId) {
    for (QuizResult quizResult : results) {
      if (quizResult.getId() == quizId) {
        return quizResult;
      }
    }
    return null;
  }

  public void add(QuizResult quizResult) {
    results.add(quizResult);
  }

  public List<QuizResult> getList() {
    return results;
  }
}
