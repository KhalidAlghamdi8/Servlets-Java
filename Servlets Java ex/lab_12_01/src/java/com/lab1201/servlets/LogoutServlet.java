package com.lab1201.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      request.logout();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      request.getSession().invalidate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
  }
}
