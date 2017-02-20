<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="pure-g">
	<div class="pure-u-1-1">
		<h1 class="h1">Реєстрація</h1>
	</div>
</div>
<div class="pure-g">
	<div class="pure-u-1-1">
		<form:form modelAttribute="user" class="formstyler" action="registration" method="post">
			<p style="color:red">${exeptions }</p>	
			<br>
			<p><label for="login">Логін:</label></p>
			<div class="pure-u-1-4">
				<form:input id="login" path="login" class="styler" placeholder="login" required="required"/>
			</div>
			<p><label for="password">Пароль:</label></p>
			<div class="pure-u-1-4">
				<form:input id="password" path="password" type="password" class="styler" placeholder="password" required="required"/>
			</div>
			<p><label for="name">Name:</label></p>
			<div class="pure-u-1-4">
				<form:input id="name" path="name" class="styler" placeholder="name" required="required"/>
			</div>
			<p><label for="surname">Surname:</label></p>
			<div class="pure-u-1-4">
				<form:input id="surname" path="surname" class="styler" placeholder="surname" required="required"/>
			</div>
			<p><label for="city">city:</label></p>
			<div class="pure-u-1-4">
				<form:input id="city" path="city" class="styler" placeholder="city" required="required"/>
			</div>
			<p><label for="address">address:</label></p>
			<div class="pure-u-1-4">
				<form:input id="address" path="address" class="styler" placeholder="address" required="required"/>
			</div>
			<p><label for="email">email:</label></p>
			<div class="pure-u-1-4">
				<form:input id="email" path="email" class="styler bigNumber" placeholder="email" required="required"/>
			</div>
			<p><label for="phone">phone:</label></p>
			<div class="pure-u-1-4">
				<form:input id="phone" path="phone" class="styler" placeholder="phone" required="required"/>
			</div>
			
			<div class="pure-g">
				<div class="pure-u-1-4">
					<p class="formstylerButtonWrap center">
						<button class="pure-button buttonBlue">Зареєструватись</button>
					</p>
				</div>
			</div>
		</form:form>
	</div>
</div>
