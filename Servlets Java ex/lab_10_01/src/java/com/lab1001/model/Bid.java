package com.lab1001.model;

import java.io.Serializable;
import java.util.Date;

public class Bid implements Serializable {

  private int bidId;
  private Auction auction;
  private float amount;
  private Date bidTime;

  public Bid() {
  }

  public Bid(int bidId, Auction auction, float amount, Date bidTime) {
    this.bidId = bidId;
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