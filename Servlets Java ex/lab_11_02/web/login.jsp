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
    <h1>= Login =</h1>
    <jsp:include page="/templates/header.jsp"/>

    <form method="POST">
      User:
      <input type="text">
      Password:
      <input type="password">
      <input type="submit" value="login">
    </form>

    <c:url var="homeUrl" value="/index.jsp"/>
    <a href="${homeUrl}">Go back</a>
  </body>
</html>
