<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">Мої замовлення</h1>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-5"></div>
    <div class="pure-u-3-5">
        <table class="pure-table pure-table-bordered table" style="width: 100%">
            <thead>
            <tr>
                <th>№</th>
                <th>Товар</th>
                <th>Кількість</th>
                <th>Дата</th>
            </tr>
            </thead>
            <tbody>
            <% int i=1; %>
            <c:forEach var="order" items="${userOrders}">
                <%--${order}<br>--%>
                <tr>
                    <td><%= i %></td>
                    <td><a href="good${order.goods.id}">${order.goods.name}</a></td>
                    <td>${order.quantity}</td>
                    <td>${order.orders.date}</td>
                </tr>
                <% i++; %>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>