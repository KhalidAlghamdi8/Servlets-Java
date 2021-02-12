package com.lab0402.servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PollServlet", urlPatterns = {"/PollServlet"})
public class PollServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Modify this method.
    String poolName = request.getParameter("pollName");
    String option = request.getParameter("option");
    HttpSession session = request.getSession();
    Boolean voted = (Boolean)session.getAttribute(poolName);
    if (voted != null && voted == true){
        printFail(response, poolName);
    }else{
        vote(poolName, option);
        session.setAttribute(poolName,true);
        printSuccess(response, poolName);
    }
            }

  /**
   * Prints a failure message in the response. Use this method when the user
   * already voted on a poll.
   *
   * @param response The HttpServletResponse object
   * @param pollName The name of the poll the user tried to vote on.
   * @throws IOException
   */
  public void printFail(HttpServletResponse response, String pollName) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    printPoll(out, getPoll(pollName), "You cannot vote on the poll.");
  }

  /**
   * Prints a success message in the response. Use this method when the user
   * successfully voted on a poll.
   *
   * @param response The HttpServletResponse object.
   * @param pollName The name of the poll the user voted on.
   * @throws IOException
   */
  public void printSuccess(HttpServletResponse response, String pollName) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    printPoll(out, getPoll(pollName), "Vote successful.");
  }

  /**
   * Casts a vote on a poll option.
   *
   * @param pollName The name of the poll the user voted on.
   * @param option The selected option by the user
   */
  public void vote(String pollName, String option) {
    Poll poll = getPoll(pollName);
    Integer votes = poll.get(option);
    if (votes == null) {
      votes = 0;
    }
    votes++;
    poll.put(option, votes);
  }
  /**
   * The collection of polls available.
   */
  private Map<String, Poll> polls = new HashMap<String, Poll>();

  /**
   * Do not call this method.
   */
  private void printPoll(PrintWriter out, Poll poll, String message) {
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Votes</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>" + message + "</h1>");

    out.println("<h2>Poll results.</h2>");
    out.println("<h3>" + poll.getName() + "</h3>");
    out.println("<ul>");
    for (Map.Entry<String, Integer> vote : poll.entrySet()) {
      out.println("<li>" + vote.getKey() + ":" + vote.getValue() + "</li>");
    }
    out.println("</ul>");

    out.println("</body>");
    out.println("</html>");
  }

  /**
   * Do not call this method.
   */
  private Poll getPoll(String pollName) {
    Poll poll = polls.get(pollName);
    if (poll == null) {
      poll = new Poll(pollName);
      polls.put(pollName, poll);
    }
    return poll;
  }
}