<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${orders }
	<br>
		<a href="home">home</a>
	<br>
orders
	<br>
	
	<form action="saveOrders" method="post">

		<input name="city" placeholder="city">
		<br>
		<input type="submit">
		
	</form>
<!-- </body>
</html> -->