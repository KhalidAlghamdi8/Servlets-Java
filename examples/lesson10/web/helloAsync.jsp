<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello Async!</title>
  </head>
  <body onload="startHello()">
    <script type="text/javascript">
      function startHello(){
        var xmlhttp = initRequest();
        var url = "HelloAsyncServlet?var="+new Date().getTime();
        xmlhttp.open("GET", url, true);
        xmlhttp.onreadystatechange=function(){
          if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            document.getElementById("asyncText").innerHTML = xmlhttp.responseText;
          }
        }
        xmlhttp.send();
      }
      
      function initRequest() {
        if (window.XMLHttpRequest) {
          if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
          }
          return new XMLHttpRequest();
        } else if (window.ActiveXObject) {
          isIE = true;
          return new ActiveXObject("Microsoft.XMLHTTP");
        }
      }
    </script>
    <h1>Hello <span id="asyncText"></span>!</h1>
    <c:url value="/index.jsp" var="homeUrl" />
    <a href="${homeUrl}">Go Home</a>
  </body>
</html>
