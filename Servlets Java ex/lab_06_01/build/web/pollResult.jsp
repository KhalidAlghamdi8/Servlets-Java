<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Poll Results!</h1>
    <ul>
      <c:forEach items="${pollResults}" var="result">
        <li>${result.option}: ${result.votes}</li>
      </c:forEach>
    </ul>
    <a href="index.html">Go home</a>
  </body>
</html>
