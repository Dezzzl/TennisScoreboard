<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 17.07.2024
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Match</title>
</head>
<body>
    <form action="/new-match" method="post">
        <label for="player1">Имя игрока 1
            <input type="text" name="player1" id="player1" >
        </label>
        <label for="player2">Имя игрока 2
            <input type="text" name="player2" id="player2" >
        </label>
        <button type="submit">Начать матч</button>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                    <br>
                </c:forEach>
            </div>
        </c:if>
    </form>
</body>
</html>
