package com.examples.lesson12.listeners;

import com.examples.lesson12.model.Quiz;
import com.examples.lesson12.model.QuizCollection;
import com.examples.lesson12.services.QuizXmlParser;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class QuizLoadListener implements ServletContextListener {

  private QuizXmlParser quizXmlParser;

  public QuizLoadListener() {
    try {
      quizXmlParser = new QuizXmlParser();
    } catch (Exception ex) {
      Logger.getLogger(QuizLoadListener.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();
    Iterable<QuizConfig> configs = QuizConfig.create(context.getResourceAsStream("/WEB-INF/quiz-config.xml"));
    QuizCollection quizzes = new QuizCollection();
    int quizId = 1;
    for (QuizConfig quizConfig : configs) {
      Quiz quiz = new Quiz(quizId, quizConfig.getName());
      quiz.setDescription(quizConfig.getDescription());
      quiz.setHowManyToAsk(quizConfig.getQuestionCount());
      for (String source : quizConfig.getSources()) {
        try {
          InputStream quizStream = context.getResourceAsStream(source);
          quizXmlParser.addQuestionsToQuiz(quiz, quizStream);
        } catch (Exception ex) {
          Logger.getLogger(QuizLoadListener.class.getName()).log(Level.SEVERE, "ERROR IN: {0}", source);
          Logger.getLogger(QuizLoadListener.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      quizzes.addQuiz(quiz);
      quizId++;
    }
    context.setAttribute("quizzes", quizzes);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();
    context.removeAttribute("quizzes");
  }
}
