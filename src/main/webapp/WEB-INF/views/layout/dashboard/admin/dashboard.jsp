<%--
  Created by IntelliJ IDEA.
  User: aarya
  Date: 1/19/2022
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Panel</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${baseUrl}/resources/other/admin-dashboard/style/css/bootstrap.min.css" rel="stylesheet">
    <link href="${baseUrl}/resources/other/admin-dashboard/style/css/k.css" rel="stylesheet">
</head>
<body>

<%@include file="header.jsp" %>
<div class="container-fluid main-container">
    <%@include file="side-bar.jsp" %>

    <div class="col-md-9 content" style="margin-left:10px">
        <div class="panel panel-default">
            <div class="panel-heading" style="background-color:#c4e17f">
                <h1>Welcome </h1></div>
            <br>
            <div class="panel-body">
                <%--<h3>
                    <?php  //success message
                            if(isset($_POST['success'])) {
                                    $success = $_POST["success"];
                                    echo "<h1 style='color:#0C0'>Your Product was added successfully &nbsp;&nbsp;  <span class='glyphicon glyphicon-ok'></h1></span>";
                    }
                    ?></h3>--%>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
