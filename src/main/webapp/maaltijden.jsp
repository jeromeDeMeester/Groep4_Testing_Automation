<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Patient Overview"/>
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
                        <th scope="col">SSN</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="maaltijd" items="${maaltijden}">
                        <tr>
                            <td id="naam"><c:out value='${maaltijd.naam}'/></td>
                            <td id="prijs"><c:out value='${maaltijd.prijs}'/></td>
                            <td id="categorie"> <c:out value='${maaltijd.type}'/></td>
                            <c:if test="${maaltijd.vegetarisch}"> <td id="vegetarisch">Vegetarisch</td></c:if>
                           <c:if test="${maaltijd.allergenen.size() != 0}"> <td id="allergenen"> <c:forEach var="allergeen" items="${maaltijd.allergenen}"> <c:out value="${allergeen}"/> </c:forEach></td></c:if>
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