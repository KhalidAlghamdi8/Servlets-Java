<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <template:head title="Scores"/>
  </head>
  <body>
    <template:header title="Scores"/>
    <c:forEach var="quizResult" items="${quizResults}">
      <h4>${quizResult.name} by: ${quizResult.user}</h4>
      <table>
        <tr>
          <c:forEach var="result" items="${quizResult.askedQuestions}">
            <c:set var="color" value="#FF3333"/>
            <c:if test="${result.correct}">
              <c:set var="color" value="#33FF33"/>
            </c:if>
            <td style="background-color: ${color}">${result.questionId}</td>
          </c:forEach>
        </tr>
      </table>
    </c:forEach>
    <template:footer/>
  </body>
</html>
