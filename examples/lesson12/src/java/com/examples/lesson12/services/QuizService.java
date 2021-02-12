package com.examples.lesson12.services;

import com.examples.lesson12.model.QuizResult;
import java.util.List;

public interface QuizService {

  public List<QuizResult> getAllResults();

  public void save(QuizResult result, String remoteUser);
}
