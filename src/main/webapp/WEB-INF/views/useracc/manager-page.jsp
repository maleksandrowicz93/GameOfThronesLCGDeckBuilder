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
                        <c:choose>
                        <c:when test="${lastAddedDeck==null}">
                            <h2>Brak talii</h2>
                        </c:when>
                        <c:otherwise>
                        <h2>Ostatnio dodany:</h2>
                        <p>Frakcja: </p>
                        <p>Agenda: </p>
                        <ul>
                            <li>
                                Fabuły
                                <ul>
                                    <c:forEach var="card" items="${lastAddedDeck.cards}">
                                        <c:if test="${card.type=='plot'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Postacie
                                <ul>
                                    <c:forEach var="card" items="${lastAddedDeck.cards}">
                                        <c:if test="${card.type=='character'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Dodatki
                                <ul>
                                    <c:forEach var="card" items="${lastAddedDeck.cards}">
                                        <c:if test="${card.type=='attachment'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Miejsca
                                <ul>
                                    <c:forEach var="card" items="${lastAddedDeck.cards}">
                                        <c:if test="${card.type=='location'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                            <li>
                                Wydarzenia
                                <ul>
                                    <c:forEach var="card" items="${lastAddedDeck.cards}">
                                        <c:if test="${card.type=='event'}">
                                            <li><c:out value="${card.name}"/></li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                </c:otherwise>
                </c:choose>
                <div class="col-6">
                    <div class="structure-col">
                        <a class="btn btn-primary" href="/user/add" role="button">Add</a>
                        <p>lista talii:</p>
                        <ul>
                            <li>talia</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
</body>
</html>
