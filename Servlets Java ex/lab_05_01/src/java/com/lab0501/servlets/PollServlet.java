package com.lab0501.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet(name="PollServlet", urlPatterns = {"/Poll"})
public class PollServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String pollName = request.getParameter("poll");
    
    HttpSession session = request.getSession();
    Boolean voted = (Boolean) session.getAttribute(pollName);
    if (voted != null && voted) {
      response.sendRedirect("Result?poll=" + pollName + "&voted=true");
    } else {
      response.sendRedirect(pollName + ".html");
    }
  }
}
