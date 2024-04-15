<%--
  Created by Aarya
  User: aarya
  Date: 3/8/2022
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${title}</title>

    <c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="description" content="How to : A Information Providing System">
    <meta name="author" content="Aarya Chaudhary Vs Balika Thapa">
    <link rel="shortcut icon" href="${baseUrl}/resources/bootstrap5/favicon.ico">
    <!-- FontAwesome JS-->
    <script defer src="${baseUrl}/resources/bootstrap5/plugins/fontawesome/js/all.min.js"></script>
    <!-- App CSS -->
    <link id="theme-style" rel="stylesheet" href="${baseUrl}/resources/bootstrap5/css/portal.css">
</head>

<body class="app">
<header class="app-header fixed-top">
    <div class="app-header-inner">
        <div class="container-fluid py-2">
            <div class="app-header-content">
                <div class="row justify-content-between align-items-center">
                    <div class="col-auto">
                        <a id="sidepanel-toggler" class="sidepanel-toggler d-inline-block d-xl-none" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30"
                                 role="img"><title>Menu</title>
                                <path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10"
                                      stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path>
                            </svg>
                        </a>
                    </div><!--//col-->
                    <div class="search-mobile-trigger d-sm-none col">
                        <i class="search-mobile-trigger-icon fas fa-search"></i>
                    </div><!--//col-->
                    <div class="app-utilities col-auto">
                        <div class="app-utility-item app-user-dropdown dropdown">
                            <a class="dropdown-toggle" id="user-dropdown-toggle" data-bs-toggle="dropdown" href="#"
                               role="button" aria-expanded="false"><img
                                    src="${baseUrl}/resources/bootstrap5/images/app-logo.svg" alt="user profile"></a>
                            <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
                                <li><a class="dropdown-item" href="${baseUrl}/admin/reset-password" target="_blank">Reset
                                    Password</a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="${baseUrl}/admin/logout">Log Out</a></li>
                            </ul>
                        </div><!--//app-user-dropdown-->
                    </div><!--//app-utilities-->
                </div><!--//row-->
            </div><!--//app-header-content-->
        </div><!--//container-fluid-->
    </div><!--//app-header-inner-->
    <div id="app-sidepanel" class="app-sidepanel">
        <div id="sidepanel-drop" class="sidepanel-drop"></div>
        <div class="sidepanel-inner d-flex flex-column">
            <a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
            <div class="app-branding">
                <a class="app-logo" href="${baseUrl}/admin/dashboard"><img class="logo-icon me-2"
                                                                           src="${baseUrl}/resources/bootstrap5/images/app-logo.svg"
                                                                           alt="logo"><span class="logo-text">HowTo</span></a>
            </div><!--//app-branding-->
            <nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
                <ul class="app-menu list-unstyled accordion" id="menu-accordion">
                    <li class="nav-item">
                        <a class="nav-link active" href="${baseUrl}/admin/dashboard">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                      <path fill-rule="evenodd"
                                            d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                                    </svg>
						         </span>
                            <span class="nav-link-text">Overview</span>
                        </a><!--//nav-link-->
                    </li><!--//nav-item-->
                    <%--category related menu--%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#categorysubmenu" aria-expanded="false">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                      <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                    </svg>
						         </span>
                            <span class="nav-link-text">Category</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                    </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->
                        <div id="categorysubmenu" class="collapse submenu submenu" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/category/add">Add</a>
                                </li>
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/category">View</a>
                                </li>
                            </ul>
                        </div>
                    </li><!--//nav-item-->

                    <%--Post related menu--%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#postsubmenu" aria-expanded="false">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                      <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                    </svg>
						         </span>
                            <span class="nav-link-text">Post</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                    </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->
                        <div id="postsubmenu" class="collapse submenu submenu" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <li class="submenu-item"><a class="submenu-link"
                                                            href="${baseUrl}/admin/post/add">Add</a></li>
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/admin/post">View</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <%--Users related menu--%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#signupsubmenu" aria-expanded="false">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                      <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                    </svg>
						         </span>
                            <span class="nav-link-text">Manage Users</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                    </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->
                        <div id="signupsubmenu" class="collapse submenu submenu" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <%--<li class="submenu-item"><a class="submenu-link" href="${baseUrl}/signup">Add</a>
                                </li>--%>
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/users">View</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <%-- about us module --%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#aboutUsSubmenu" aria-expanded="false">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                  <path fill-rule="evenodd"
                                        d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                  <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                </svg>
						         </span>
                            <span class="nav-link-text">Contact Us</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                  <path fill-rule="evenodd"
                                        d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->
                        <div id="aboutUsSubmenu" class="collapse submenu submenu" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <%--<li class="submenu-item"><a class="submenu-link" href="${baseUrl}/signup">Add</a>
                                </li>--%>
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/about-us">Add /
                                    Update</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <%--keyword related menu--%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#submenu-keyword" aria-expanded="false" aria-controls="submenu-keyword">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                  <path fill-rule="evenodd"
                                        d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                  <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                </svg>
						         </span>
                            <span class="nav-link-text">New Questions</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                    </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->

                        <div id="submenu-keyword" class="collapse submenu submenu-keyword" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/keyword/admin">Keyword</a></li>
                            </ul>
                        </div>
                    </li><!--//nav-item-->

                    <%--reset password--%>
                    <li class="nav-item has-submenu">
                        <a class="nav-link submenu-toggle" href="#" data-bs-toggle="collapse"
                           data-bs-target="#submenu-reset" aria-expanded="false" aria-controls="submenu-reset">
						        <span class="nav-icon">
						        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                  <path fill-rule="evenodd"
                                        d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                  <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                </svg>
						         </span>
                            <span class="nav-link-text">Reset Password</span>
                            <span class="submenu-arrow">
		                             <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down"
                                          fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                      <path fill-rule="evenodd"
                                            d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
                                    </svg>
	                             </span><!--//submenu-arrow-->
                        </a><!--//nav-link-->

                        <div id="submenu-reset" class="collapse submenu submenu-keyword" data-bs-parent="#menu-accordion">
                            <ul class="submenu-list list-unstyled">
                                <li class="submenu-item"><a class="submenu-link" href="${baseUrl}/admin/reset-password">Reset Password</a></li>
                            </ul>
                        </div>
                    </li><!--//nav-item-->

        </div><!--//sidepanel-inner-->
    </div><!--//app-sidepanel-->
</header>
<!--//app-header-->
