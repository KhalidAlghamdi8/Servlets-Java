<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
    <title>Shopping List</title>
  </head>
  <body>
    <h1>Shopping list: ${sessionScope.shopList.name}!</h1>
    <c:if test="${not empty requestScope.message}">
      <h2>${requestScope.message}</h2>
    </c:if>
    <c:if test="${not empty requestScope['modified-item']}">
      <h4>Item: ${requestScope['modified-item'].name} (${requestScope['modified-item'].count})</h4>
    </c:if>

    <table>
      <thead>
        <tr>
          <th>Item</th>
          <th>Qty</th>
          <th>+</th>
          <th>-</th>
          <th>Delete</th>
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
            <td>
              <form action="ShopListServlet" method="POST">
                <input type="hidden" name="id" value="${item.id}"/>
                <input type="hidden" name="action" value="add"/>
                <input type="submit" value="+"/>
              </form>
            </td>
            <td>
              <form action="ShopListServlet" method="POST">
                <input type="hidden" name="id" value="${item.id}"/>
                <input type="hidden" name="action" value="remove"/>
                <input type="submit" value="-"/>
              </form>
            </td>
            <td>
              <form action="ShopListServlet" method="POST">
                <input type="hidden" name="id" value="${item.id}"/>
                <input type="hidden" name="action" value="delete"/>
                <input type="submit" value="Delete"/>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <form action="ShopListServlet" method="POST">
      <h3>Add item.</h3>
      Item: <input type="text" name="itemName"/>
      <input type="hidden" name="action" value="new"/>
      <select name="itemCategory">
        <option value="food">Food</option>
        <option value="electronics">Electronics</option>
        <option value="cleaning">Cleaning</option>
        <option value="misc">Miscellaneous</option>
      </select>
      <input type="submit" value="Add to list"/>
    </form>

    <c:url value="/index.jsp" var="home"/>

    <a href="${home}">Go back</a>
  </body>
</html>
