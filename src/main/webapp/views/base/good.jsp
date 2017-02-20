<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">${good.name}</h1>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <p>name: ${good.name}</p>
        <p>price: ${good.price}</p>
        <p>${good.shortDescription}</p>
        <div>
            <c:if test="${not empty good.images}">
                <c:forEach var="img" items="${good.images}">
                    <%--${img}--%>
                    <c:if test="${img.mainImg  == true}">
                        <img src="${img.pahtImg}" alt="" width="200"><br>
                    </c:if>
                    <c:if test="${img.mainImg  != true}">
                        <img src="${img.pahtImg}" alt="" width="100">
                    </c:if>

                </c:forEach>
            </c:if>
            <c:if test="${empty good.images}">
                <a href=""><img src="resources/img/phone_index.jpg" alt="" width="100"></a>
            </c:if>
        </div>

    </div>
</div>




