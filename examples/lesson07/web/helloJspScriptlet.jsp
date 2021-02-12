<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! private static final String DEFAULT_NAME = "world";%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"/>
    <title>helloJspScriptlet</title>
  </head>
  <body>
    <%
      String name = request.getParameter("name");
      if (name == null) {
        name = DEFAULT_NAME;
      }
    %>
    <h1>Hello <%=name%>!</h1>
    <a href="index.html">Go home</a>
  </body>
</html>
