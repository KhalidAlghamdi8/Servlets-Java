<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<template:templateHeader title="Shopping list"/>

<table>
  <thead>
    <tr>
      <th>Item</th>
      <th>Quantity</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${sessionScope.shopList.items}" var="item" varStatus="status">
      <tr>
        <td>${item.name}</td>
        <td>${item.count}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<template:templateFooter>
  Using JSP tag files!
</template:templateFooter>