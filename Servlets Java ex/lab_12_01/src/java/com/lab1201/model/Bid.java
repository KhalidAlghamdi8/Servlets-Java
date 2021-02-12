package com.lab1201.model;

import java.io.Serializable;
import java.util.Date;

public class Bid implements Serializable {

  private int bidId;
  private String bidder;
  private Auction auction;
  private float amount;
  private Date bidTime;

  public Bid() {
  }

  public Bid(int bidId, String bidderId, Auction auction, float amount, Date bidTime) {
    this.bidId = bidId;
    this.bidder = bidderId;
    this.auction = auction;
    this.amount = amount;
    this.bidTime = bidTime;
  }

  public int getBidId() {
    return bidId;
  }

  public void setBidId(int bidId) {
    this.bidId = bidId;
  }

  public String getBidder() {
    return bidder;
  }

  public void setBidder(String bidderId) {
    this.bidder = bidderId;
  }

  public Auction getAuction() {
    return auction;
  }

  public void setAuction(Auction auction) {
    this.auction = auction;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public Date getBidTime() {
    return bidTime;
  }

  public void setBidTime(Date bidTime) {
    this.bidTime = bidTime;
  }
}