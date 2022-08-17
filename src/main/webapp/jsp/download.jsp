
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.classes.Database" %>
<%@ page import="com.company.servlets.DownloadServlet" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>Title</title>
  <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
  <div class="form-style-2-heading">
    База данных не была изменена. Загрузить еще раз?
  </div>
  <form method="get" action="<c:url value="/download"/>">
    <input type="submit" value="Yes"/>
  </form>
  <form method="get" action="<c:url value="/home"/>">
    <input type="submit" value="No"/>
  </form>
</div>

</body>
</html>

