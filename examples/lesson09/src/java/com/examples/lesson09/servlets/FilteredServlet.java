package com.examples.lesson09.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FilteredServlet", urlPatterns = {"/FilteredServlet"})
public class FilteredServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.setAttribute("name", "John");
    request.setAttribute("servletName", "Filtered Servlet");
    request.setAttribute("status", "OK");
    request.getRequestDispatcher("/filteredServletView.jsp").forward(request, response);
  }
}
