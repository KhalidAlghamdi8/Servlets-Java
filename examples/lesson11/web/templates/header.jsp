<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="examples/lesson11/tlds/securityTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- This is set by a filter!. -->
<c:if test="${not empty requestScope.userName}">
  <table>
    <tr>
      <td>User:</td>
      <td><b>${requestScope.userName}</b> &nbsp;&nbsp;</td>
      <td>Roles:</td>
      <td><b>${requestScope.userRoles}</b>&nbsp;&nbsp;</td>
      <td>
        <c:url value="/LogoutServlet" var="URLLogout"/>
        <a href="${URLLogout}">LOGOUT</a>
      </td>
    </tr>
  </table>
</c:if>
<c:if test="${empty requestScope.userName}">
  <table>
    <tr>
      <td>
        <c:url value="/quiz/list" var="URLQuiz"/>
        <a href="${URLQuiz}">Quizzes</a>
      </td>
      <td>
        <c:url value="/instructor/" var="URLPublish"/>
        <a href="${URLPublish}">Instructor Tools</a>
      </td>
      <td>
        <c:url value="/admin/" var="URLAdmin"/>
        <a href="${URLAdmin}">Administration</a>
      </td>
    </tr>
  </table>
</c:if>
<sec:IfInRole role="quizUser">
  <jsp:include page="/quiz/options.jsp"/>
  <jsp:include page="/quiz/quizzes.jsp"/>
</sec:IfInRole>
<sec:IfInRole role="quizAdmin">
  <table>
    <tr>
      <td>
        <c:url value="/" var="URLHome"/>
        <a href="${URLHome}">Home</a>
      </td>
      <td>
        <c:url value="/admin/" var="URLAdmin"/>
        <a href="${URLAdmin}">Administration</a>
      </td>
    </tr>
  </table>
</sec:IfInRole>
<sec:IfInRole role="quizInstructor">
  <table>
    <tr>
      <td>
        <c:url value="/" var="URLHome"/>
        <a href="${URLHome}">Home</a>
      </td>
      <td>
        <c:url value="/instructor/" var="URLPublish"/>
        <a href="${URLPublish}">Instructor Tools</a> |
      </td>
    </tr>
  </table>
</sec:IfInRole>
<h1>${param.title}</h1>