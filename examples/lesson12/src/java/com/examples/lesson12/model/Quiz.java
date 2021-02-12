package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Quiz {

  private int questionId;
  private final String name;
  private final int quizId;
  private String description;
  private int howManyToAsk;
  private final List<Question> questions;
  private boolean error = false;

  public boolean add(Question e) {
    return questions.add(e);
  }

  public Question getQuestion(int index) {
    return questions.get(index);
  }

  public Quiz(int quizId, String name) {
    this.name = name;
    this.quizId = quizId;
    questions = new ArrayList<Question>();
  }

  public Question addQuestion() {
    questionId++;
    Question question = new Question(questionId);
    add(question);
    return question;
  }

  public Question addQuestion(String text) {
    return addQuestion().addText(text, false);
  }

  public Question getNewQuestion(Collection<QuestionResult> askedQuestions) {
    if (questions.isEmpty()) {
      throw new IllegalStateException();
    }
    if (askedQuestions.size() >= questions.size()) {
      List<QuestionResult> emptyList = Collections.emptyList();
      return getNewQuestion(emptyList);
    }
    List<Question> temporalList = new ArrayList<Question>(questions);
    for (QuestionResult qId : askedQuestions) {
      for (Iterator<Question> iter = temporalList.iterator(); iter.hasNext();) {
        if (iter.next().getId() == qId.getQuestionId()) {
          iter.remove();
          break;
        }
      }
    }
    Collections.shuffle(temporalList);
    return temporalList.get(0);
  }

  public Question getQuestionById(int id) {
    for (Question question : questions) {
      if (question.getId() == id) {
        return question;
      }
    }
    return null;
  }

  public boolean isCorrect(int questionId, List<Integer> answerIds) {
    return getQuestionById(questionId).isCorrect(answerIds);
  }

  public boolean isCorrect(int questionId, int... answerIds) {
    return getQuestionById(questionId).isCorrect(answerIds);
  }

  public String getName() {
    return name;
  }

  public int getQuizId() {
    return quizId;
  }

  public void setHowManyToAsk(int howManyToAsk) {
    this.howManyToAsk = howManyToAsk;
  }

  public int getHowManyToAsk() {
    if (howManyToAsk == 0 || howManyToAsk > questions.size()) {
      return questions.size();
    }
    return howManyToAsk;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public int getId() {
    return quizId;
  }

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }
}
