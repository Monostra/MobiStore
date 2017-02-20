<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<c:forEach var="ct" items="${cartss}">
    ${ct.id}<br>
</c:forEach>
<br>


<form:form modelAttribute="carts" action="saveCart" method="post">
    <form:input path="quantity"/>
    <br>
    <form:input path="userIP" placeholder="IP"/>
    <br>
    <form:select path="user" items="${users}" itemLabel="login" itemValue="id"></form:select>
    <br>
    <form:select path="goods" items="${goodss}" itemLabel="name" itemValue="id"></form:select>
    <br>
    <button>save cart</button>
</form:form>
