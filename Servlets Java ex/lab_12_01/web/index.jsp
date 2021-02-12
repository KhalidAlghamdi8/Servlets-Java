<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Auctions</title>
  </head>
  <body>
    <jsp:include page="/templates/header.jsp"/>
    <h1>Welcome to the Auction application</h1>

    <h2 style="text-align: center"><c:url var="listAuctionUrl" value="/ListServlet"/><a href="${listAuctionUrl}">View Auction List</a></h2>
    <h2 style="text-align: center"><c:url var="createAuctionUrl" value="/createAuction.jsp"/><a href="${createAuctionUrl}">Create Auction</a></h2>
    <h2 style="text-align: center"><c:url var="setupUrl" value="/setup.jsp"/><a href="${setupUrl}">Create Default Data</a></h2>


    This project requires a database.

    <div style="border: 1px gray solid;">
      <h3>Create Database.</h3>
      <ul>
        <li>Open the services tab.</li>
        <li>Open the databases node.</li>
        <li>Right-click the Java DB node and select <b>Start Server</b></li>
        <li>Right-click the Java DB node and select <b>Create Database...</b></li>
        <li>Set the following values:
          <ul>
            <li><b>Database Name: </b>AuctionDB</li>
            <li><b>User Name: </b>oracle</li>
            <li><b>Password: </b>welcome1</li>
          </ul>
        </li>
        <li>Click OK to create the database.</li>
        <li>Open the Java DB node and Right-click AuctionDB, select Connect.</li>
        <li>A new node jdbc:derby://localhost:1527/AuctionDB will be created.</li>
        <li>Right click the newly created node and select Execute Command...</li>
        <li>Copy the following script and run it by clicking the Run SQL button (Ctrl+Shift+E)</li>
        <pre style="border: solid 1px black;">
DROP TABLE Bid;
DROP TABLE Auction;
DROP TABLE Image;

CREATE TABLE Image (
                ImageID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                Content BLOB NOT NULL,
                ContentType VARCHAR(50) NOT NULL,
                PRIMARY KEY (ImageID)
);

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
        </pre>
      </ul>
    </div>

  </body>
</html>
