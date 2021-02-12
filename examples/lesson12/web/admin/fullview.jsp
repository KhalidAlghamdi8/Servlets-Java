<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="quiz" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
  <head>
    <quiz:head title="Quizzes" />
  </head>
  <body>
    <quiz:header title="Quizzes" />
    <c:forEach items="${quizzes}" var="quiz">
      <h1>${quiz.name}</h1>
      <c:if test="${quiz.error}">
        <h1 style="color: red;">ERROR</h1>
      </c:if>
      <c:forEach items="${quiz.questions}" var="question">
        <h3>Question: ${quiz.id}.${question.id}</h3>
        <quiz:textOut value="${question}"/>
        <table>
          <c:forEach items="${question.answers}" var="answer">
            <tr>
              <td>
                <c:if test="${answer.correct}"><b>***</b></c:if>
                </td>
                <td>
                <quiz:textOut value="${answer}"/>
              </td>
            </tr>
          </c:forEach>
        </table>
      </c:forEach>
    </c:forEach>
    <quiz:footer />
  </body>
</html>
