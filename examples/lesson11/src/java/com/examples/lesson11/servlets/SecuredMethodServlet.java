package com.examples.lesson11.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecuredMethodServlet", urlPatterns = {"/SecuredMethodServlet"})
@DeclareRoles({"quizUser", "quizPublisher", "quizAdmin"})
public class SecuredMethodServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //try to send authentication if the user is not authenticated yet.
    if (request.authenticate(response)) {
      PrintWriter out = response.getWriter();
      if (request.isUserInRole("quizUser")) {
        printHead(out);
        out.println("<h1>Welcome user</h1>");
        printFooter(out);
      } else if (request.isUserInRole("quizInstructor")) {
        printHead(out);
        out.println("<h1>Welcome instructor</h1>");
        printFooter(out);
      } else if (request.isUserInRole("quizAdmin")) {
        printHead(out);
        out.println("<h1>Welcome admin</h1>");
        printFooter(out);
      } else {
        request.getRequestDispatcher("/errors/accessDenied.jsp").forward(request, response);
      }
    }
  }

  private void printHead(PrintWriter out) {
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Headers</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");
  }

  private void printFooter(PrintWriter out) {
    out.println("<a href=\"index.jsp\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
