package com.lab1001.services;

import com.lab1001.model.Auction;
import java.util.List;

public interface AuctionService {

  List<Auction> getAllAuctions();

  Auction findAuctionById(int auctionId);

  void addAuction(Auction auction);

  void updateAuction(Auction auction);

  boolean bid(int auctionId, float bidAmount);
}
