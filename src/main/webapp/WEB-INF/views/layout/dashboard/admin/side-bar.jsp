<%--
  Created by IntelliJ IDEA.
  User: aarya
  Date: 1/19/2022
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-2 sidebar" style="margin-left:20px">
    <div class="row">
        <div class="absolute-wrapper"></div>
        <!-- Menu -->
        <div class="side-menu">
            <nav class="navbar navbar-default" role="navigation">
                <!-- Main Menu -->
                <div class="side-menu-container">
                    <ul class="nav navbar-nav">
                        <li>
                            <button style="width:240px; height:50px" type="button" class="btn btn-default btn-primary">
                                <span class="glyphicon  glyphicon-home pull-left"></span> Dashboard
                            </button>
                        </li>

                        <li>
                            <button style="width:240px; height:50px" type="button" class="btn btn-default btn-primary">
                                <span class="glyphicon glyphicon-edit pull-left"></span>
                                Admin
                            </button>
                        </li>

                        <li>
                            <button style="width:240px; height:50px" type="button" class="btn btn-default btn-primary"><span
                                    class="glyphicon glyphicon-edit pull-left"></span> Add Feature
                            </button>
                        </li>

                        <li>
                            <button style="width:240px; height:50px" type="button"
                                    class="btn btn-default dropdown-toggle btn-primary" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-edit pull-left"></span> Lists <span
                                    class="glyphicon glyphicon-triangle-bottom pull-right"></span>
                            </button>
                            <ul class="dropdown-menu" style="width:240px">
                                <li><a href="#"><strong> Other List</strong> </a></li>
                                <li><a href="#"><strong> Extra List</strong></a></li>
                            </ul>
                        </li>


                        <li>
                            <button style="width:240px; height:50px" type="button" class="btn btn-default btn-primary"><span
                                    class="glyphicon glyphicon-edit pull-left"></span> Manage Users
                            </button>
                        </li>
                        <li>
                            <button style="width:240px; height:50px" type="button" class="btn btn-default btn-danger"><span
                                    class="glyphicon glyphicon-off pull-left"></span> Logout
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>