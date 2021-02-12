package com.examples.lesson12.servlets;

import com.examples.lesson12.model.Quiz;
import com.examples.lesson12.model.QuizCollection;
import com.examples.lesson12.model.QuizResult;
import com.examples.lesson12.model.QuizResultCollection;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "quiz-ListServlet", urlPatterns = {"/quiz/list"})
public class ListServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    ServletContext context = getServletContext();
    QuizCollection quizzes = (QuizCollection) context.getAttribute("quizzes");
    if (quizzes.getQuizes().size() == 1) {
      Quiz quiz = quizzes.getQuizes().get(0);
      HttpSession session = request.getSession();
      QuizResultCollection results = (QuizResultCollection) session.getAttribute("quizResults");
      QuizResult result = results.get(quiz.getId());
      if (result.isComplete()) {
        response.sendRedirect("score?completed=true");
      } else {
        response.sendRedirect("quiz?quiz=" + quiz.getId());
      }
    } else {
      request.getRequestDispatcher("/quiz/quizList.jsp").forward(request, response);
    }
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
