package com.lab0501.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet(name="VoteServlet", urlPatterns = {"/Vote"})
public class VoteServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String pollName = request.getParameter("poll");
    String option = request.getParameter("option");

    PollCollection polls = (PollCollection) getServletContext().getAttribute("polls");
    Poll poll = polls.getPoll(pollName);

    HttpSession session = request.getSession();
    Boolean voted = (Boolean) session.getAttribute(pollName);
    if (voted != null && voted) {
      response.sendRedirect("Result?poll=" + pollName + "&voted=true");
    } else {
      poll.vote(option);
      session.setAttribute(pollName, true);
      response.sendRedirect("Result?poll=" + pollName);
    }
    
  }
}
