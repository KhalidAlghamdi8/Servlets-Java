<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Lesson 09</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
    <script src="res/jquery.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>Lesson 09 - Servlet Filters - Example</h1>
    <h2>Filters to add data to request.</h2>
    <p>In this example you will add data to the request for the filtered resources.</p>
    <p>In this example all the pages display the current time, date and server name.</p>
    <table>
      <thead>
        <tr>
          <th>Example</th>
          <th>Source code</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td rowspan="7">
            <ul>
              <li><a href="page_one.jsp">/page_one.jsp</a></li>
              <li><a href="page_two.jsp">/page_two.jsp</a></li>
              <li><a href="page_three.jsp">/page_three.jsp</a></li>
            </ul>
          </td>
          <td><a href="sources/page_header.jsp.html">/page_header.jsp</a></td>
        </tr>
        <tr>
          <td><a href="sources/page_footer.jsp.html">/page_footer.jsp</a></td>
        </tr>
        <tr>
          <td><a href="sources/page_one.jsp.html">/page_one.jsp</a></td>
        </tr>
        <tr>
          <td><a href="sources/page_two.jsp.html">/page_two.jsp</a></td>
        </tr>
        <tr>
          <td><a href="sources/page_three.jsp.html">/page_three.jsp</a></td>
        </tr>
        <tr>
          <td><a href="sources/RequestDataFilter.java.html">com.examples.lesson09.filters.RequestDataFilter</a></td>
        </tr>
        <tr>
          <td><a href="sources/filter.web.xml.html">Alternative web.xml configuration</a></td>
        </tr>
      </tbody>
    </table>
    <p>Use this type of filters when you need information for each request that needs to be calculated but you can't use the servlet context.<br>
      You may combine it with JSP templating to avoid duplicated code.</p>
    <h2>Filters to restrict access.</h2>
    <table>
      <thead>
        <tr>
          <th>Example</th>
          <th>Source code</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td rowspan="7">
            <ul>
              <li><a href="page_header.jsp">/page_header.jsp</a></li>
              <li><a href="page_footer.jsp">/page_footer.jsp</a></li>
              <li><a href="accessDenied.jsp">/accessDenied.jsp</a></li>
            </ul>
          </td>
          <td><a href="sources/AccessFilter.java.html">com.examples.lesson09.filters.AccessFilter</a></td>
        </tr>
        <tr>
          <td><a href="sources/accessDenied.jsp.html">/accessDenied.jsp</a></td>
        </tr>
      </tbody>
    </table>

    <h2>Filters to wrap request/response</h2>
    <table>
      <thead>
        <tr>
          <th>Example</th>
          <th>Source code</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td rowspan="3">
            <ul>
              <li><a href="FilteredServlet">/FilteredServlet</a></li>
            </ul>
          </td>
          <td><a href="sources/WrappingFilter.java.html">com.examples.lesson09.filters.WrappingFilter</a></td>
        </tr>
        <tr>
          <td><a href="sources/FilteredServlet.java.html">com.examples.lesson09.servlets.FilteredServlet</a></td>
        </tr>
        <tr>
          <td><a href="sources/filteredServletView.jsp.html">/filteredServletView.jsp</a></td>
        </tr>
      </tbody>
    </table>


    <h1>Lesson 09 - Quizes</h1>
    <jsp:include page="quiz/quizzes.jsp"/>
  </body>
</html>
