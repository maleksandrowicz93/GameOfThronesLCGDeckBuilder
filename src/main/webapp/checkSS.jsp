<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security Taglibs</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <p>Dla zalogowanego</p>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <p>Dla niezalogowanego</p>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <p>Dla zalogowanego z rolą ADMIN</p>
</sec:authorize>

</body>
</html>
