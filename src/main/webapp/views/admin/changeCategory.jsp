<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

Category

<form:form action="updateCategory" method="post">
	<input required="required" type="hidden" name="id" value="${category.id}">
	<input required="required" name="name" placeholder="name" value="${category.name}"/><br>
	<input required="required" name="position" placeholder="position(number)" value="${category.position}"/><br>
	<select required="required" name="parents">
		<option value="0">samostiuna kategoria</option>
		<%--<c:forEach var="ct" items="${category}">--%>
			<%--<form:option  value="${ct.id }">${ct.name }</form:option>--%>
		<%--</c:forEach>--%>
	</select><br>

	<%--<form:radiobutton path="visible" value="false" id="v2"/>--%>
	<input type="radio" name="visible" value="false" id="v2">
	<label for="v2">visible false</label><br>
	<%--<form:radiobutton path="visible" value="true" id="v1" checked="checked" />--%>
	<input type="radio" name="visible" value="true" id="v1" checked="checked">
	<label for="v1">visible true</label><br>
	<button>save</button>
</form:form>
