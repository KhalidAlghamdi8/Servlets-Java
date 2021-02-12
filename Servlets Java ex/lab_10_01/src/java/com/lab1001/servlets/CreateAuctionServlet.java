package com.lab1001.servlets;

import com.lab1001.model.Auction;
import com.lab1001.services.AuctionService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateAuctionServlet", urlPatterns = {"/CreateAuctionServlet"})
public class CreateAuctionServlet extends HttpServlet {

  @Inject
  private AuctionService auctionService;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String auctionTitle = request.getParameter("auctionTitle");
    String auctionDescription = request.getParameter("auctionDescription");

    Auction auction = new Auction();
    auction.setTitle(auctionTitle);
    auction.setDescription(auctionDescription);
    auctionService.addAuction(auction);
    request.setAttribute("message", "Auction created");
    request.getRequestDispatcher("/ListServlet").forward(request, response);
  }
}
