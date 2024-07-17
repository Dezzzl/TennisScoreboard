<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 17.07.2024
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<h1>Добро пожаловать на сайт матчей</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/new-match">Новый матч</a></li>
    <li><a href="${pageContext.request.contextPath}/completedMatches">Список завершенных матчей</a></li>
</ul>
</body>
</html>
