package com.lab0701.model;

import java.io.Serializable;

public class Auction implements Serializable {

  private int auctionId;
  private String title;
  private String description;
  private float currPrice;
  private float increment;
  private boolean active;

  public Auction() {
  }

  public Auction(int auctionId) {
    this.auctionId = auctionId;
  }

  public Auction withValues(float currPrice, float increment, boolean active) {
    this.currPrice = currPrice;
    this.increment = increment;
    this.active = active;
    return this;
  }

  public Auction withItemValues(String title, String description) {
    this.description = description;
    this.title = title;
    return this;
  }

  public int getAuctionId() {
    return auctionId;
  }

  public void setAuctionId(int auctionId) {
    this.auctionId = auctionId;
  }

  public float getCurrPrice() {
    return currPrice;
  }

  public void setCurrPrice(float currPrice) {
    this.currPrice = currPrice;
  }

  public float getIncrement() {
    return increment;
  }

  public void setIncrement(float increment) {
    this.increment = increment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}