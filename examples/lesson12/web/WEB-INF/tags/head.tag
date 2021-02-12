<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag body-content="empty" %> 
<%@attribute name="title" required="true" %>
<c:url value="/res/styles.css" var="URLstyles"/>
<c:url value="/res/jquery.js" var="URLjquery"/>
<c:url value="/res/jquery.tooltip.js" var="URLjquery_tooltip"/>
<c:url value="/res/tooltip.js" var="URLtooltip"/>
<title>${title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${URLstyles}" type="text/css"> 
<script src="${URLjquery}" type="text/javascript"></script>
<script src="${URLjquery_tooltip}" type="text/javascript"></script>
<script src="${URLtooltip}" type="text/javascript"></script>
