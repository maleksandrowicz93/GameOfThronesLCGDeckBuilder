<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<form:form modelAttribute="registrationForm" method="post">
    <form:errors path="*"/><br>
    Nazwa użytkownika: <form:input path="username"/><br>
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    Hasło: <form:password path="password"/><br>
    Powtórz hasło: <form:password path="confirmedPassword"/><br>
    <button type="submit" value="Zarejestruj">Zarejestruj</button>
</form:form>
</body>
</html>
