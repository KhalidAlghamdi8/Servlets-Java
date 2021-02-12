package com.lab0801.services;

import com.lab0801.model.Auction;
import com.lab0801.model.AuctionStatus;
import com.lab0801.model.Bid;
import com.lab0801.model.ItemCondition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuctionServiceMemImpl implements AuctionService {

  private Map<Integer, Auction> auctions;
  private Map<Integer, Bid> bids;
  private int currentAuctionId = 100;
  private int currentBidId = 10;

  public AuctionServiceMemImpl() {
    auctions = new ConcurrentHashMap<Integer, Auction>();
    bids = new ConcurrentHashMap<Integer, Bid>();
  }

  @PostConstruct
  public void setup() {
    setupAuctions();
    setupBids();
  }

  @Override
  public List<Auction> getAllAuctions() {
    return new ArrayList<Auction>(auctions.values());
  }

  @Override
  public Auction findAuctionById(int auctionId) {
    return auctions.get(auctionId);
  }

  @Override
  public void addAuction(Auction auction) {
    int id = currentAuctionId;
    currentAuctionId++;
    auction.setAuctionId(id);
    auctions.put(id, auction);
  }

  @Override
  public void updateAuction(Auction auction) {
    auctions.put(auction.getAuctionId(), auction);
  }

  @Override
  public boolean bid(int auctionId, float bidAmmount) {
    int id = currentBidId;
    currentBidId++;
    Auction auction = findAuctionById(auctionId);
    Bid bid = new Bid(id, auction, bidAmmount, new Date());
    auction.addBid(bid);
    bids.put(id, bid);
    return true;
  }

  public Map<?, ? extends Object> getAuctions() {
    return auctions;
  }

  public void setupAuctions() {
    addAuction(new Auction()
            .withItemValues("Antique oak phone stand", "The beautiful antique phone stand could also serve as a small hall table. Mission style.", ItemCondition.USED, 2000)
            .withValues(10.49f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("American Girl Doll - Beautiful - Please Look!", "This American Girl doll Just Like Me is in her original box with outfit and in excellent new condition.  She has long wavy blond hair, freckles, brown eyes and is gorgeous.  She was given as a gift, the box was opened only to discover that she is a duplicate gift.  She was never played with and needs a new owner.", ItemCondition.NEW, 2001)
            .withValues(0.99f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("Antique coffee grinder made in pine", "Wake up and smell the coffee with this perfectly functional coffee grinder remeniscent of quieter, more relaxed times.", ItemCondition.USED, 2002)
            .withValues(51.00f, 10.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("Pewter Salt and Pepper Shakers", "Vintage Salt and Pepper shakers in good condition. Some slight scratches", ItemCondition.USED, 2003)
            .withValues(1.00f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("BRAND NEW LIL'KINZ POLAR BEAR!", "Sealed tag and never used code. From a non-smoking, pet-free home.", ItemCondition.NEW, 2004)
            .withValues(9.99f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("North Face Surge Backback", "NEW - we bought this backback for my son and he hated the color!", ItemCondition.NEW, 2005)
            .withValues(9.99f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("Artisan horse sculpture with hand-painted details", "A true conversation starter!", ItemCondition.USED, 2006)
            .withValues(19.99f, 1.00f, AuctionStatus.ACTIVE));
    addAuction(new Auction()
            .withItemValues("HP Printer - not working - parts", "Broken HP printer - may have salvageble parts - sorry no picture available", ItemCondition.PARTS, 0)
            .withValues(9.99f, 1.00f, AuctionStatus.ACTIVE));
  }

  public void setupBids() {
    bid(100, 20.99f);
    bid(100, 34.99f);
    bid(100, 50.99f);
  }

  public Map<?, ? extends Object> getBids() {
    return bids;
  }
}
