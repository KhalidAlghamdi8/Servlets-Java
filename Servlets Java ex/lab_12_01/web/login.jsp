<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesURL"/>
    <link rel="stylesheet" href="${stylesURL}" type="text/css"> 
    <title>Login</title>
  </head>
  <h1>= Login =</h1>
  <body>
    <jsp:include page="/templates/header.jsp"/>
    <form action="j_security_check" method="POST">
      User:
      <input type="text" name="j_username">
      Password:
      <input type="password" name="j_password">
      <input type="submit" value="login">
    </form>
    <c:url var="indexUrl" value="/"/><a href="${indexUrl}">Go Home</a><br>
  </body>
</html>
