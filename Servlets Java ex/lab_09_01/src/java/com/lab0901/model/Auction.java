package com.lab0901.model;

import java.io.Serializable;

public class Auction implements Serializable {

  private int auctionId;
  private int imageId;
  private String title;
  private String description;
  private float currPrice;
  private float increment;
  private AuctionStatus status = AuctionStatus.ACTIVE;
  private ItemCondition condition = ItemCondition.NEW;

  public Auction() {
  }

  public Auction withValues(float currPrice, float increment, AuctionStatus status) {
    this.currPrice = currPrice;
    this.increment = increment;
    this.status = status;
    return this;
  }

  public Auction withItemValues(String title, String description, ItemCondition condition, int imageId) {
    this.description = description;
    this.condition = condition;
    this.imageId = imageId;
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

  public AuctionStatus getStatus() {
    return status;
  }

  public void setStatus(AuctionStatus status) {
    this.status = status;
  }

  public int getImageId() {
    return imageId;
  }

  public void setImageId(int imageId) {
    this.imageId = imageId;
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

  public ItemCondition getCondition() {
    return condition;
  }

  public void setCondition(ItemCondition condition) {
    this.condition = condition;
  }
}