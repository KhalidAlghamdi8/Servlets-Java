<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
    <title>Oops! 404 error</title>
  </head>
  <body>
    <h1>The server couldn't find the resource you just requested, sorry :(</h1>
    <c:url value="/index.jsp" var="home"/>
    <a href="${home}">Go Home</a>
  </body>
</html>
