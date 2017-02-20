<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="leftBar">
	<div class="eyeStoppers">
		<ul>
			<li><a href="top"><img src="resources/img/nav-lider.png" width="34" alt=""></a></li>
			<li><a href="new"><img src="resources/img/nav-new.png" width="34" alt=""></a></li>
			<li><a href="discount"><img src="resources/img/nav-sale.png" width="34" alt=""></a></li>
		</ul>
	</div>
	<hr class="leftBarLine">
	<div class="catalog">
		<h3 class="h3">Каталог</h3>
		<nav class="accordion">
			<ul>
				<c:forEach var="category" items="${categories}">
					<li><a href="category${category.id}">${category.name}</a></li>
				</c:forEach>
				<%--<li class="sub">--%>
					<%--<a href="#">HTC</a>--%>
					<%--<span class="buttonAccordion">--%>
						<%--<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>--%>
					<%--</span>--%>
					<%--<ul class="subUl">--%>
						<%--<li><a href="">htc one</a></li>--%>
						<%--<li><a href="">htc two</a></li>--%>
					<%--</ul>--%>
				<%--</li>--%>
				<%--<li><a href="#">Lenovo</a></li>--%>
				<%--<li><a href="#">LG</a></li>--%>
				<%--<li class="sub">--%>
					<%--<a href="#">Nokia</a>--%>
					<%--<span class="buttonAccordion">--%>
						<%--<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>--%>
					<%--</span>--%>
					<%--<ul class="subUl">--%>
						<%--<li><a href="">nokia one</a></li>--%>
						<%--<li><a href="">nokia two</a></li>--%>
						<%--<li><a href="">nokia three</a></li>--%>
					<%--</ul>--%>
				<%--</li>--%>
				<%--<li><a href="#">Samsung</a></li>--%>
			</ul>
		</nav>
	</div>
	<hr class="leftBarLine">
	<div class="news">
		<h3 class="h3">Новини</h3>
		<ul>
			<c:forEach var="news" items="${allNews}">
				<li><span>${news.date}</span><a href="news${news.id}">${news.title}</a></li>
			</c:forEach>
			<%--<li><span>01.12.2016</span><a href="">Lorem ipsum dolor 1</a></li>--%>
			<%--<li><span>02.12.2016</span><a href="">Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor 2</a></li>--%>
			<%--<li><span>03.12.2016</span><a href="">Lorem ipsum dolor 3</a></li>--%>
		</ul>
		<a href="showNews" class="buttonNews pure-button buttonBlue">Всі новини</a>
	</div>
	<!-- <hr class="leftBarLine"> -->
</aside>