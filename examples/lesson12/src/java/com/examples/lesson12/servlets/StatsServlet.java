package com.examples.lesson12.servlets;

import com.examples.lesson12.model.Question;
import com.examples.lesson12.model.QuestionResult;
import com.examples.lesson12.model.QuestionStatView;
import com.examples.lesson12.model.Quiz;
import com.examples.lesson12.model.QuizCollection;
import com.examples.lesson12.model.QuizResult;
import com.examples.lesson12.model.QuizStatView;
import com.examples.lesson12.services.QuizService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StatsServlet", urlPatterns = {"/instructor/stats"})
public class StatsServlet extends HttpServlet {

  @Inject
  private QuizService quizService;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    List<QuizStatView> quizStat = new ArrayList<QuizStatView>();
    QuizCollection quizzes = (QuizCollection) getServletContext().getAttribute("quizzes");
    for (Quiz quiz : quizzes.getQuizes()) {
      QuizStatView quizStatView = new QuizStatView();
      quizStatView.setId(quiz.getQuizId());
      quizStatView.setQuiz(quiz);
      List<QuestionStatView> questions = new ArrayList<QuestionStatView>();
      for (Question question : quiz.getQuestions()) {
        QuestionStatView questionStat = new QuestionStatView();
        questionStat.setId(question.getId());
        questionStat.setQuestion(question);
        questions.add(questionStat);
      }
      quizStatView.setQuestions(questions);
      quizStat.add(quizStatView);
    }
    List<QuizResult> quizResults = quizService.getAllResults();
    for (QuizResult quizResult : quizResults) {
      for (QuestionResult questionResult : quizResult.getAskedQuestions()) {
        QuestionStatView stat = getQuestion(quizStat, quizResult.getId(), questionResult.getQuestionId());
        if (questionResult.isCorrect()) {
          stat.setCorrect(stat.getCorrect() + 1);
        } else {
          stat.setIncorrect(stat.getIncorrect() + 1);
        }
      }
    }
    request.setAttribute("quizStats", quizStat);

    request.getRequestDispatcher("/instructor/stats.jsp").forward(request, response);
  }

  private QuestionStatView getQuestion(List<QuizStatView> quizStats, int quizId, int questionId) {
    for (QuizStatView quizStat : quizStats) {
      if (quizStat.getId() == quizId) {
        for (QuestionStatView stat : quizStat.getQuestions()) {
          if (stat.getId() == questionId) {
            return stat;
          }
        }
      }
    }
    return null;
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
