<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div class="pure-g">
	<div class="pure-u-1-1">
		<h1 class="h1">Особисний кабінет</h1><br>
	</div>
</div>
<div class="pure-g">
	<div class="pure-u-1-1">
		<%--<img src='${user.pathImg }' width="100" alt="alt">--%>
		<%-- ${user } --%>
	</div>
	<div class="pure-u-1-1">
		<form:form class="formstyler" action="updateUser" method="post">
			<div class="pure-u-6-24">
				<p>Логін:</p>
			</div>
			<div class="pure-u-6-24">
				<input required="required" class="styler" name="login" type="text" value="${user.login}" disabled="disabled"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="name">Name:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="name" class="styler" type="text" name="name" value="${user.name}" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="surname">Surname:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="surname" class="styler" type="text" name="surname" value="${user.surname}" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="city">Ciry:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="city" class="styler" name="city" type="text" value="${user.city}" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="address">Address:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="address" class="styler" type="text" name="address" value="${user.address}" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="email">Email:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="email" class="styler" type="text" value="${user.email}" disabled="disabled" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p><label for="phone">Phone:</label></p>
			</div>
			<div class="pure-u-6-24">
				<input id="phone" class="styler" name="phone" type="text" value="${user.phone}" required="required"/>
			</div>
			<br>
			<div class="pure-u-6-24">
				<p class="formstylerButtonWrap">
					<button class="pure-button buttonBlue">Зберегти</button>
				</p>
			</div>


		</form:form>
	</div>
	<hr>
	<div class="pure-u-1-1">
		<form:form class="formstyler" action="./saveImage?${_csrf.parameterName}=${_csrf.token}" method="post"  enctype="multipart/form-data">
			<div class="pure-u-24-24">
				<img src='${user.pathImg }' width="100" alt="alt">
			</div>
			<div class="pure-u-6-24">
				 <input type="file" name="image" required="required">
			</div>

			<div class="pure-g">
				<div class="pure-u-1-4">
					<p class="formstylerButtonWrap">
						<button class="pure-button buttonBlue">Зберегти</button>
					</p>
				</div>
			</div>
		</form:form>
	</div>

</div>
	
