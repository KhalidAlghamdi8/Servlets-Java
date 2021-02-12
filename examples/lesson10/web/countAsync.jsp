<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
    <script src="res/jquery.js" type="text/javascript"></script>
    <title>Asynchronous page</title>
  </head>
  <c:url value="/AsyncServlet" var="asyncUrl">
    <c:param name="t" value="t"/>
  </c:url>
  <body onload="startCount()">
    <script type="text/javascript">
      function startCount(){
        var xmlhttp = initRequest();
        var lastLen = 0;
        var timerId = setInterval(function(){
          var responseText = xmlhttp.responseText;
          if(responseText.length!=lastLen){
            lastLen = responseText.length;
            document.getElementById("countArea").innerHTML = responseText;
          }
        }, 500);
        var url = "${asyncUrl}&var="+new Date().getTime();
        xmlhttp.open("GET", url, true);
        xmlhttp.onreadystatechange=function(){
          if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            clearInterval(timerId);
            document.getElementById("statusArea").innerHTML = "complete";
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
    <c:url value="/index.jsp" var="homeUrl" />
    <a href="${homeUrl}">Go Home</a>
    <h1>Counting to ten...</h1>
    <div id="countArea">
    </div>
    <div id="statusArea">
      Counting...
    </div>
    <a href="${homeUrl}">Go Home</a>
  </body>
</html>
