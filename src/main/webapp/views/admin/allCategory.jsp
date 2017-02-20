<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pure-g">
    <div class="pure-u-1-1">
        <h2>Список категорій</h2>
        <br>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <a href="newCategory" class="pure-button buttonBlue">Додати категорію</a>
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
            <c:forEach var="category" items="${allCategories}">
                <tr>
                    <td><%= i %></td>
                    <td>${category.name}</td>
                    <td>${category.position}</td>
                    <td>
                        <a href="changeCategory${category.id}" class="change">змінити</a> |
                        <a href="deleteCategory/${category.id}" class="delete">видалити</a>
                    </td>
                </tr>
                <% i++; %>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pure-u-1-1">
        <br>
        <a href="newCategory" class="pure-button buttonBlue">Додати сторінку</a>
    </div>
</div>


