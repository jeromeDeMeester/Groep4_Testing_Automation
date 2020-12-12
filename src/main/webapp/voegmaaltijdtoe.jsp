<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Add Maaltijd"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="register"/>
</jsp:include>

<div id="container">
    <main>
        <form method="post" action="Controller?command=AddMaaltijdConfirm">
            <p>
                <label for="naam">naam</label>
                <input type="text" id="naam" name="naam">
            </p>
            <p>
                <label for="prijs">prijs</label>
                <input type="number" step="0.01" id="prijs" name="prijs">
            </p>
            <p>
                <label for="type">type</label>
                <input type="text" id="type" name="type">
            </p>
            <p>
                <label for="vegetarisch">Vegetarisch</label>
                <input type="checkbox" id="vegetarisch" name="vegetarisch">
            </p>
            <p>
                <label for="allergenen">allergenen</label>
                <input type="text" id="allergenen" name="allergenen">
            </p>
            <p>
                <input type="submit" id="register" value="Register">
            </p>
        </form>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
