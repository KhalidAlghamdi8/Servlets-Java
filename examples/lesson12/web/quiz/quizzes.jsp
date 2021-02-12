<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>
<table>
  <thead>
    <tr>
      <th>Quiz Name</th>
      <th>Score</th>
      <th>Complete?</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="quiz" items="${sessionScope.quizResults.list}">
      <tr>
        <td>
          <c:if test="${!quiz.complete}">
            <c:url value="/quiz/quiz" var="URLLink">
              <c:param name="quiz" value="${quiz.id}"/>
            </c:url>
            <a href="${URLLink}">${quiz.name}</a>
          </c:if>
          <c:if test="${quiz.complete}">
            ${quiz.name}
          </c:if>
        </td>
        <td>${quiz.quizPoints}/${quiz.quizQuestions}</td>
        <td>
          <c:if test="${quiz.complete}">
            COMPLETE
          </c:if>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
