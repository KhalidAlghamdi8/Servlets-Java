<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"/>
    <title><%= title%></title>
  </head>
  <%!    //
    private String title;

    public void jspInit() {
      title = getServletConfig().getInitParameter("jsp-name");
    }

    public void jspDestroy() {
      title = null;
    }
  %>
  <body>
    <a href="index.html">Go home</a>
    <h1><%= title%></h1>
    <p>REMEMBRER: JSPs are converted to Servlets. The entire lifecycle is:</p>
    <h2>Translation</h2>
    <p>The JSP is converted into a servlet. Scriptlets are added, html output is converted to
      jspWriter.print statements and custom tag and expression code is added.</p>
    <h2>Compilation</h2>
    <p>The generated servlet is compiled into a java class.</p>
    <h2>Load</h2>
    <p>The generated java class is loaded in the container.</p>
    <h2>Instantiation.</h2>
    <p>As with servlets the container manages the instances of the JSP servlet class.</p>
    <h2>Initialization</h2>
    <p>The JSP servlet class is initialized calling the jspInit() method</p>
    <h2>Service</h2>
    <p>The JSP servlet will call the _jspService() method when the JSP resource is requested.</p>
    <h2>Destruction</h2>
    <p>Similar to the servlet's destroy method this method will be called when the instance of this JSP servlet class will be destroyed.</p>
    <a href="index.html">Go home</a>
  </body>  
</html>
