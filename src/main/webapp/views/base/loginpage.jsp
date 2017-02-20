<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>

<div class="pure-g">
	<div class="pure-u-1-1">
		<h1 class="h1">Вхід в особисний кабінет</h1>
	</div>
</div>
<div class="pure-g">
	<div class="pure-u-1-1">
		<form:form class="formstyler" action="loginprocesing" method="post" id="loginpage">
			<p><label for="login">Логін:</label></p>
			<div class="pure-u-1-4">
				<input id="login" name="username" type="text" class="styler" placeholder="login" required="required">
			</div>
			<p><label for="password">Пароль:</label></p>
			<div class="pure-u-1-4">
				<input id="password" name="password" type="password" class="styler" placeholder="password" required="required">
			</div>
			<div class="pure-g">
				<div class="pure-u-1-4">
					<p class="formstylerButtonWrap center">
						<button class="pure-button buttonBlue">Увійти</button>
					</p>
				</div>
			</div>
		</form:form>
	</div>
</div>

            
<%-- <form:form action="loginprocesing" method="post">
	<input name="username" type="text"  placeholeder="name"/>
	<input name="password" type="password" />
	<button>login</button>
</form:form> --%>