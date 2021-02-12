<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<!DOCTYPE html>
<c:url value="/res/styles.css" var="stylesUrl"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${stylesUrl}" type="text/css"> 
    <title>${title}</title>
  </head>
  <body>
  <h1>${title}</h1>