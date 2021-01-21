<%@ page import="com.artemf29.core.webapp.contacts.Person" %>
<%@ page import="com.artemf29.core.webapp.contacts.Organization" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="contact" type="com.artemf29.core.webapp.contacts.Contact" scope="request"/>
    <title>Контакт${contact.name}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section align="center">
    <h2>${contact.name}<a href="contact?uuid=${contact.uuid}&action=edit">
        <br/><img src="img/edit.png"></a>
        <a href="contact?uuid=${contact.uuid}&action=delete"><img src="img/delete.png"></a></h2>
    <hr>
    <br>
    <p>Тел:
        <c:set var="number" value="${contact.phoneNumber}"/>
        <jsp:useBean id="number" type="com.artemf29.core.webapp.contacts.object.PhoneNumber"/>
            <%=number.getNumber()%>
    <p><br>
            <%=contact instanceof Person ? "Пол: " + (((Person) contact).getGender().getGender()) : "Инфо: " + ((Organization)contact).getInfo()%>
    <p><br>Дата создания: ${contact.createDate}
    <p>Дата обновления: ${contact.updateDate}
    <p><br>
    <hr>
    <br>
    <button onclick="window.history.back()">Назад</button>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
