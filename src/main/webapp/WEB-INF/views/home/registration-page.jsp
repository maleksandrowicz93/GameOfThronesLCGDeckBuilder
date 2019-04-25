<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<jsp:include page="home-head.jsp"/>

<body>

<jsp:include page="home-header.jsp"/>

<section>

<br/><br/>
<h2><span id="reg-form-header">Formularz rejestracji</span></h2>

<form:form modelAttribute="registrationForm" method="post">
    <div class="form-group">
        <form:errors path="*"/><br>
        <label class="label-text" for="inputUsername">Nazwa użytkownika</label>
        <form:input cssClass="form-control" id="inputUsername" placeholder="Podaj nazwę użytkownika" path="username"/><br>
         <label class="label-text" for="inputFirstName">Imię</label>
        <form:input cssClass="form-control" id="inputFirstName" placeholder="Podaj imię" path="firstName"/><br>
         <label class="label-text" for="inputLastName">Nazwisko</label>
        <form:input cssClass="form-control" id="inputLastName" placeholder="Podaj nazwisko" path="lastName"/><br>
        <label class="label-text" for="inputPassword1">Hasło</label>
        <form:password cssClass="form-control" id="inputPassword1" placeholder="Hasło" path="password"/><br>
        <label class="label-text" for="inputPassword2">Powtórz hasło</label>
        <form:password cssClass="form-control" id="inputPassword2" placeholder="Hasło" path="confirmedPassword"/><br>
    </div>
    <button type="submit" class="btn btn-primary" id="reg-form-button">Zarejestruj</button>
</form:form>

</section>
</body>
</html>
