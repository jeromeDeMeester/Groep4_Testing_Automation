<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Overzicht Menu"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="persons"/>
</jsp:include>

<div id="container">
    <main>
        <h1>Maaltijden</h1>
        <c:choose>
            <c:when test="${not empty maaltijden}">
                <table class="table table-striped">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Naam</th>
                        <th scope="col">Prijs (€)</th>
                        <th scope="col">Type</th>
                        <th scope="col">Vegetarisch</th>
                        <th scope="col">Allergïenen</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="maaltijd" items="${maaltijden}">
                        <tr>
                            <td id="naam"><c:out value='${maaltijd.naam}'/></td>
                            <td id="prijs"><c:out value='${maaltijd.prijs}'/></td>
                            <td id="categorie"> <c:out value='${maaltijd.type}'/></td>
                                <c:choose>
                                    <c:when test="${maaltijd.vegetarisch}">
                                        <td id="vegetarisch">Ja</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td id="vegetarisch">Nee</td>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${maaltijd.allergenen.size() != 0}">
                                        <td id="allergenen">
                                            <c:forEach var="allergeen" items="${maaltijd.allergenen}">
                                                <c:out value="${allergeen}"/>
                                            </c:forEach>
                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td id="allergenen">Geen</td>
                                    </c:otherwise>
                                </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p><em>No patients found</em></p>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>