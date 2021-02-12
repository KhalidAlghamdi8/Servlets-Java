<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auction home</title>
  </head>
  <body>
    <c:url value="/ListServlet" var="listSvltUrl"/>
    <a href="${listSvltUrl}">Go to auction list</a>
  </body>
</html>
