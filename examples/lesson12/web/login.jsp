<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <template:head title="Login"/>
  </head>
  <body>
    <template:header title="= Login =" />
    <form action="j_security_check" method="POST">
      User:
      <input type="text" name="j_username">
      Password:
      <input type="password" name="j_password">
      <input type="submit" value="login">
    </form>

    <table>
      <thead>
        <tr>
          <th>User</th>
          <th>Password</th>
          <th>Groups</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>quizAdministrator</td>
          <td>quiz123123</td>
          <td>quizAdmin</td>
        </tr>
        <tr>
          <td>student</td>
          <td>student123</td>
          <td>quizUser</td>
        </tr>
        <tr>
          <td>instructor</td>
          <td>in123123</td>
          <td>quizInstructor</td>
        </tr>
      </tbody>
    </table>
    <template:footer/>
  </body>
</html>
