package com.examples.lesson12.servlets;

import com.examples.lesson12.model.QuizCollection;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "quiz-FullView", urlPatterns = {"/admin/fullview"})
public class FullView extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    ServletContext context = getServletContext();
    QuizCollection quizzes = (QuizCollection) context.getAttribute("quizzes");
    request.setAttribute("quizzes", quizzes.getQuizes());
    request.getRequestDispatcher("/admin/fullview.jsp").forward(request, response);
  }
}
