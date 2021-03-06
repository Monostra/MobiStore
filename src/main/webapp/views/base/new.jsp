<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">Новинки</h1>
    </div>
</div>
<%--<div class="pure-g">--%>
    <%--<div class="pure-u-1-1 viewSortWrap" id="sortView">--%>
        <%--<div class="pure-g viewSort">--%>
            <%--<div class="pure-u-lg-4-24 pure-u-md-5-24  pure-u-sm-1-2 pure-u-1-2 view">--%>
                <%--<span>Вид:</span>--%>
                <%--<button id="table" class="buttonGrey left buttonIcon buttonView active">--%>
                    <%--<i class="fa fa-th"></i>--%>
                <%--</button>--%>
                <%--<button id="line"class="buttonGrey right buttonIcon buttonView ">--%>
                    <%--<i class="fa fa-th-list"></i>--%>
                <%--</button>--%>
            <%--</div>--%>
            <%--<div class="pure-u-lg-17-24 pure-u-md-15-24 sort sortBig">--%>
                <%--<span>Сортування: </span>--%>
                <%--<p>--%>
                    <%--<strong>від дешевих до дорогих</strong>--%>
                    <%--<button class="pure-button buttonBlue buttonArrow">--%>
                        <%--<i class="fa fa-caret-down"></i>--%>
                    <%--</button>--%>
                <%--</p>--%>
                <%--<ul class="menuList">--%>
                    <%--<li><a id="1" href="#sortView">від дорогих до дешевих</a></li>--%>
                    <%--<li><a id="2" href="#sortView">спочатку нові</a></li>--%>
                    <%--<li><a id="3" href="#sortView">спочатку старі</a></li>--%>
                    <%--<li><a id="4" href="#sortView">без сортування</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="pure-u-lg-3-24 pure-u-md-4-24 pure-u-sm-1-2 pure-u-1-2  page.jsp">--%>
                <%--<span>по: </span>--%>
                <%--<p>--%>
                    <%--<strong>16</strong>--%>
                    <%--<button class="pure-button buttonBlue buttonArrow">--%>
                        <%--<i class="fa fa-caret-down"></i>--%>
                    <%--</button>--%>
                <%--</p>--%>
                <%--<ul class="menuList">--%>
                    <%--<li><a id="30" href="#sortView">30</a></li>--%>
                    <%--<li><a id="60" href="#sortView">60</a></li>--%>
                    <%--<li><a id="100" href="#sortView">100</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="pure-u-1-1 sort sortSmallWrap">--%>
                <%--<div class="sortSmall">--%>
                    <%--<span>Сортування: </span>--%>
                    <%--<p>--%>
                        <%--<strong>від дешевих до дорогих</strong>--%>
                        <%--<button class="pure-button buttonBlue buttonArrow">--%>
                            <%--<i class="fa fa-caret-down"></i>--%>
                        <%--</button>--%>
                    <%--</p>--%>
                    <%--<ul class="menuList">--%>
                        <%--<li><a id="1" href="#sortView">від дорогих до дешевих</a></li>--%>
                        <%--<li><a id="2" href="#sortView">спочатку нові</a></li>--%>
                        <%--<li><a id="3" href="#sortView">спочатку старі</a></li>--%>
                        <%--<li><a id="4" href="#sortView">без сортування</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="pure-g productsWrap">
    <c:forEach var="newly" items="${showNew }">
        <div class="pure-u-lg-6-24 pure-u-md-8-24 pure-u-sm-12-24 pure-u-1-1 productWrap">
            <div class="productIndexWrap">
                <div class="producIndex producIndexTable">
                    <div class="productWrapImg">
                        <c:if test="${not empty newly.images}">
                            <c:forEach var="img" items="${newly.images}">
                                <%--${img}--%>
                                <c:if test="${img.mainImg  == true}">
                                    <a href=""><img src="${img.pahtImg}" alt=""></a>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty newly.images}">
                            <a href=""><img src="resources/img/phone_index.jpg" alt="${newly.name}"></a>
                        </c:if>
                    </div>
                    <div class="productWrapTitle">
                        <h2 class="h2 dot-ellipsis dot-timer-update"><a href="good${newly.id}">${newly.name}</a></h2>
                    </div>
                    <div class="productWrapPrice">
                        <p>${newly.price }<span> грн</span></p>
                    </div>
                    <sec:authorize access="isAuthenticated()">
                        <div class="productWrapButtonBuy">
                            <a class="pure-button buttonGreen buttonBuy" id="g${newly.id}"><i class="fa fa-cart-plus fa-lg" aria-hidden="true"></i> Купити</a>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </c:forEach>
</div>