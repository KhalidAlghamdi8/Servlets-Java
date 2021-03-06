# Auction Application Database
# Create as AuctionDB
# User name: oracle
# Password: welcome1
#

# Drop existing tables and Constraints
#

DROP TABLE Bid;
DROP TABLE Auction;
DROP TABLE Image;



# Image holds one or more photos for an item
# Note that ImageID is always autogenerated

CREATE TABLE Image (
                ImageID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                Content BLOB NOT NULL,
                ContentType VARCHAR(50) NOT NULL,
                PRIMARY KEY (ImageID)
);


# Auction is the time-based sale of an item
# Status: 1 = Active, 2 = Completed, 3 = Cancelled
# FK: SellerID, ItemID

CREATE TABLE Auction (
                AuctionID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                ImageID INTEGER NOT NULL,
                Title VARCHAR(60),
                Description VARCHAR(1000),
                Seller VARCHAR(20) NOT NULL,
                HighestBidder VARCHAR(20) NOT NULL,
                CurrPrice REAL NOT NULL,
                Increment REAL NOT NULL,
                Status VARCHAR(15) NOT NULL,
                ItemCondition VARCHAR(15) NOT NULL,
                Version INTEGER NOT NULL,
                PRIMARY KEY (AuctionID)
);



CREATE TABLE Bid (
                BidID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                Bidder VARCHAR(40) NOT NULL,
                AuctionID INTEGER NOT NULL,
                Amount REAL NOT NULL,
                BidTime TIMESTAMP NOT NULL,
                PRIMARY KEY (BidID)
);
