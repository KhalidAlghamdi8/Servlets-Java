<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="classictags" uri="examples/lesson08/tlds/classicTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/res/styles.css" var="stylesUrl"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${stylesUrl}" type="text/css"> 
    <title>Clasic tags :(</title>
  </head>
  <body>
    This is a classic tag test!
    <classictags:ClassicTag title="HELLO">
      Iteration = ${iteration}
    </classictags:ClassicTag>
    <p>
      <a href="./">Go back</a>
    </p>
  </body>
</html>
