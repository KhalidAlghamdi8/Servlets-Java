<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Security.</h2>
<p>Users and roles are defined in a security realm. A security realm can be
  a database, a file, a custom mechanism or server specific.</p>
<p>You can follow the <a href="setup.html">setup instructions</a> to create users 
  and roles for this application.</p>
<br>
<p>Start the examples (login) by selecting the links in the header or the following:</p>
<table>
  <thead>
    <tr>
      <th>Example Link</th>
      <th>Required Role</th>
      <th>Source</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <c:url value="/quiz/list" var="URLQuiz"/>
        <a href="${URLQuiz}">Quizzes</a>
      </td>
      <td>quizUser</td>
      <td rowspan="4">
        <ul>
          <li>
            <a href="sources/web.xml.html">/WEB-INF/web.xml</a><br>
            Web XML-based configuration. Focus on security-constraint and security-role elements.
          </li>
          <li>
            <a href="sources/weblogic.xml.html">weblogic.xml</a><br>
            WebLogic mapping of principals to roles.
          </li>
        </ul>
      </td>
      <td>A link to the /quiz/list resource.</td>
    </tr>
    <tr>
      <td>
        <c:url value="/instructor/" var="URLPublish"/>
        <a href="${URLPublish}">Instructor tools</a>
      </td>
      <td>quizInstructor</td>
      <td>A link to the /instructor/ resource.</td>
    </tr>
    <tr>
      <td>
        <c:url value="/admin/" var="URLAdmin"/>
        <a href="${URLAdmin}">Administration</a>
      </td>
      <td>quizAdmin</td>
      <td>A link to the /admin/ resource.</td>
    </tr>
    <tr>
      <td>
        <c:url value="/templates/footer.jsp" var="URLFooter"/>
        <a href="${URLFooter}">/templates/footer.jsp</a>
      </td>
      <td>Access Denied for all.</td>
      <td>A link to the /templates/footer.jsp resource. Should not be accessible directly.</td>
    </tr>
    <tr>
      <td colspan="4">Security annotations</td>
    </tr>
    <tr>
      <td><a href="SecuredServlet">/SecuredServlet</a></td>
      <td>quizUser</td>
      <td><a href="sources/SecuredServlet.java.html">com.examples.lesson11.servlets. SecuredServlet</a></td>
      <td>Servlet security annotation configuration.</td>
    </tr>
    <tr>
      <td colspan="4">Programatic security</td>
    </tr>
    <tr>
      <td><a href="SecuredMethodServlet">/SecuredMethodServlet</a></td>
      <td>ANY</td>
      <td><a href="sources/SecuredMethodServlet.java.html">com.examples.lesson11.servlets. SecuredMethodServlet</a></td>
      <td>Programmatic security checks. Changes output depending on role of the user.</td>
    </tr>
  </tbody>
</table>

<h2>Source code</h2>
<h3>Web Application Authentication</h3>
<p>To trigger login you have to go to a secured resource.<br>
  Here is the source code of the web pages used for authentication.</p>
<table>
  <tr>
    <td><a href="sources/login.jsp.html">/login.jsp</a></td>
    <td>Login page.</td>
  </tr>
  <tr>
    <td><a href="sources/loginError.jsp.html">/loginError.jsp</a></td>
    <td>Error page if the user credentials are not correct.</td>
  </tr>
  <tr>
    <td><a href="sources/accessDenied.jsp.html">/errors/accessDenied.jsp</a></td>
    <td>Page to be displayed if the authenticated user does not have access</td>
  </tr>
  <tr>
    <td><a href="sources/LogoutServlet.java.html">com.examples.lesson11.servlets.LogoutServlet</a></td>
    <td>The servlet that handles the logout operation.</td>
  </tr>
  <tr>
    <td><a href="sources/web.xml.html">/WEB-INF/web.xml</a></td>
    <td>Web XML login configuration. Focus on the login-config and error-page elements.</td>
  </tr>

</table>

<h3>Extras</h3>
<p>This example uses custom tags and filters with programmatic security to display
  the header of the page.</p>
<p>The page header is constructed based on the role for the user.<br>
  A filter sets the username and roles inside the request for the header to display.<br>
  A custom tag is developed to add a condition to display the contents of the tag based on the
  role the user has.<br>
</p>
<table>
  <tr>
    <td><a href="sources/header.jsp.html">/templates/header.jsp</a></td>
    <td>The header file</td>
  </tr>
  <tr>
    <td><a href="sources/RolesFilter.java.html">com.examples.lesson11.filters.RolesFilter</a></td>
    <td>The filter that adds the user name and roles to the request (for JSP)</td>
  </tr>
  <tr>
    <td><a href="sources/securityTags.tld.html">/WEB-INF/tlds/securityTags.tld</a></td>
    <td>The custom tag class file for the role conditional tag.</td>
  </tr>
  <tr>
    <td><a href="sources/IfInRole.java.html">com.examples.lesson11.tags.IfInRole</a></td>
    <td>The custom tag class file for the role conditional tag.</td>
  </tr>
</table>
