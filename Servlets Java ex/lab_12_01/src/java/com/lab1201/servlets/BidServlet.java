package com.lab1201.servlets;

import com.lab1201.services.AuctionService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BidServlet", urlPatterns = {"/BidServlet"})
public class BidServlet extends HttpServlet {

  @Inject
  private AuctionService auctionService;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("id") == null) {
      response.sendRedirect(getServletContext().getContextPath() + "/ListServlet");
      return;
    }

    int auctionId = Integer.parseInt(request.getParameter("id"));
    float bidAmount = Float.parseFloat(request.getParameter("bidAmount"));
    if (request.authenticate(response) && request.isUserInRole("user")) {
      String user = request.getRemoteUser();
      String result = auctionService.bid(auctionId, user, bidAmount);
      request.setAttribute("message", result);
    } else {
      request.setAttribute("message", "User not authorized.");
    }
    request.getRequestDispatcher("/DetailServlet").forward(request, response);
  }
}
