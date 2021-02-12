package com.examples.lesson03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MethodServlet", urlPatterns = {"/servlets/MethodServlet"})
public class MethodServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>GET ON Servlet MethodServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Servlet MethodServlet invoked with GET</h1>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>POST ON Servlet MethodServlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Servlet MethodServlet invoked with POST</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}
