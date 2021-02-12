package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloSvlt"})
public class HelloServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Hello</title>");
    out.println("<link rel=\"stylesheet\" href=\"res/styles.css\" type=\"text/css\"/>");
    out.println("</head>");
    out.println("<body>");

    String username = request.getParameter("username");
    String role = request.getParameter("role");

    out.println("<h1>Hello " + username + "</h1>");
    out.println("<h3>You are a " + role + "</h3>");

    out.println("<a href=\"helloForm.html\">Go Back</a> ");
    out.println("<a href=\"index.html\">Go Home</a>");
    out.println("</body>");
    out.println("</html>");
  }
}
