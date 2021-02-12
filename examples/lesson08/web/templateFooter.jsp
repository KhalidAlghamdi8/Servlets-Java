<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:url value="/index.jsp" var="home"/>
<a href="${home}"> Go home </a>
<h4>${param.footerNote}</h4>
</body>
</html>
