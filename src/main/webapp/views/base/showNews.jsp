<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">Всі Новини</h1>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-5"></div>
    <div class="pure-u-3-5">
        <table class="pure-table pure-table-bordered table" style="width: 100%">
            <thead>
            <tr>
                <th>№</th>
                <th>Назва</th>
                <th>Дата</th>
            </tr>
            </thead>
            <tbody>
            <% int i=1; %>
            <c:forEach var="news" items="${allNews}">
                <tr>
                    <td><%= i %></td>
                    <td><a href="news${news.id}">${news.title}</a></td>
                    <td>${news.date}</td>
                </tr>
                <% i++; %>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
