<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="" var="desktopModeUrl">
  <c:param name="siteMode" value="desktop"/>
  <c:if test="${not empty param.id}">
    <c:param name="id" value="${param.id}"/>
  </c:if>
</c:url>
<h4>
  Mobile version
  | | | 
  <a href="${desktopModeUrl}">Desktop</a>
</h4></p>