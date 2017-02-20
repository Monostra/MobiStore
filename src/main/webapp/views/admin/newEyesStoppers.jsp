<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="eye" items="${showEyes}">
    ${eye.id} | ${eye.name} <br>
</c:forEach>
<br>
<br>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form modelAttribute="eyes" action="saveEye" method="post">
    <form:input path="name" placeholder="name"/>
    <br>
    <form:input path="metaTitle" placeholder="metaTitle"/>
    <br>
    <form:input path="metaDescription" placeholder="metaDescription"/>
    <br>
    <br>
    <button>save eyes</button>
</form:form>