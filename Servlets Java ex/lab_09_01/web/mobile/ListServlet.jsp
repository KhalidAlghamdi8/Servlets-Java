<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/mobile/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Auction List</title>
  </head>
  <body>
    <h1>Auctions</h1>
    <jsp:include page="options.jsp"/>
    <ul>
      <c:forEach var="auction" items="${allAuctions}">
        <li>
          <c:url value="/DetailServlet" var="detailServletUrl">
            <c:param name="id" value="${auction.auctionId}"/>
          </c:url>
          <a href="${detailServletUrl}">${auction.title}</a>
        </li>
      </c:forEach>
    </ul>
  </body>
</html>
