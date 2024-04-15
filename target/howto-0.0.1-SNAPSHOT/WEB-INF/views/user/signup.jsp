<%--
  Created by Aarya
  User: aarya
  Date: 2/8/2022
  Time: 10:51 PM
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
    <link type="text/css" rel="stylesheet" href="${baseUrl}/resources/other/user/fonts/font.css">
    <link rel="icon" href="${baseUrl}/resources/other/user/images/icon1.png">
</head>
<body id="_6">
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
<div id="content">
    <div id="sf">
        <center>
            <div class="heading">
<%--                <p id="tag-line">Where questions can be asked in the form of How To.</p>--%>
            </div>

            <form action="${baseUrl}/signup" method="post" enctype="multipart/form-data">
                ${message}
                <input name="username" id="user" type="text" minlength="3" maxlength="20" title="This will be your parmanent Id."
                       placeholder="Create a Unique Username" autocomplete="off" required>
                <input name="password" id="key" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                       title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters"
                       placeholder="Create a Strong Password" autocomplete="off" required>
                <i class="material-icons" id="lock">lock</i>
                <i class="material-icons" id="person">person</i>
                <input name="name" id="name" type="text" title="Although, you will be called by your name only"
                       placeholder="Enter your Full Name" autocomplete="off" required>
                <input name="email" id="mailbox" type="email" title="Your Email id is in safe hands."
                       placeholder="Enter your Email Id" autocomplete="off" required>
                <i class="material-icons" id="email">mail</i>
                <i class="material-icons" id="iden">perm_identity</i>

                <div id="button-block">
                    <center>
                        <div class="buttons"><input name="submit" type="submit" value="Create An Account" class="up-in">
                        </div>
                        <div class="buttons" id="new"><a role="button" href="${baseUrl}/login" class="up-in">Already a
                            member : Log In</a></div>
                        <div class="buttons" id="backId"><a role="button" href="${baseUrl}/dashboard-v2" class="up-in">Back</a></div>
                    </center>
                </div>
            </form>
        </center>
    </div>
</div>

<!-- Footer -->
<div id="footer">
    &copy; 2022 &bull; Kathford International College
</div>

<!-- Sripts -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="${baseUrl}/resources/other/user/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${baseUrl}/resources/other/user/js/script.js"></script>

</body>
</html>