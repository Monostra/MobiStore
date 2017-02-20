
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h2>Список Товарів</h2>
        <br>
    </div>
</div>
<div class="pure-g">
    <div class="pure-u-1-1">
        <a href="newGood" class="pure-button buttonBlue">Додати Товар</a>
    </div>
</div>
<br>
<div class="pure-g allGoods">
    <c:forEach var="good" items="${showGoods}">
        <div class="pure-u-6-24">
            <div class="wrapProductItem">
                <div class="productItem">
                    <div class="title">
                        <a href="" class="h2 dot-ellipsis dot-timer-update">${good.name}</a>
                    </div>
                    <div class="img">
                        <a href="">
                            <div class="wrapImg">
                                <c:forEach var="img" items="${good.images}">
                                    <c:if test="${img.mainImg == true}">
                                        <img src="${img.pahtImg}" alt="">
                                    </c:if>
                                </c:forEach>
                            </div>
                        </a>
                    </div>
                    <div class="addInform">
                        <div class="wrapAddInfromItem">
                            <div class="showCount">
                                <span>${good.discount}</span>
                            </div>
                        </div>
                        <div class="wrapAddInfromItem">
                            <div class="showPrice">
                                <span class="price">${good.price} &#8372;</span>
                                <span class="oldPrice" style="display: none;">654</span>
                                <span class="newPrice" style="display: none;">84</span>
                            </div>
                        </div>
                    </div>
                    <div class="operation">
                        <a href="changeGood${good.id}" class="change">змінити</a> |
                        <a href="deleteGood/${good.id}" class="delete">видалити</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
