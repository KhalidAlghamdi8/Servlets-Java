<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"/>
    <title>JSP Page</title>
  </head>
  <body>
    <c:set var="name" value="world" />
    <c:if test="${not empty param.name}">
      <c:set var="name" value="${param.name}" />
    </c:if>
    <h1>Hello ${name}!</h1>
    <a href="index.html">Go home</a>
  </body>
</html>
