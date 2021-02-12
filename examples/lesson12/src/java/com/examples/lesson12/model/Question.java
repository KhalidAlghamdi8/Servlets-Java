package com.examples.lesson12.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Question extends TextContainer {

  private final int id;
  private final List<Answer> correctAnswer;
  private final List<Answer> options;
  private int answerId = 0;
  private String title;

  public Question(int id) {
    this.id = id;
    correctAnswer = new ArrayList<Answer>();
    options = new ArrayList<Answer>();
    title = "Question";
  }

  @Override
  public boolean add(Text text) {
    if (!text.isEmpty()) {
      return super.add(text);
    }
    return false;
  }

  public Question addText(String text, boolean isCode) {
    add(new Text(text, isCode));
    return this;
  }

  public Answer addAnswer(boolean isCorrect) {
    answerId++;
    Answer answer = new Answer(answerId, isCorrect);
    if (isCorrect) {
      correctAnswer.add(answer);
    }
    options.add(answer);
    return answer;
  }

  public Question addCorrectOption(String option) {
    addAnswer(true).addText(option, false);
    return this;
  }

  public Question addOption(String option) {
    addAnswer(false).addText(option, false);
    return this;
  }

  public boolean isCorrect(List<Integer> optionsId) {
    List<Integer> selectedOptions = new ArrayList<Integer>(optionsId);
    if (selectedOptions.size() == correctAnswer.size()) {
      for (Answer answer : correctAnswer) {
        for (Iterator<Integer> iter = selectedOptions.iterator(); iter.hasNext();) {
          int optionId = iter.next();
          if (optionId == answer.getId()) {
            iter.remove();
            break;
          }
        }
      }
      return selectedOptions.isEmpty();
    }
    return false;
  }

  public boolean isCorrect(int... optionsId) {
    List<Integer> selectedOptions = new ArrayList<Integer>();
    for (int optionId : optionsId) {
      selectedOptions.add(optionId);
    }
    return isCorrect(selectedOptions);
  }

  public List<Answer> getOptions() {
    final List<Answer> list = new ArrayList<Answer>(options);
    Collections.shuffle(list);
    return list;
  }

  public int getId() {
    return id;
  }

  public int getNumberOfCorrectOptions() {
    return correctAnswer.size();
  }

  public List<Answer> getAnswers() {
    return options;
  }

  public String getTitle() {
    return title;
  }

  public Question setTitle(String title) {
    this.title = title;
    return this;
  }
}
