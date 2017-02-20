<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="UTF-8">
    <title>Mobi Admin</title>

    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="shortcut icon" href="resources/adminResources/img/favicon/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="resources/adminResources/img/favicon/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="resources/adminResources/img/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="resources/adminResources/img/favicon/apple-touch-icon-114x114.png">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-old-ie-min.css">
    <![endif]-->

    <link rel="stylesheet" href="resources/adminResources/css/libs.min.css">
    <link rel="stylesheet" href="resources/adminResources/css/main.css">
</head>
<body>
<div class="container">
    <tiles:insertAttribute name="adminHeader"/>
    <div class="wrapContent">
        <div class="pure-g">
            <div class="pure-u-5-24">
                <%--<tiles:insertAttribute name="adminLeftBar"/>--%>
            </div>
            <div class="pure-u-24-24">
                <div class="content">
                    <tiles:insertAttribute name="adminBody"/>
                </div>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="adminFooter"/>
</div>


<div class="hidden"></div>

<!--[if lt IE 9]>
<script src="libs/html5shiv/es5-shim.min.js"></script>
<script src="libs/html5shiv/html5shiv.min.js"></script>
<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
<script src="libs/respond/respond.min.js"></script>
<![endif]-->

<script src="resources/adminResources/js/libs.min.js"></script>
<script src="resources/adminResources/js/common.js"></script>
</body>
</html>








