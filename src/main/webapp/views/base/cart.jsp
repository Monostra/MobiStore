<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">Корзина</h1>
    </div>
</div>
<form:form modelAttribute="orders" action="saveOrder" method="post">
<div class="pure-g">

    <div class="pure-u-3-5">
        <br>
        <table class="pure-table pure-table-bordered table" style="width: 100%">
            <thead>
            <tr>
                <th>№</th>
                <th>Товар</th>
                <th>Ціна</th>
                <th>Кількість</th>
                <th>Дія</th>
            </tr>
            </thead>
            <tbody>
            <% int i=1; %>
            <c:forEach var="cart" items="${cartsUser}">
                <%--${order}<br>--%>
                <tr id="wrapC${cart.id}">
                    <td><%= i %></td>
                    <td><a href="good${cart.goods.id}">${cart.goods.name}</a></td>
                    <td><span id="newPrice${cart.id}">${cart.goods.price*cart.quantity}</span><br> 1шт = <span id="price${cart.id}">${cart.goods.price}</span></td>
                    <td><input id="cart${cart.id}" type="number" class="styler countCart" value="${cart.quantity}"></td>
                    <td><a id="c${cart.id}" class="pure-button buttonRed buttonDeleteCart" style="background:darkred; color: #fff;">delete</a></td>
                </tr>
                <% i++; %>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <br>
        <form:select path="delivery" items="${deliveries}" itemLabel="name" itemValue="id"></form:select>
        <br><br>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <button class="pure-button buttonGreen buttonOrder">Замовити</button>
    </div>
</div>
</form:form>



    <%--<div class="pure-g">--%>

            <%--<div class="pure-u-1-1" id="wrapC${ct.id}">--%>
                <%--${ct.goods.name} | ${ct.goods.price} | <input type="text" name="quantity" value="${ct.quantity}"> | <a id="c${ct.id}" class="pure-button buttonRed buttonDeleteCart">delete from cart</a>--%>
                <%--<br>--%>
                    <%--<br>--%>
            <%--</div>--%>
            <%--<input type="hidden" name="id" value="${ct.id}">--%>
        <%--</c:forEach>--%>
        <%--<div class="pure-u-1-1">--%>
            <%--<form:select path="delivery" items="${deliveries}" itemLabel="name" itemValue="id"></form:select>--%>
            <%--<br><br>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="pure-g">--%>
        <%--<div class="pure-u-1-1">--%>
            <%--<button class="pure-button buttonGreen buttonOrder">Замовити</button>--%>
        <%--</div>--%>
    <%--</div>--%>


