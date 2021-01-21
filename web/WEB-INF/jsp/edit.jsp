<%@ page import="com.artemf29.core.webapp.contacts.Person" %>
<%@ page import="com.artemf29.core.webapp.contacts.Organization" %>
<%@ page import="com.artemf29.core.webapp.contacts.object.Gender" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="contact" type="com.artemf29.core.webapp.contacts.Contact" scope="request"/>
    <title>Contact ${contact.name}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section align="center">
    <br>
    <form method="post" action="contact" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${contact.uuid}">
         ФИО:
        <input type="text" name="name" size="39" value="${contact.name}">
        <br>
        <br>
         Номер:
        <input type="text" name="number" size="37" value="${contact.phoneNumber.number}">
        <br>
        <br>
        <% if(contact instanceof Organization) {
            Organization organization = (Organization) contact;%>
        Инфо:
        <br>
        <textarea name="info" cols="37" rows="5" ><%=organization.getInfo()%></textarea>
        <%} else {
        Person person = (Person) contact;%>
        <p>Пол:</p>
            <br>
        <% if (person.getGender().equals(Gender.MALE)){%>
        <input name="gender" type="radio" value="<%=Gender.MALE%>" checked>Мужчина
        <input name="gender" type="radio" value="<%=Gender.FEMALE%>">Женщина
        <%}else{%>
            <input name="gender" type="radio" value="<%=Gender.MALE%>">Мужчина
            <input name="gender" type="radio" value="<%=Gender.FEMALE%>" checked>Женщина
        <%}}%>
            <br>
        <hr>
        <br>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Назад</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
