<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/templates/head.jsp">
      <jsp:param name="title" value="Login"/>
    </jsp:include>
  </head>
  <body>
    <h1>= Login =</h1>
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
  <c:url value="/" var="URLHome"/>
  <a href="${URLHome}">Home</a>

</body>
</html>
