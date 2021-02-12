package com.examples.lesson12.servlets;

import com.examples.lesson12.model.Question;
import com.examples.lesson12.model.Quiz;
import com.examples.lesson12.model.QuizCollection;
import com.examples.lesson12.model.QuizResult;
import com.examples.lesson12.model.QuizResultCollection;
import com.examples.lesson12.services.QuizService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "quiz-QuizServlet", urlPatterns = {"/quiz/quiz"})
public class QuizServlet extends HttpServlet {

  @Inject
  private QuizService quizService;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    ServletContext context = getServletContext();
    QuizCollection quizzes = (QuizCollection) context.getAttribute("quizzes");
    int quizId = Integer.parseInt(request.getParameter("quiz"));
    Quiz quiz = quizzes.getQuiz(quizId);

    HttpSession session = request.getSession();
    QuizResultCollection results = (QuizResultCollection) session.getAttribute("quizResults");
    QuizResult result = results.get(quizId);

    if (result.isComplete()) {
      quizService.save(result, request.getRemoteUser());
      response.sendRedirect("score?completed=true");
      return;
    }

    String dispatchTo = "/quiz/quizView.jsp";

    //check if there is an answer. if so answer
    if ("answer".equals(request.getParameter("action"))) {
      int questionId = Integer.parseInt(request.getParameter("questionId"));
      Question askedQuestion = quiz.getQuestionById(questionId);

      request.setAttribute("question", askedQuestion);

      String[] answerStrings = request.getParameterValues("answerId");
      if (answerStrings == null) {
        answerStrings = new String[]{};
      }
      int[] answers = new int[answerStrings.length];
      for (int i = 0; i < answerStrings.length; i++) {
        answers[i] = Integer.parseInt(answerStrings[i]);
      }
      if (askedQuestion.isCorrect(answers)) {
        request.setAttribute("result", "true");
        result.addAnswer(questionId, true);
        dispatchTo = "/quiz/quizRes.jsp";
      } else {
        request.setAttribute("result", "false");
        if ("true".equals(request.getParameter("isSecondTry"))) {
          result.addAnswer(questionId, false);
          dispatchTo = "/quiz/quizRes.jsp";
        } else {
          request.setAttribute("isSecondTryAttr", "true");
        }
      }
    }
    if (result.isComplete()) {
      quizService.save(result, request.getRemoteUser());
      response.sendRedirect("score?completed=true");
      return;
    }
    if (request.getAttribute("question") == null) {
      Question question = quiz.getNewQuestion(result.getAskedQuestions());
      request.setAttribute("question", question);
    }
    request.setAttribute("quizResult", result);
    request.setAttribute("quiz", quiz);
    request.setAttribute("questionNo", result.getAskedQuestions().size() + 1);
    request.setAttribute("questionTotal", result.getQuestionsToAsk());
    request.getRequestDispatcher(dispatchTo).forward(request, response);
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
