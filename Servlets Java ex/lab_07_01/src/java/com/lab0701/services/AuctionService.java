package com.lab0701.services;

import com.lab0701.model.Auction;
import java.util.List;

public interface AuctionService {

  List<Auction> getAllAuctions();

  Auction findAuctionById(int auctionId);
}
