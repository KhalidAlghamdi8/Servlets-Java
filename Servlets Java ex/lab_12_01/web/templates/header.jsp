<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- This is set by a filter!. -->
<c:if test="${not empty pageContext.request.remoteUser}">
  <div style="text-align: right">
    <c:url value="/LogoutServlet" var="URLLogout"/>
    <a href="${URLLogout}">LOGOUT</a>
  </div>
</c:if>
