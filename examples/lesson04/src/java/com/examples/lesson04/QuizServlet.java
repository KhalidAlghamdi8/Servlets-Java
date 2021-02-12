package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet QuizServlet</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
    String username = request.getParameter("name");
    String[] answer = request.getParameterValues("answer");
    if (isCorrect(answer)) {
      out.println("<h1>Great " + username + " you are correct!</h1>");
    } else {
      out.println("<h1>Sorry " + username + " your answer is wrong</h1>");
      out.println("<p>Tip: there are 3 correct options.</p>");
    }

    out.println("<a href=\"quiz.html\">Go Back</a> ");
    out.println("<a href=\"index.html\">Go Home</a>");

    out.println("</body>");
    out.println("</html>");
  }

  private boolean isCorrect(String[] answer) {
    if (answer != null && answer.length == 3 && arrayContains(answer, "web", "fragment", "annotation")) {
      return true;
    } else {
      return false;
    }
  }

  private boolean arrayContains(String[] array, String... options) {
    for (String option : options) {
      if (!arrayContain(array, option)) {
        return false;
      }
    }
    return true;
  }

  private boolean arrayContain(String[] array, String option) {
    for (String arrayElement : array) {
      if (arrayElement.equals(option)) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }
}
