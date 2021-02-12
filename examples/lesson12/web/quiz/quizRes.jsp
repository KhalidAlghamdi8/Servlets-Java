<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <quiz:head title="QUIZ: ${quiz.name}" />
  </head>
  <body>
    <quiz:header title="QUIZ: ${quiz.name} - Question: ${questionNo} of ${questionTotal}"/>
    <quiz:progressBar value="${quizResult}"/>

    <c:if test="${result == 'true'}">
      <h1>CORRECT!</h1>
    </c:if>
    <c:if test="${result == 'false'}">
      <h1>INCORRECT!</h1>
    </c:if>
    <c:if test="${not quizResult.complete}">
      <h2><a href="quiz?quiz=${quiz.id}">Next question </a></h2>
    </c:if>
    <c:if test="${quizResult.complete}">
      <h2>Quiz Complete!</h2>
      <h3><a href="score">Go to scores</a></h3>
    </c:if>
    <quiz:footer />
  </body>
</html>
