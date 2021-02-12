<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles.css" type="text/css"> 
    <title>Auctions</title>
  </head>
  <body>
    <h1>Current auctions</h1>
    <!-- ITERATE_AUCTIONS -->
    <h2>AUCTION_TITLE</h2>
    <table>
      <thead>
        <tr>
          <td>Auction Details</td>
          <td>Bids</td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            <p>AUCTION_DESCRIPTION</p>
            <ul>
              <li>Status: AUCTION_STATUS</li>
              <li>Item Condition: AUCTION_CONDITION</li>
            </ul>
          </td>
          <td>
            <!-- IF_AUCTION_BIDS_NOT_EMPTY -->
            <table>
              <thead>
                <tr><th>BIDS</th></tr>
              </thead>
              <tbody>
                <!-- ITERATE_BIDS_ON_AUCTION -->
                <tr>
                  <td>
                    BID_AMOUNT
                  </td>
                </tr>
                <!-- END_ITERATE_BIDS_ON_AUCTION -->
              </tbody>
            </table>
            <!-- END_IF_AUCTION_BIDS_NOT_EMPTY -->
            <!-- IF_AUCTION_BIDS_EMPTY -->
            No bids yet. Be the first to bid!
            <!-- END_IF_AUCTION_BIDS_EMPTY -->
            <ul>
              <li>Current Price: AUCTION_CURRENTPRICE</li>
              <li>Increment: AUCTION_INCREMENT</li>
            </ul>
          </td>
        </tr>
      </tbody>
    </table>
    <!-- END_ITERATE_AUCTIONS -->
  </body>
</html>
