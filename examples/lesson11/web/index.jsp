<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/templates/head.jsp">
      <jsp:param name="title" value="Lesson 11"/>
    </jsp:include>
  </head>
  <body>
    <jsp:include page="/templates/header.jsp">
      <jsp:param name="title" value="Lesson 11 - Security"/>
    </jsp:include>
    <jsp:include page="examples.jsp"/>
    <jsp:include page="/templates/footer.jsp"/>
  </body>
</html>
