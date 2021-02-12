<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles.css" type="text/css"> 
    <title>Auction Room ##</title>
  </head>
  <body>
    <h1>Welcome to the Room ##</h1>
    <p>Currently auctioning</p>
    <h2>AUCTION_NAME</h2>
    <p>AUCTION_DESCRIPTION</p>
    <table>
      <tr>
        <td>Current Bid:</td>
        <td>AUCTION_CURRENTBID</td>
      </tr>
      <tr>
        <td>Next Bid</td>
        <td>AUCTION_INCREMENT</td>
      </tr>
    </table>
    IF_AUCTION_IS_ACTIVE_PRINT:
    <form>
      <input type="submit" value="BID!">
    </form>
    END_IF
    <br>
    <a href="AuctionRoomsServlet">back</a>
  </body>
</html>
