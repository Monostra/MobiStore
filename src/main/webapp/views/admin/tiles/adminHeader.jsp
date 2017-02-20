
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<header>
    <div class="pure-g">
        <div class="pure-u-1-1">
            <div class="header">
                <div class="pure-g">
                    <div class="pure-u-1-3">
                        <div class="slogan">
                            <h6>
                                <a href="/">
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
                    <div class="pure-u-1-3">
                        <div class="newOrder">
                            <%--<a href="" class="pure-button buttonGreen">Є нові замовлення: <span>5</span></a>--%>
                        </div>
                    </div>
                    <div class="pure-u-1-3">
                        <div class="headerInformation">
                            <p>Привіт: <span>Admin</span></p>
                            <div>
                                <a href="home" class="pure-button buttonBlue">На сайт</a>
                                <a href="" class="pure-button buttonBlue">Вийти</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<nav class='menu'>
    <div class="pure-g">
        <div class="pure-u-1-1">
            <ul>
                <li><a href="pages">Головне меню</a></li>
                <li><a href="allCategory">Каталог</a></li>
                <li><a href="allGoods">Товари</a></li>
                <%--<li><a href="allOrders">Замовлення</a></li>--%>
                <li><a href="allNews">Новини</a></li>
                <li><a href="newDelivery">Доставка</a></li>
                <li><a href="newEyesStoppers">newEyesStoppers</a></li>
            </ul>
        </div>
    </div>
</nav>
