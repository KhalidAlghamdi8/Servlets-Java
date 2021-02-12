package com.lab1201.sampleData;

import com.lab1201.model.Auction;
import com.lab1201.model.Bid;
import com.lab1201.model.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuctionData {

  private Auction auction;
  private Image image;
  private List<Bid> bids = new ArrayList<Bid>();

  public AuctionData() {
  }

  public AuctionData setAuction(Auction auction) {
    this.auction = auction;
    for (Bid bid : bids) {
      bid.setAuction(auction);
    }
    return this;
  }

  public AuctionData setImage(Image image) {
    this.image = image;
    auction.setImageId(image.getImageId());
    return this;
  }

  public Auction getAuction() {
    return auction;
  }

  public Image getImage() {
    return image;
  }

  public List<Bid> getBids() {
    return bids;
  }

  public AuctionData bid(int i, String mheimer, float f) {
    bids.add(new Bid(i, mheimer, auction, f, new Date()));
    return this;
  }
}
