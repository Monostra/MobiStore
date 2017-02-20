<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> -->

	<%--<c:forEach var="cat" items="${cats }">--%>
		<%--${cat.id} &nbsp; ${cat.name}--%>
		<%--(<c:forEach var="good" items="${cat.goods}">--%>
			<%--${good.name}--%>
		<%--</c:forEach>)--%>
		<%--<br>--%>
	<%--</c:forEach>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
	<%--<c:forEach var="ct" items="${cat }">--%>
		<%--${ct.id} &nbsp; ${ct.name} &nbsp; <a style="color:red" href="delete/${ct.id }">delete</a>--%>
		<%--<br>--%>
	<%--</c:forEach>--%>


	<%--<br>--%>
		<%--<a href="home">home</a>--%>
	<%--<br>--%>

Category

<form:form modelAttribute="category" action="saveCategory" method="post">
	<form:input path="name" placeholder="name"/><br>
	<input name="position" placeholder="position(number)"/><br>
	<form:select path="parents">
		<form:option value="0">samostiuna kategoria</form:option>
		<c:forEach var="ct" items="${cat }">
			<form:option  value="${ct.id }">${ct.name }</form:option>
		</c:forEach>
	</form:select><br>

	<form:radiobutton path="visible" value="false" id="v2"/>
	<label for="v2">visible false</label><br>
	<form:radiobutton path="visible" value="true" id="v1" checked="checked" />
	<label for="v1">visible true</label><br>
	<button>save</button>
</form:form>
<%--<br>--%>
<%--<button id="showAllCategories">show all categories</button>--%>
<%--<br>--%>

<%--<div class="showAllCategories">--%>
	<%--<input type="hidden" name="csrf_name"--%>
		   <%--value="${_csrf.parameterName}" />--%>
	<%--<input type="hidden" name="csrf_value"--%>
		   <%--value="${_csrf.token}" />--%>
<%--</div>--%>
<%--<div id="allCategories">--%>

<%--</div>--%>
<!-- 
</body>
</html> -->