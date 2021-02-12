<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="simpletags" uri="examples/lesson08/tlds/simpleTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/res/styles.css" var="stylesUrl"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${stylesUrl}" type="text/css"> 
    <title>Simple tags!</title>
  </head>
  <body>
    <simpletags:HeaderSimpleTag title="SIMPLE TAGS ARE GREAT!"/>
    This is a simple tag test!
    <simpletags:FooterSimpleTag>
      Iteration = ${iteration}
    </simpletags:FooterSimpleTag>
    <p>
      <a href="./">Go back</a>
    </p>
  </body>
</html>
