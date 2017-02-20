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
        <a href="newPage" class="pure-button buttonBlue">Додати сторінку</a>
        <br><br>
    </div>
    <div class="pure-u-1-1">
        <table class="pure-table pure-table-bordered table">
            <thead>
            <tr>
                <th>№</th>
                <th>Назва</th>
                <th>Порядок</th>
                <th>Дія</th>
            </tr>
            </thead>
            <tbody>
            <% int i=1; %>
            <c:forEach var="page" items="${pages}">
                <tr>
                    <td><%= i %></td>
                    <td>${page.name}</td>
                    <td>${page.position}</td>
                    <td>
                        <a href="changePage${page.id}" class="change">змінити</a> |
                        <a href="deletePage/${page.id}" class="delete">видалити</a>
                    </td>
                </tr>
                <% i++; %>
            </c:forEach>

            <%--<tr>--%>
                <%--<td>2</td>--%>
                <%--<td>Про магазин</td>--%>
                <%--<td>2</td>--%>
                <%--<td>--%>
                    <%--<a href="" class="change">змінити</a> |--%>
                    <%--<a href="" class="delete">видалити</a>--%>
                <%--</td>--%>
            <%--</tr>--%>
            </tbody>
        </table>
    </div>
    <div class="pure-u-1-1">
        <br>
        <a href="newPage" class="pure-button buttonBlue">Додати сторінку</a>
    </div>
</div>



