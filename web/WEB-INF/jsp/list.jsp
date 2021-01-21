<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Phone Book</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <br>
    <table border="1" cellpadding="8" cellspacing="0" style="margin: auto;color: #008b8b"
           bgcolor="#ffe4c4">
        <tr>
            <th>Имя Контакта</th>
            <th>Номер</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${contacts}" var="contact">
            <jsp:useBean id="contact" type="com.artemf29.core.webapp.contacts.Contact"/>
            <tr>
                <td><a style="color: #008b8b" href="contact?uuid=${contact.uuid}&action=view">${contact.name}</a></td>
                <td>${contact.phoneNumber.toString()}</td>
                <td><a href="contact?uuid=${contact.uuid}&action=edit"><img src="img/edit.png"></a></td>
                <td><a href="contact?uuid=${contact.uuid}&action=delete"><img src="img/delete.png"></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
