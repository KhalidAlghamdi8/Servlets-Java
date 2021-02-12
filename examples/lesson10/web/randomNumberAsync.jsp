<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Numbers</title>
  </head>
  <body onload="getNumber()">
    <c:url value="/RandomNumberServlet" var="asyncUrl">
      <c:param name="t" value="t"/>
    </c:url>
    <script type="text/javascript">
      var requestPending = false;
      function getNumber(){
        if(!requestPending){
          requestPending=true;
          var xmlhttp = initRequest();
          var url = "${asyncUrl}&var="+new Date().getTime();
          xmlhttp.open("GET", url, true);
          xmlhttp.onreadystatechange=function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
              var element = document.getElementById("numberContainer");
              element.innerHTML = xmlhttp.responseText +"<br>" +element.innerHTML;
              requestPending=false;
              setTimeout(getNumber, 100);
            }
          }
          xmlhttp.send();
        }
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

    <h1>Numbers!</h1>
    <div id="numberContainer"></div>
  </body>
</html>
