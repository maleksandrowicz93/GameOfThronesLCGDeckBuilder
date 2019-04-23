<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="home-head.jsp"/>

<body>

<jsp:include page="home-header.jsp"/>

<br/><br/>
<h2><span id="reg-form-header">Formularz logowania</span></h2>

<form method="post" action="/login">

    <c:if test="${param.error != null}">
        <span>Nieprawidłowe dane logowania!</span>
    </c:if>
    <c:if test="${param.logout != null}">
        <span>Zostałeś wylogowany</span>
    </c:if>

    <div class="form-group">
        <label class="label-text" for="inputUsername">Nazwa użytkownika</label>
        <input type="text" name="username" class="form-control" id="inputUsername"
               placeholder="Podaj nazwę użytkownika" required min="3" max="20"/><br/>
        <label class="label-text" for="inputPassword">Hasło</label>
        <input type="password" name="password" class="form-control" id="inputPassword"
               placeholder="Hasło" required min="3" max="20"/><br/>
        <div class="form-check">
            <input class="form-check-input" id="defaultCheck1" type="checkbox" name="remember-me">
            <label class="form-check-label" for="defaultCheck1">Czy zapamiętać?</label><br/><br/>
        </div>
        <button type="submit" class="btn btn-primary" id="reg-form-button">Zaloguj</button>
    </div>

</form>
</body>
</html>
