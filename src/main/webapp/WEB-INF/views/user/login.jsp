<%--
  Created by arya
  User: aarya
  Date: 2/8/2022
  Time: 10:55 PM
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
<body id="_5">
<ul id="nav-bar">
   <%-- <a href="${baseUrl}/contact-us">
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
<div id="content">
    <center>
        <div class="heading">
<%--            <p id="tag-line">Where questions can be asked in the form of How To.</p>--%>
        </div>
        <form action="${baseUrl}/validate-login" method="post">
            ${message}
        <input name="username" id="user" type="text" title="Username" placeholder="Username" autocomplete="off" required>
        <input name="password" id="key" type="password" title="Password" placeholder="Password" autocomplete="off" required>
        <i class="material-icons" id="lock">lock</i>
        <i class="material-icons" id="person">person</i>
        <div id="button-block">
            <center>
                <div class="buttons"><input name="submit" type="submit" value="Log In" class="up-in"></div>
                <div class="buttons" id="new"><a role="button" href="${baseUrl}/signup" class="up-in">Create a new account</a></div>
                <div class="buttons" id="backId"><a role="button" href="${baseUrl}/dashboard-v2" class="up-in">Back</a></div>
            </center>
        </div>
        <a href="${baseUrl}/contact-us" id="trouble"><span>Having Trouble in login ? Contact Us</span></a>
        </form>
    </center>
</div>


<!-- Footer -->
<div id="footer">
    &copy; 2022 &bull; Kathford International College
</div>

<!-- Sripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script type="text/javascript" src="${baseUrl}/resources/other/user/js/jquery-3.2.1.min.js"><\/script>')</script>
<script type="text/javascript" src="${baseUrl}/resources/other/user/js/script.js"></script>

</body>

<%--<script>
    $(()=>{
        alert(" I am here");
    })
</script>--%>

</html>
