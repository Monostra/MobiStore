<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<br>
<form:form modelAttribute="good" action="updateGood?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${good.id}">
	<form:input path="name" placeholder="name" value="${good.name}"/>
	<br>
	<form:input path="article" placeholder="article" value="${good.article}"/>
	<br>
	<form:input path="metaTitle" placeholder="meta Title" value="${good.metaTitle}"/>
	<br>
	<form:input path="metaDescription" placeholder="meta Description" value="${good.metaDescription}"/>
	<br>

	<form:input path="shortDescription" placeholder="short description" value="${shortDescription}"/>
	<br>
	<form:input path="longDescrtipion" placeholder="long description" value="${longDescription}"/>
	<br>
	<form:input path="specification" placeholder="specification" value="${specification}"/>
	<br>
	<form:radiobutton path="visible" value="false" id="v2"/>
	<label for="v2">visible false</label>
	<br>
	<form:radiobutton path="visible" value="true" id="v1" checked="checked"/>
	<label for="v1">visible true</label>
	<br>

	<form:input path="price" placeholder="price" value="${good.price}"/>
	<br>
	<%--<form:input path="discount" placeholder="discount" value="${good.discount}"/>--%>
	<br>
	<%--<input type="text" name="discountDate" placeholder="discount date(count day)"/>--%>
	<%--<input name="date" type="text" value="0">--%>
	<br>





	
	<%--<form:select path="category" items="${categories}" itemLabel="name" itemValue="id"></form:select>--%>
	<br>
	<%--<form:select path="eyesStoppers" items="${eyesStoppers}" itemLabel="name" itemValue="id"></form:select>--%>
	<br>
	<button>save good</button>
</form:form>




<%--<br>--%>
<%--<input type="file" name="image" id="i1"> <input type="radio" name="mainImg" value="1">--%>
<%--<br>--%>
<%--<input type="file" name="image" id="i2"> <input type="radio" name="mainImg" value="2">--%>

<%--<br>--%>



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