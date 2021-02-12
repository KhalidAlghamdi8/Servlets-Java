<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <template:head title="Administration"/>
  </head>
  <body>
    <template:header title="Administration"/>
    <c:url var="quizViewURL" value="/admin/fullview"/>
    <h1><a href="${quizViewURL}">View Quizzes</a></h1>
    <template:footer/>
  </body>
</html>
