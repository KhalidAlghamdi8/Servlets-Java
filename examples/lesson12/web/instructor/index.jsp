<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <template:head title="Instructor Tools"/>
  </head>
  <body>
    <template:header title="Instructor Tools"/>
    <c:url var="allScoresURL" value="/instructor/allScores"/>
    <h1><a href="${allScoresURL}">View All Scores</a></h1>
    <c:url var="statsURL" value="/instructor/stats"/>
    <h1><a href="${statsURL}">View Question Statistics</a></h1>
    <template:footer/>
  </body>
</html>
