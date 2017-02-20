<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<form:form action="updatePage" method="POST" modelAttribute="page">
    <form:input path="name" placeholder="name" value="${page.name}"/>
    <br>
    <form:input path="metaTitle" placeholder="meta title" value="${page.metaTitle}"/>
    <br>
    <form:input path="metaDescription" placeholder="meta description" value="${page.metaDescription}"/>
    <br>
    <form:textarea path="text" placeholder="text" value="${page.text}"></form:textarea>
    <br>
    <%--<form:input path="position" type="number" placeholder="position" />--%>
    <br>
    <%--<form:radiobutton path="visible" value="false" id="v2"/>--%>
    <input type="radio" name="visible" value="false" id="v2">
    <label for="v2">visible false</label><br>
    <%--<form:radiobutton path="visible" value="true" id="v1" checked="checked"/>--%>
    <input type="radio" name="visible" value="true" id="v1" checked="checked">
    <label for="v1">visible true</label><br>
    <br>
    <button>save page</button>
</form:form>


