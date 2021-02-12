<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:url value="/res/styles.css" var="stylesUrl"/>
    <link rel="stylesheet" href="${stylesUrl}" type="text/css"> 
    <title>EL Functions</title>
  </head>
  <body>
    <c:set var="items" value="${fn:split('Split,This,Items,By,Comma', ',')}"/>
    <ul>
      <c:forEach var="item" items="${items}">
        <li>${item}</li>
      </c:forEach>
    </ul>
    There are ${fn:length(items)} items.<br>
    <c:set var="someString" value="<ESCAPED>"/>
    With functions you can prevent strings injecting tags with fn:escapeXml:
    ${fn:escapeXml(someString)}<br>
    <c:url value="/index.jsp" var="home"/>
    <br><a href="${home}"> Go home </a>
  </body>
</html>
