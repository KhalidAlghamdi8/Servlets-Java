<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"/>
    <title>Hello JSP tags</title>
  </head>
  <body>
    <jsp:useBean scope="request" id="nameBean" class="com.examples.lesson07.bean.NameBean"/>
    <jsp:setProperty name="nameBean" param="name" property="name"/>
    <h1>
      Hello 
      <jsp:getProperty name="nameBean" property="name"/>
    </h1>
    <a href="index.html">Go home</a>
  </body>
</html>