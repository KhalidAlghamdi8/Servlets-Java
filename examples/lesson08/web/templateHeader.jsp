<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:url value="/res/styles.css" var="stylesUrl"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${stylesUrl}" type="text/css"> 
    <title>${param.title}</title>
  </head>
  <h1>${param.title}</h1>