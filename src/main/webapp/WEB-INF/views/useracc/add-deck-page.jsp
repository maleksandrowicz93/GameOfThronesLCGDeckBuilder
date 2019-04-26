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
                        <div>
                            <p>obrazek</p>
                        </div>
                        <table>
                            <tr>
                                <th>Kod</th>
                                <th>Nazwa</th>
                                <th>Typ</th>
                                <th>Usuń</th>
                            </tr>
                            <c:forEach var="deckCard" items="${deck.cards}">
                                <tr>
                                    <td><c:out value="${deckCard.code}"/></td>
                                    <td><c:out value="${deckCard.name}"/></td>
                                    <td><c:out value="${deckCard.type}"/></td>
                                    <td><a class="btn btn-primary" href="/user/add/remove/${deckCard.code}"
                                       role="button">Usuń z talii</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a class="btn btn-primary" href="/user/add/save" role="button">Zapisz talię</a>
                    </div>
                </div>
                <div class="col-6">
                    <div class="structure-col">
                        <h2>lista kart:</h2>
                        <table>
                            <tr>
                                <th>Kod</th>
                                <th>Nazwa</th>
                                <th>Typ</th>
                                <th>Unikalna</th>
                                <th>Lojalna</th>
                                <th>Frakcja</th>
                                <th>Koszt</th>
                                <th>Siła</th>
                                <th>Opis</th>
                                <th>Limit</th>
                                <th>Dodatek</th>
                                <th>Ikona militarna</th>
                                <th>Ikona intrygi</th>
                                <th>Ikona władzy</th>
                                <th>Statystyka przychodu</th>
                                <th>Statystyka inicjatywy</th>
                                <th>Statystyka roszczeń</th>
                                <th>Statystyka rezerw</th>
                                <th>Dodawanie karty</th>
                            </tr>
                            <c:forEach var="set" items="${sets}">
                                <c:forEach var="card" items="${set.cards}">
                                    <tr>
                                        <td><c:out value="${card.code}"/></td>
                                        <td><c:out value="${card.name}"/></td>
                                        <td><c:out value="${card.type}"/></td>
                                        <td><c:out value="${card.isUnique}"/></td>
                                        <td><c:out value="${card.isLoyal}"/></td>
                                        <td><c:out value="${card.faction}"/></td>
                                        <td><c:out value="${card.cost}"/></td>
                                        <td><c:out value="${card.strength}"/></td>
                                        <td><c:out value="${card.description}"/></td>
                                        <td><c:out value="${card.deckLimit}"/></td>
                                        <td><c:out value="${card.cardSet.cgbdId}"/></td>
                                        <td><c:out value="${card.icons.military}"/></td>
                                        <td><c:out value="${card.icons.intrigue}"/></td>
                                        <td><c:out value="${card.icons.power}"/></td>
                                        <td><c:out value="${card.plotStats.income}"/></td>
                                        <td><c:out value="${card.plotStats.initiative}"/></td>
                                        <td><c:out value="${card.plotStats.claim}"/></td>
                                        <td><c:out value="${card.plotStats.reserve}"/></td>
                                        <td><a class="btn btn-primary" href="/user/add/add/${card.code}"
                                               role="button">Dodaj do talii</a></td>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>


</section>
</body>
</html>