<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/desktop/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Auction List</title>
  </head>
  <body>
    <h1>Auctions</h1>
    <jsp:include page="options.jsp"/>
    <table>
      <thead>
        <tr>
          <td>&nbsp;</td>
          <td>Auction Name</td>
          <td>Current bid</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="auction" items="${allAuctions}">
          <tr>
            <td>
              <c:url var="arrow" value="/images/arrow.gif"/>
              <img src="${arrow}"/>
            </td>
            <td>
              <c:url value="/DetailServlet" var="detailServletUrl">
<c:param name="id" value="${auction.auctionId}"/>
              </c:url>
              <a href="${detailServletUrl}">${auction.title}</a>
            </td>
            <td style="text-align: right">
              $<fmt:formatNumber value="${auction.currPrice}" pattern="#.##"/>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>

