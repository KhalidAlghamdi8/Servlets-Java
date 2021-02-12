<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/desktop/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>${auction.title}</title>
  </head>
  <body>
    <h1>${auction.title}</h1>
    <jsp:include page="options.jsp"/>
    <c:url value="/images/auction.jpg" var="auctionImageUrl"/>
    <img src="${auctionImageUrl}" style="float: left"/>

    <p>${auction.description}</p>

    <table>
      <tr>
        <td>Condition:</td>
        <td>${auction.condition}</td>
      </tr>
      <tr>
        <td>Status:</td>
        <td>${auction.status}</td>
      </tr>
    </table>
    <br>
    <table>
      <thead>
        <tr>
          <th>Current Price:</th>
          <th>Next bid:</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>$<fmt:formatNumber value="${auction.currPrice}" pattern="#.##"/></td>
          <td>$<fmt:formatNumber value="${auction.currPrice + auction.increment}" pattern="#.##"/></td>
        </tr>
      </tbody>
    </table>

    <c:url value="/ListServlet" var="listURL"/>
    <a href="${listURL}">Back to auction list</a>
  </body>
</html>
