package com.lab1102.services;

import com.lab1102.model.Auction;
import java.util.List;

public interface AuctionService {

  List<Auction> getAllAuctions();

  Auction findAuctionById(int auctionId);

  void addAuction(Auction auction);

  void updateAuction(Auction auction);

  String bid(int auctionId, String user, float bidAmount);
}
