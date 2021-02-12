<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <quiz:head title="Reset Scores" />
  </head>
  <body>
    <quiz:header title="Confirm Reset"/>
    <h2>Are you sure you want to reset your quiz score?</h2>
    <p>You will have to take the quizzes again.</p>
    <c:url value="/quiz/reset" var="URLLink">
      <c:param name="confirm" value="true"/>
    </c:url>
    <ul>
      <li><a href="${URLLink}">YES, reset it.</a></li>
    </ul>
    <quiz:footer/>
  </body>
</html>
