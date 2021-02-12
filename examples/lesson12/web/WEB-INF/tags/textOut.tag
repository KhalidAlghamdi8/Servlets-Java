<%@tag description="Output the text" pageEncoding="UTF-8" body-content="empty"%>
<%@attribute name="value" required="true" rtexprvalue="true" type="com.examples.lesson12.model.TextContainer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach items="${value.texts}" var="text">
  <c:if test="${text.code}">
    <pre>${fn:escapeXml(text.text)}</pre>
  </c:if>
  <c:if test="${!text.code}">
    <c:forEach items="${text.lines}" var="line">
      ${fn:escapeXml(line)}<br>
    </c:forEach>
  </c:if>
</c:forEach>
