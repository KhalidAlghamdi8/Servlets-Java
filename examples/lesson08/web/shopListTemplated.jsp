<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="templateHeader.jsp">
  <jsp:param name="title" value="Shop List using templates"/>
</jsp:include>

<table>
  <thead>
    <tr>
      <th>Item</th>
      <th>Qty</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${sessionScope.shopList.items}" var="item" varStatus="status">
      <c:choose>
        <c:when test="${item.category eq 'food'}">
          <c:set var="rowColor" value="${((status.count mod 2) eq 0)?'#f0ebb8':'#ded890'}"/>
        </c:when>
        <c:when test="${item.category eq 'electronics'}">
          <c:set var="rowColor" value="${((status.count mod 2) eq 0)?'#b7c0e8':'#9093de'}"/>
        </c:when>
        <c:when test="${item.category eq 'cleaning'}">
          <c:set var="rowColor" value="${((status.count mod 2) eq 0)?'#b7e8b9':'#90de93'}"/>
        </c:when>
        <c:otherwise>
          <c:set var="rowColor" value="${((status.count mod 2) eq 0)?'#ffffff':'#f0f0f0'}"/>
        </c:otherwise>
      </c:choose>
      <tr style="background-color: ${rowColor}">
        <td style="background-color: ${rowColor}">${item.name}</td>
        <td style="background-color: ${rowColor}">${item.count}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<c:import url="templateFooter.jsp">
  <c:param name="footerNote" value="Made with JSP"/>
</c:import>