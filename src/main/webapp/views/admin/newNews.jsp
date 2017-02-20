<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<form:form action="saveNews" method="POST" modelAttribute="news">
    <form:input path="title" placeholder="title"/>
    <br>
    <form:textarea path="text" placeholder="text"></form:textarea>
    <br>
    <button>save news</button>
</form:form>