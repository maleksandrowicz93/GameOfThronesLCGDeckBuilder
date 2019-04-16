<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaloguj się</title>
</head>
<body>
<form method="post" action="/login">
    <c:if test="${param.error != null}">
        <span>Nieprawidłowe dane logowania!</span>
    </c:if>
    <c:if test="${param.logout != null}">
        <span>Zostałeś wylogowany</span>
    </c:if>
    Nazwa użytkownika: <input type="text" name="username" required min="3" max="20"/><br/>
    Hasło: <input type="password" name="password" required min="3" max="20"/><br/>
    Czy zapamiętać: <input type="checkbox" name="remember-me"/><br/>
    <button type="submit">Zaloguj</button>
</form>
</body>
</html>
