package com.examples.lesson03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SimpleServlet", urlPatterns = {"/servlets/SimpleServlet"})
public class SimpleServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>Hello World Servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>HELLO WORLD!</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
