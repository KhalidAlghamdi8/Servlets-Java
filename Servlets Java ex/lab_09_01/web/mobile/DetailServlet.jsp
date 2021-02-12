<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/mobile/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>${auction.title}</title>
  </head>
  <body>
    <h1>${auction.title}</h1>
    <jsp:include page="options.jsp"/>

    <p>${auction.description}</p>

    <ul>
      <li><b>Condition:</b> ${auction.condition}</li>
      <li><b>Status:</b> ${auction.status}</li>
      <li><b>Current Price:</b> $<fmt:formatNumber value="${auction.currPrice}" pattern="#.##"/></li>
      <li><b>Next bid:</b> $<fmt:formatNumber value="${auction.currPrice + auction.increment}" pattern="#.##"/></li>
    </ul>

    <c:url value="/ListServlet" var="listURL"/>
    <a href="${listURL}">Back to auction list</a>
  </body>
</html>
