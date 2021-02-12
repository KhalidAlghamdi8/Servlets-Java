<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <template:head title="SETUP"/>
  </head>
  <body>
    <h1>Setup Required!</h1>
    <p>The database for this project is not configured correctly.</p>
    <p>The application can create the database tables necessary to run the application but
      first you must create the database using NetBeans.</p>
    <div style="boder: 1px gray solid;">
      <h3>Create Database.</h3>
      <ul>
        <li>Open the services tab.</li>
        <li>Open the databases node.</li>
        <li>Right-click the Java DB node and select <b>Start Server</b></li>
        <li>Right-click the Java DB node and select <b>Create Database...</b></li>
        <li>Set the following values:
          <ul>
            <li><b>Database Name: </b>QuizDB</li>
            <li><b>User Name: </b>oracle</li>
            <li><b>Password: </b>welcome1</li>
          </ul>
        </li>
      </ul>
    </div>
  </body>
</html>
