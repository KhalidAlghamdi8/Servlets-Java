package com.examples.lesson12.listeners;

import com.examples.lesson12.model.Quiz;
import com.examples.lesson12.model.QuizCollection;
import com.examples.lesson12.model.QuizResult;
import com.examples.lesson12.model.QuizResultCollection;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class QuizInitializerListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    ServletContext servletContext = session.getServletContext();
    QuizCollection quizzes = (QuizCollection) servletContext.getAttribute("quizzes");
    QuizResultCollection quizResults = new QuizResultCollection();
    for (Quiz quiz : quizzes.getQuizes()) {
      quizResults.add(new QuizResult(quiz.getQuizId(), quiz.getName(), quiz.getHowManyToAsk()));
    }
    session.setAttribute("quizResults", quizResults);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    session.removeAttribute("quizResults");
  }
}
