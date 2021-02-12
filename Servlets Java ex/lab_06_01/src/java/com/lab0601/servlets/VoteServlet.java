package com.lab0601.servlets;

import com.lab0601.model.PollResult;
import com.lab0601.services.PollService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VoteServlet", urlPatterns = {"/VoteServlet"})
public class VoteServlet extends HttpServlet {
    
    @Inject
private PollService pollService;
    
    
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    //Implement the control Servlet.
    
    String selectdOption = request.getParameter("option");
    
    pollService.vote(selectdOption);
    
    List<PollResult> pollResults = new ArrayList <PollResult>();
    String [] allAvailableOption = pollService.getOptions();
    for (String op:allAvailableOption){
     PollResult pr = new PollResult (op, pollService.getVotes(op));
     pollResults.add(pr);

    }
    
         request.setAttribute("pollResults", pollResults);
     
     request.getRequestDispatcher("pollResult.jsp").forward(request, response);
  }
}
