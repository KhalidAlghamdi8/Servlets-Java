<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>System information</title>
    <link rel="stylesheet" href="res/styles.css" type="text/css"> 
  </head>
  <body>
    <h1>System Information</h1>
    <p>JSP view</p>
    <ul>
      <li>Server Name: ${infoBean.serverName}</li>
      <li>Server Memory: ${infoBean.serverMemory}</li>
      <li>Server Free Memory ${infoBean.serverFreeMemory}</li>
      <li>Server Cores: ${infoBean.serverCores}</li>
      <li>Server Time: ${infoBean.serverTime}</li>
    </ul>
    <a href="index.html">Go Home</a>
  </body>
</html>
