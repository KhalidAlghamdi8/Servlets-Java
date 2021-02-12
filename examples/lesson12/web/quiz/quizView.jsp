<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <quiz:head title="${quiz.name}"/>
  </head>
  <body>
    <quiz:header title="QUIZ: ${quiz.name} - Question: ${questionNo} of ${questionTotal}"/>
    <quiz:progressBar value="${quizResult}"/>


    <c:if test="${isSecondTryAttr}">
      <h4>Try again: (select ${question.numberOfCorrectOptions})</h4>
    </c:if>

    <quiz:textOut value="${question}"/>
    <c:url value="/quiz/quiz" var="URLform"/>
    <form action="${URLform}" method="POST">
      <table>
        <c:forEach items="${question.options}" var="answer">
          <tr>
            <td><input type="checkbox" name="answerId" value="${answer.id}"/></td>
            <td>
              <quiz:textOut value="${answer}"/>
            </td>
          </tr>
        </c:forEach>
      </table>
      <input type="submit" value="SUBMIT">
      <input type="hidden" name="action" value="answer"/>
      <input type="hidden" name="questionId" value="${question.id}">
      <input type="hidden" name="quiz" value="${param.quiz}"/>
      <input type="hidden" name="isSecondTry" value="${isSecondTryAttr}"/>
    </form>
    <br>
    <quiz:footer/>
  </body>
</html>
