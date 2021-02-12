package com.lab1201.services;

import com.lab1201.model.Auction;
import java.util.List;

public interface AuctionService {

  List<Auction> getAllAuctions();

  Auction findAuctionById(int auctionId);

  Auction addAuction(Auction auction);

  Auction updateAuction(Auction auction);

  String bid(int auctionId, String user, float bidAmount);
}
