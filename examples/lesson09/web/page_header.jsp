<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href="./">Go back</a>
<table>
  <tr>
    <td>Server name:</td>
    <td>${requestScope['server-name']}</td>
    <td>Server date:</td>
    <td>${requestScope['server-date']}</td>
    <td>Server time:</td>
    <td>${requestScope['server-time']}</td>
  </tr>
</table>
