<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <quiz:head title="QUIZ RESULTS" />
  </head>
  <body>
    <quiz:header title="QUIZ RESULTS!"/>
    <c:if test="${completed == 'true'}">
      <h2>Quiz Completed!</h2>
    </c:if>
    <table>
      <tr>
        <td>Lesson</td>
        <td>Name</td>
        <td>Score</td>
        <td>Progress</td>
      </tr>
      <c:forEach var="quiz" items="${sessionScope.quizResults.list}">
        <tr>
          <td>${quiz.id}</td>
          <td>
            <c:if test="${quiz.complete}">
              ${quiz.name} 
            </c:if>
            <c:if test="${!quiz.complete}">
              <c:url value="/quiz/quiz" var="URLLink">
                <c:param name="quiz" value="${quiz.id}" />
              </c:url>
              <a href="${URLLink}">${quiz.name}</a>
            </c:if>
          </td>
          <td>
            <c:if test="${quiz.quizQuestions > 0}">
              ${quiz.correctPercent}% (${quiz.quizPoints}/${quiz.quizQuestions})
            </c:if>
          </td>
          <td>
            <quiz:progressBar value="${quiz}"/>
          </td>
        </tr>
      </c:forEach>
    </table>
    <quiz:footer />
  </body>
</html>
