<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h2>Список сторінок</h2>
        <br>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <a href="newNews" class="pure-button buttonBlue">Додати новину</a>
        <br><br>
    </div>
    <div class="pure-u-1-1">
        <table class="pure-table pure-table-bordered table">
            <thead>
            <tr>
                <th>№</th>
                <th>Назва</th>
                <th>Дата</th>
                <th>Дія</th>
            </tr>
            </thead>
            <tbody>
            <% int i=1; %>
            <c:forEach var="news" items="${allNews}">
                <tr>
                    <td><%= i %></td>
                    <td>${news.title}</td>
                    <td>${news.date}</td>
                    <td>
                        <a href="" class="change">змінити</a> |
                        <a href="deleteNews/${news.id}" class="delete">видалити</a>
                    </td>
                </tr>
                <% i++; %>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pure-u-1-1">
        <br>
        <a href="newNews" class="pure-button buttonBlue">Додати новину</a>
    </div>
</div>