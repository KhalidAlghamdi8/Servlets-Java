<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag body-content="scriptless" %>
<!DOCTYPE html>
<c:url value="/index.jsp" var="home"/>
<a href="${home}"> Go home </a>
<h4><jsp:doBody/></h4>
</body>
</html>
