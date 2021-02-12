<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/templates/head.jsp">
      <jsp:param name="title" value="Error"/>
    </jsp:include>
  </head>
  <body>
    <h1>The application had a problem!</h1>
    <c:url value="/index.jsp" var="URLHome"/>
    <h4><a href="${URLHome}">Go back</a></h4>
    <p>${pageContext.errorData.throwable}</p>
  </body>
</html>
