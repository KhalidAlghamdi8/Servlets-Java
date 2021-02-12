<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <template:head title="SETUP COMPLETE"/>
  </head>
  <body>
    <h1>Setup Complete!</h1>
    <c:url var="homeUrl" value="/"/>
    <h1><a href="${homeUrl}">Go home</a></h1>
  </body>
</html>
