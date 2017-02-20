<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<div class="pure-g">
    <div class="pure-u-1-1">
        <h1 class="h1">${news.title}</h1>
    </div>
</div>
<div class="pure-g">
    <dive class="pure-u-1-1">
        <p>${news.date}</p>
        <br><br>
        <p>${news.text}</p>
    </dive>
</div>