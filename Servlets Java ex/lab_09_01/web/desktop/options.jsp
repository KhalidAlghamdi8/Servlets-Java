<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="" var="mobileModeUrl">
  <c:param name="siteMode" value="mobile"/>
  <c:if test="${not empty param.id}">
    <c:param name="id" value="${param.id}"/>
  </c:if>
</c:url>
<h4>
  Desktop version
  | | | 
  <a href="${mobileModeUrl}">Mobile</a>
</h4>
</p>