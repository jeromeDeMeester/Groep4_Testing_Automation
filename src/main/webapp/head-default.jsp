<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css?v=<fmt:formatDate pattern="yyyyMMddHHmmss" value="<%=new java.util.Date()%>"/>">
    <title><c:out value="${param.title}" /> - BMI app</title>
</head>
<body>
    <header>
        <h1>${param.title}</h1>
        <nav>
            <ul>
                <li><a href="Controller?command=Home">Home</a></li>
                <li><a href="Controller?command=OverviewMaaltijden">Overview</a></li>
                <li><a href="Controller?command=SignUp">Register</a></li>
            </ul>
        </nav>
    </header>
</body>