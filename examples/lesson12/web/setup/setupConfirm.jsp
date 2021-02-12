<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <template:head title="SETUP"/>
  </head>
  <body>
    <h1>Setup Required!</h1>
    <p>Confirm you want to run the database setup.</p>
    <p>
      <b>All data in the database "QuizDB" will be deleted and replaced
        by the default data.</b>
    </p>
    <c:url var="setupURL" value="/Setup">
      <c:param name="action" value="setup-confirm"/>
    </c:url>
    <c:url var="skipURL" value="/Setup">
      <c:param name="action" value="skip"/>
    </c:url>
    <h1 style="text-align: center;"><a href="${setupURL}">CONFIRM RUN SETUP</a></h1>
    <h1 style="text-align: center;"><a href="${skipURL}">SKIP SETUP</a></h1>
  </body>
</html>
