<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <ul>
      <li>
        <c:url var="listAuctionUrl" value="/ListServlet"/>
        <a href="${listAuctionUrl}">View auction list</a>
      </li>
      <li>
        <c:url var="createAuctionUrl" value="/createAuction.jsp"/>
        <a href="${createAuctionUrl}">Create auction</a>
      </li>
    </ul>
  </body>
</html>
