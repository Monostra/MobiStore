<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
	<meta charset="UTF-8">
	<title>Mobi strore</title>

	<meta name="description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<link rel="shortcut icon" href="resources/img/favicon/favicon.ico" type="image/x-icon">
	<link rel="apple-touch-icon" href="resources/img/favicon/apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="resources/img/favicon/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="resources/img/favicon/apple-touch-icon-114x114.png">

	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!--[if lte IE 8]>
    	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
	<![endif]-->

	<link rel="stylesheet" href="resources/css/libs.min.css">
	<link rel="stylesheet" href="resources/css/main.css">
</head>
<body>	

	<div class="container">
		<tiles:insertAttribute name="header"/>
		<div class="wrapContent">
			<div class="pure-g">
				<div class="pure-u-md-5-24">
					<tiles:insertAttribute name="leftBar"/>
				</div>
				<div class="pure-u-md-19-24">
					<div class="content">
						<tiles:insertAttribute name="body"/>
					</div>	
				</div>
			</div>
		</div>
		<tiles:insertAttribute name="footer"/>
	</div>
	
	<div class="hidden">
		<form:form id="enter" action="loginprocesing" method="post">
			<h4 class="h4">Вхід в особисний кабінет</h4>
			<p>Логін</p>
			<input id="login" name="username" type="text" class="styler" placeholder="login">
			<p>Пароль</p>
			<input id="password" name="password" type="password" class="styler" placeholder="password">

			<button class="pure-button">Увійти</button>

		</form:form>
		<div id="csrf">
			<input type="hidden" name="csrf_name"
				   value="${_csrf.parameterName}" />
			<input type="hidden" name="csrf_value"
				   value="${_csrf.token}" />
		</div>
	</div>

	<!--[if lt IE 9]>
	<script src="resources/libs/html5shiv/es5-shim.min.js"></script>
	<script src="resources/libs/html5shiv/html5shiv.min.js"></script>
	<script src="resources/libs/html5shiv/html5shiv-printshiv.min.js"></script>
	<script src="resources/libs/respond/respond.min.js"></script>
	<![endif]-->
	
	<script src="resources/js/libs.min.js"></script>

	<script src="resources/js/common.js"></script>
</body>
</html>