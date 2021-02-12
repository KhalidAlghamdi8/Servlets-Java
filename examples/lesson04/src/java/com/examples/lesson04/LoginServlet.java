package com.examples.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login.do"})
public class LoginServlet extends HttpServlet {
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");
    
    if ("123456".equals(password)) {
      HttpSession session = request.getSession();
      session.setAttribute("user_name", username);
      session.setAttribute("user_role", role);
      response.sendRedirect("greet");
    } else {
      response.sendRedirect("loginFailed.html");
    }
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
