package com.lab1102.servlets;

import com.lab1102.model.Auction;
import com.lab1102.model.Image;
import com.lab1102.services.AuctionService;
import com.lab1102.services.ImageService;
import com.lab1102.util.AuctionUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "CreateAuctionServlet", urlPatterns = {"/CreateAuctionServlet"})
@MultipartConfig
public class CreateAuctionServlet extends HttpServlet {

  @Inject
  private ImageService imageService;
  @Inject
  private AuctionService auctionService;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //imageFile
    Part part = request.getPart("imageFile");

    Image image = new Image();
    OutputStream out = image.getOutputStream();
    InputStream in = part.getInputStream();

    byte buffer[] = new byte[4048];
    int bytesRead;
    while ((bytesRead = in.read(buffer)) > 0) {
      out.write(buffer, 0, bytesRead);
    }
    in.close();
    out.close();

    image.setContentType(part.getContentType());

    imageService.addImage(image);

    String auctionTitle = request.getParameter("auctionTitle");
    String auctionDescription = request.getParameter("auctionDescription");

    Auction auction = new Auction();
    auction.setTitle(auctionTitle);
    auction.setDescription(auctionDescription);
    auction.setImageId(image.getImageId());
    float price = Float.parseFloat(request.getParameter("auctionStartPrice"));
    auction.setCurrPrice(price);
    auction.setIncrement(AuctionUtil.defineIncrement(price));

    //Set user as highest bidder and seller


    auctionService.addAuction(auction);
    request.setAttribute("message", "Auction created");
    request.getRequestDispatcher("/ListServlet").forward(request, response);
  }
}
