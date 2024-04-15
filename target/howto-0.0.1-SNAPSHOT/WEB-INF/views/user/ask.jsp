<%--
  Created by Aarya
  User: aarya
  Date: 2/8/2022
  Time: 11:00 PM
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
    <style>
        h1 {
            border-style: solid;
            border-width: 10px 100px;
        }
    </style>
</head>
<body id="ask">
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
            <div class="heading ask"></div>
            <input name="question" type="text" title="Your Question..."
                   placeholder="How To : Ask Your question in form of how to." autocomplete="off" id="askQuestion"
                   autofocus>
            <%--<input name="submit" type="submit" class="up-in" id="ask_submit">--%>
        </center>

        <div class="firstTimeShow">
            <c:if test="${not empty posts}">
                <c:forEach var="post" items="${posts}" varStatus="i">
                    <div style="border-width: thin !important;">
                        <h1 style="text-align: center">${i.index+1}. ${post.title}
                            <c:if test="${not empty post.blogUrl}">
                                <h5 style="text-align: center"><a href="${post.blogUrl}" target="_blank">${post.blogUrl}</a></h5>
                            </c:if>
                        </h1> <br><br>

                        <c:if test="${not empty post.image}">
                          <div style="text-align: center">
                              <a href="${baseUrl}/files/post/${post.image}" target="_blank">
                                  <image src="${baseUrl}/files/post/${post.image}" width="250" height="150"/></a>
                          </div>
                        </c:if>

                        <div class="description" style="text-align: center;">
                                ${post.description}
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </c:if>
        </div>

        <div class="dynamicContainer" style="display: none"></div>
    </div>
</div>

<div id="ask-ta">
    <h1>Thank You.<br>Stay tunned for updates.</h1>
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
<script type="text/javascript" src="${baseUrl}/resources/js/ask.js"></script>
<script class="text/javascript">
    let baseUrl = "${baseUrl}";
    $("#askQuestion").keyup(function (e) {
        if (e.keyCode == '13') {
            searchAnswer();
        }
    });
</script>
</body>
</html>