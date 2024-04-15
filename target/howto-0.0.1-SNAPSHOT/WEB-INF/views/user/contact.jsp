<%--
  Created by Aarya
  User: aarya
  Date: 2/8/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> ${title} </title>
    <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/css/material.css">
    <link rel="icon" href="${baseUrl}/resources/other/user/images/icon1.png">
    <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/fonts/font.css">
</head>
<body id="_4">
<!-- navigation bar -->
<ul id="nav-bar">
    <%--<a href="${baseUrl}/contact-us">
        <li>Contact</li>
    </a>--%>
    <a href="${baseUrl}/ask">
        <li>Ask Question</li>
    </a>
    <c:choose>
        <c:when test="${empty sessionScope.username}">
            <a href="${baseUrl}/login">
                <li>Log In</li>
            </a>
        </c:when>
        <c:otherwise>
            <a href="${baseUrl}/logout">
                <li>Log Out</li>
            </a>
        </c:otherwise>
    </c:choose>
</ul>
<!-- content -->
<div id="content" class="clearfix">

    <div id="box-1">
        <div class="heading">
            <center>
<%--                <h1 class="logo"><div id="i">h</div><div id="cir">H/div><div id="ntro">ow To</div></h1>--%>
<%--                <p id="tag-line">Where questions can be asked in the form of How To.</p>--%>
            </center>
        </div>
    </div>
    <div id="box-2">
        <div id="text">
            <h1>Kathford International College.</h1>
            <p style="line-height: 20px;">
                ${aboutUs.message}
            </p>
        </div>
    </div>

</div>

<!-- Footer -->
<div id="footer">
    &copy; 2022 &bull; Kathford International College
</div>

</body>

</html>