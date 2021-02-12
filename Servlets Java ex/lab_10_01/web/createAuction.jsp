<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Create Auction</title>
  </head>
  <body>
    <h1>Create auction</h1>
    <c:url value="/CreateAuctionServlet" var="createURL" />
    <form action="${createURL}" method="post">
      <table>
        <tr>
          <td>Auction title:</td>
          <td><input type="text" name="auctionTitle"></td>
        </tr>
        <tr>
          <td>Description:</td>
          <td><input type="text" name="auctionDescription"></td>
        </tr>

        <tr>
          <td>Image:</td>
          <td>
            Image input?
          </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" value="Create"></td>
        </tr>
      </table>
    </form>

    <c:url value="/ListServlet" var="listURL"/>
    <a href="${listURL}">Back to auction list</a>

  </body>
</html>
