<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%-- <!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='<c:url value="/css/main.css" />' rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" scr='<c:url value="/js/common.css" />'></script>
</head>
<body> --%>
<%-- ${goods } --%>
<%-- 	<c:forEach var="gd" items="${goods }">
		${gd.name }
		<c:forEach var="ct" items="${gd.category }">
			${ct.name }
		</c:forEach>
	</c:forEach>
 --%>
<!-- <br>
<br>
<br> -->

	<c:forEach var="good" items="${goodDto }">
		${good.name} &nbsp;
		 <a style="color:red" href="deleteGood/${good.id }">delete</a>
		<br>
	</c:forEach>

	<br>
		<a href="admin">admin</a>
	<br>
good
<br>
<%--<form:form action="./saveGood?${_csrf.parameterName}=${_csrf.token}" method="post"  enctype="multipart/form-data">--%>
<form:form modelAttribute="goods" action="saveGood?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<form:input path="name" placeholder="name"/>
	<br>
	<form:input path="article" placeholder="article"/>
	<br>
	<form:input path="metaTitle" placeholder="meta Title"/>
	<br>
	<form:input path="metaDescription" placeholder="meta Description"/>
	<br>

	<form:input path="shortDescription" placeholder="short description"/>
	<br>
	<form:input path="longDescrtipion" placeholder="long description"/>
	<br>
	<form:input path="specification" placeholder="specification"/>
	<br>
	<form:radiobutton path="visible" value="false" id="v2"/>
	<label for="v2">visible false</label>
	<br>
	<form:radiobutton path="visible" value="true" id="v1" checked="checked"/>
	<label for="v1">visible true</label>
	<br>

	<input name="price" placeholder="price"/>
	<br>

	<form:select path="eyesStoppers" items="${eyesStoppers}" itemLabel="name" itemValue="id"></form:select>
	<br>
	<input name="discount" placeholder="discount" value="0"/>
	<br>
	<%--<input type="text" name="discountDate" placeholder="discount date(count day)"/>--%>
	<%--<input name="date" type="date">--%>
	<input type="text" name="date" value="0">
	<br>

	<%--<form:input path="video" placeholder="video"/>--%>
	<br>
	<input type="file" name="image" id="i1"> <input type="radio" name="mainImg" value="1">
	<br>
	<input type="file" name="image" id="i2"> <input type="radio" name="mainImg" value="2">
	<%--<input name="count" placeholder="count goods"/>--%>
	<br>


	<%-- <select name="id">
		<c:forEach var="cat" items="${cat}">	
			<option value="${cat.id }">${cat.name }</option>
		</c:forEach>
	</select>  --%>
	
	<form:select path="category" items="${categories}" itemLabel="name" itemValue="id"></form:select>

	<br>
	<button>save good</button>
</form:form>
<%--safe in flash--%>
<%-- 
<form action="saveGood" method="post">
	<input type="text" name="name" placeholder="name">
	<br>
	<!-- <input type="text" name="article" placeholder="article">
	<br>
	<input type="text" name="title" placeholder="title">
	<br>
	<input type="text" name="keywords" placeholder="keywords">
	<br>
	<input type="text" name="description" placeholder="description">
	<br>
	<input type="text" name="mainImg" placeholder="main img">
	<br>
	<input type="text" name="slideImg" placeholder="slide img">
	<br>
	<input type="text" name="shortDescr" placeholder="short description">
	<br>
	<input type="text" name="longDescr" placeholder="long description">
	<br>
	<input type="text" name="spec" placeholder="specification">
	<hr>
	<br>
	
	<input type="radio" name="visible" value="true" id="v1"><label for="v1">visible true</label>
	<br>
	<input type="radio" name="visible" value="false" id="v2"><label for="v2">visible false</label>
	<hr>
	
	<br>
	<input type="radio" name="news" value="true" id="n1"><label for="n1">new true</label>
	<br>
	<input type="radio" name="news" value="false" id="n2"><label for="n2">new false</label>
	<hr>

	<br>
	<input type="radio" name="top" value="true" id="t1"><label for="t1">top true</label>
	<br>
	<input type="radio" name="top" value="false" id="t2"><label for="t2">top false</label>
	<hr>
	<br>

	<input type="text" name="price" placeholder="price">
	<br>
	<input type="text" name="discount" placeholder="discount">
	<br>

	<input type="text" name="discountDate" placeholder="discount date(count day)">
	<br>
	<input type="text" name="video" placeholder="video">
	<br> -->
	<hr>
	<select name="id">
		<c:forEach var="cat" items="${cat}">	
			<option value="${cat.id }">${cat.name }</option>
		</c:forEach>
	</select>
	

	<br>
	<br>
	<input type="submit">
	
</form>
 --%>

<!-- </body>
</html> -->