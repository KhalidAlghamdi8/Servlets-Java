<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/templates/head.jsp">
      <jsp:param name="title" value="Login"/>
    </jsp:include>
  </head>
  <body>
    <h1>= Login Error =</h1>
    <c:url value="/" var="URLHome"/>
    <a href="${URLHome}">Home</a>
  </body>
</html>
