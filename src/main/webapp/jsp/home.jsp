
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
    <link href="\css\styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Записать пользователя:
    </div>
    <form method="post" action="<c:url value="/sign"/>">
        <label for="name">Имя
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="birthdate">Дата рождения
            <input class="input-field" type="text" id="birthdate" name="birthdate">
        </label>
        <label for="birthplace">Место рождения
            <input class="input-field" type="text" id="birthplace" name="birthplace">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Удалить пользователя:
    </div>
    <form method="post" action="<c:url value="/delete"/>">
        <label for="name">Имя
            <input class="input-field" type="text" id="name_" name="name">
        </label>
        <label for="birthdate">Дата рождения
            <input class="input-field" type="text" id="birthdate_" name="birthdate">
        </label>
        <label for="birthplace">Место рождения
            <input class="input-field" type="text" id="birthplace_" name="birthplace">
        </label>
        <input type="submit" value="Delete">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Получить табицу в Excel:
    </div>
    <form method="get" action="<c:url value="/download"/>">
        <input type="submit" value="Download"/>
    </form>
</div>

</body>
</html>
