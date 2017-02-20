<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    

<c:forEach var="delivery" items="${deliveries }">
	${delivery.name }<br>
</c:forEach>

<br>
	<a href="admin">admin</a>
<br>
<h1>delivery</h1>
<br>

<div class="deliveryWrap">
	<input type="text" id="nameDelivery">
	<button id="save">save delivery</button>

	<input type="hidden" name="csrf_name"
		   value="${_csrf.parameterName}" />
	<input type="hidden" name="csrf_value"
		   value="${_csrf.token}" />
</div>


