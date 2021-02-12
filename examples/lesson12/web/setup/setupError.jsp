<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <template:head title="SETUP ERROR"/>
</head>
<body>
  <h1>Setup Error!</h1>
  <p>There was a problem trying to set up the database.</p>
  <p>Try removing the database and creating it again.</p>
  <c:url var="homeUrl" value="/"/>
  <h1><a href="${homeUrl}">Go home</a></h1>
  <p>Error detail:</p>
  <p>${error.class.name} : ${error.message}</p>
  <pre>${stackTrace}</pre>
</body>
</html>
