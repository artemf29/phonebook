<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Added</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section align="center">
    <br>
    <div>
        <a href="contact?action=addP"><img src="img/addP.png" alt="addP"></a>
        <br>
        <a href="contact?action=addP" style="color: darkcyan">Добавить человека</a>
    </div>
    <br>
    <div>
        <a href="contact?action=addO"><img src="img/addO.png" alt="addO"></a>
        <br>
        <a href="contact?action=addO" style="color: darkcyan">Добавить Организацию</a>
    </div>
    <br>
    <hr>
    <br>
    <button onclick="window.history.back()">Назад</button>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
