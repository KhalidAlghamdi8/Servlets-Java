package com.lab0801.services;

import com.lab0801.model.Auction;
import java.util.List;

public interface AuctionService {

  List<Auction> getAllAuctions();

  Auction findAuctionById(int auctionId);

  void addAuction(Auction auction);

  void updateAuction(Auction auction);

  boolean bid(int auctionId, float bidAmount);
}
