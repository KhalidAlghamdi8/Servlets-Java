<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="elfunctions" uri="examples/lesson08/tlds/elFunctions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
    <title>EL Functions</title>
  </head>
  <body>
    current time is: ${elfunctions:now()}<br>
    Formatted nicely:
    <fmt:formatDate value="${elfunctions:now()}"/>
    <br>
    And with a custom time: 
    <fmt:formatDate value="${elfunctions:date(30,11,2012)}"/>
    <p>
      <a href="./">Go back</a>
    </p>
  </body>
</html>
