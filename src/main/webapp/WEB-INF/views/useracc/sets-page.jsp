<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="useracc-head.jsp"/>

<body>

<jsp:include page="useracc-header.jsp"/>

<section>

    <div class="container">
        <div class="row">
            <div class="page-cols">
                <div class="col-6">
                    <div class="structure-col">
                        <c:if test="${cards!=null}">
                        <ul>
                            <li>
                                Agendy
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='agenda'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Fabuły
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='plot'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Postacie
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='character'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Dodatki
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='attachment'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Miejsca
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='location'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Wydarzenia
                                <ul>
                                    <c:forEach var="card" items="${cards}">
                                        <c:if test="${card.type=='event'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                        </c:if>
                    </div>
                </div>
                <div class="col-6">
                    <div class="structure-col">
                        <c:choose>
                            <c:when test="${sets==null}">
                                <h2>Brak dodatków</h2>
                            </c:when>
                            <c:otherwise>
                                <h2>lista dodatków:</h2>
                                <ul>
                                    <c:forEach var="set" items="${sets}">
                                        <li><a href="/user/sets/${set.cgbdId}"><c:out value="${set.name}"/></a></li>
                                    </c:forEach>
                                </ul>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
</html>