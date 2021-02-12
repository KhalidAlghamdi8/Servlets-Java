<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="com.examples.lesson08.i18n.shopList" var="messages"/>

<h4><fmt:message bundle="${messages}" key="madeWith"/></h4>

<fmt:message var="title" bundle="${messages}" key="title"/>
<jsp:include page="templateHeader.jsp">
  <jsp:param name="title" value="${title}"/>
</jsp:include>
<table>
  <thead>
    <tr>
      <th><fmt:message bundle="${messages}" key="item"/></th>
      <th><fmt:message bundle="${messages}" key="quantity"/></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${sessionScope.shopList.items}" var="item" varStatus="status">
      <c:set var="itemCount" value="${itemCount + item.count}"/>
      <tr>
        <td>${item.name}</td>
        <td>${item.count}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<fmt:message bundle="${messages}" key="count">
  <fmt:param value="${itemCount}"/>
</fmt:message>
<br>
<jsp:useBean id="now" class="java.util.Date" />
<c:import url="templateFooter.jsp">
  <c:param name="footerNote">
    <fmt:message bundle="${messages}" key="today">
      <fmt:param>
        <fmt:formatDate value="${now}"/>
      </fmt:param>
    </fmt:message>
  </c:param>
</c:import>