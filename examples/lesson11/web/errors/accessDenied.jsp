<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/templates/head.jsp">
      <jsp:param name="title" value="Access denied!"/>
    </jsp:include>
  </head>
  <body>
    <h1>Access denied!.</h1>
    <p>You cannot access the requested resource.</p>
    <c:url value="/index.jsp" var="URLHome"/>
    <a href="${URLHome}">Go home</a>
  </body>
</html>
