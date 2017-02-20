<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<header>
	<div class="pure-g">
		<div class="pure-u-1">
			<div class="header">
				<p class="headPhone"><i class="fa fa-mobile"></i> 8 (800) 700-00-01</p>
				<div class="headUser">
					<sec:authorize access="!isAuthenticated()">
						<div class="headEnter">
							<%--<a href="#enter" class="headEnterBig fancybox"><i class="fa fa-user"></i>Увійти</a>,--%>
							<a href="loginpage" class="headEnterBig"><i class="fa fa-user"></i>Увійти</a>,
							<a href="registration" class="headEnterBig">Реєстрація</a>
							<a href="#" class="headEnterSmall"><i class="fa fa-user"></i></a>
						</div>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<div class="headAutorization">
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="admin">admin page</a>
							</sec:authorize>
							<span>Привіт <a href="" id="headAutorization"><i class="fa fa-user"></i><sec:authentication property="name" /></a></span>
							<%--<a href="profile">--%>
								<%--<!-- <img src="res/img/avatar.jpg" width="30" alt=""> -->--%>
								<%--&lt;%&ndash;<img src="${user.pathImg }" width="30" alt="">&ndash;%&gt;--%>
							<%--</a>--%>
							<ul class="menuList">
								<sec:authorize access="hasRole('ROLE_USER')">
									<li><a href="profile">Особисті дані</a></li>
									<li><a href="userOrders">Мої замовленя</a></li>
								</sec:authorize>
								<li>
									<form:form action="logout" method="post">
										<input type="submit" name="eixt" value="Вихід"> <i class="fa fa-sign-out" aria-hidden="true"></i>
									</form:form>
								</li>
							</ul>
						</div>
					</sec:authorize>
				</div>
				<div class="clr"></div>
			</div>
		</div>
	</div>
	<div class="pure-g">
		<div class="pure-u-lg-7-24 pure-u-md-6-24 pure-u-sm-4-24 pure-u-1-1 wrapLogo">
			<div class="logo">
				<a href="home"><img src="resources/img/logo.png" alt=""></a>
			</div>
		</div>
		<div class="pure-u-lg-10-24 pure-u-md-9-24 pure-u-sm-20-24 pure-u-1-1">
			<div class="slogan">
				<h6>
					<a href="home">
						<div>
							<span>M</span>
							<span>o</span>
							<span>b</span>
							<span>i</span>
						</div>
						<span>S</span>
						<span>t</span>
						<span>o</span>
						<span>r</span>
						<span>e</span>
					</a>
				</h6>
			</div>
		</div>
		<div class="pure-u-lg-7-24 pure-u-md-9-24 pure-u-sm-24-24 pure-u-1-1">
			<div class="cart">
				<div class="cartImg">
					<div class="cartWrapImg">
						<img src="resources/img/cart.png" width="100" alt="cart">
					</div>
				</div>
				<div id="cartInform">
					<c:if test="${loadCart[0] == null}">
						<div class="cartEmpty" style="display: block">
							<h4 class="h4">Корзина пуста</h4>
						</div>
					</c:if>
					<c:if test="${loadCart != null}">
						<div class="cartFull">
							<div ><p><span>${loadCart[0]}</span> на суму <span>${loadCart[1]}</span> грн.</p></div>
							<a href="cart" class="pure-button buttonBlue buttonCart">Оформити замовлення</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</header>
<nav class='menu' style="overflow: visible">
	<div class="pure-g">
		<div class="pure-u-1">
			<ul>
				<li class="active"><a href="home">Main</a></li>
				<c:forEach var="page" items="${pages}">
					<li><a href="page${page.id}">${page.name}</a></li>
				</c:forEach>
				<%--<li><a href="">About Shop</a></li>--%>
				<%--<li><a href="">Pay &amp; Delivery</a></li>--%>
				<%--<li><a href="">Contact</a></li>	--%>
			</ul>
			<form:form action="search" class="search" method="post">
				<input id="search" type="text" placeholder="Search" class="styler" name="search">
				<button class="pure-button"><i class="fa fa-search"></i></button>
				<ul class="textSearch" style="width: 100%; position: absolute; top: 40px;
				right: 0; background-color: #555; color: #fff;z-index: 50; display: none;">
					<%--<li>sadf</li>--%>
				</ul>
			</form:form>

		</div>
	</div>
</nav>