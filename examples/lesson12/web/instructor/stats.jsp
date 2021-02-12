<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <template:head title="Statistics"/>
  </head>
  <body>
    <template:header title="Statistics"/>
    <c:forEach var="quizStat" items="${quizStats}">
      <h3>${quizStat.quiz.name}</h3>
      <table>
        <tr>
          <td><b>Question</b></td>
          <c:forEach var="questionStat" items="${quizStat.questions}">
            <td>${questionStat.id}</td>
          </c:forEach>
        </tr>
        <tr>
          <td><b>Corrects</b></td>
          <c:forEach var="questionStat" items="${quizStat.questions}">
            <td>${questionStat.correct}</td>
          </c:forEach>
        </tr>
        <tr>
          <td><b>Incorrects</b></td>
          <c:forEach var="questionStat" items="${quizStat.questions}">
            <td>${questionStat.incorrect}</td>
          </c:forEach>
        </tr>
      </table>
    </c:forEach>

    <template:footer/>
  </body>
</html>
