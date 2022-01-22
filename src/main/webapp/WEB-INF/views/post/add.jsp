<%--
  Created by Aarya Chaudhary
  User: aarya
  Date: 1/19/2022
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
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

<%@include file="../layout/dashboard/admin/header.jsp" %>
<div class="container-fluid">
    <%@include file="../layout/dashboard/admin/side-bar.jsp" %>
    <div class="col-md-9 content" style="margin-left:10px">
        <div class="panel panel-default">
            <div class="panel-heading" style="background-color:#c4e17f">
                <h1><span class="glyphicon glyphicon-tag"></span> Product / Add Product </h1></div>
            <br>
            <div class="panel-body" style="background-color:#E6EEEE;">
                <div class="col-lg-7">
                    <div class="well">
                        <form action="" method="post" name="form" enctype="multipart/form-data">
                            <p>Title</p>
                            <input class="input-lg thumbnail form-control" type="text" name="product_name"
                                   id="product_name" autofocus style="width:100%" placeholder="Product Name" required>
                            <p>Description</p>
                            <textarea class="thumbnail form-control" name="details" id="details"
                                      style="width:100%; height:100px" placeholder="write here..." required></textarea>
                            <p>Add Image</p>
                            <div style="background-color:#CCC">
                                <input type="file" style="width:100%" name="picture" class="btn thumbnail" id="picture">
                            </div>
                    </div>
                    <div class="well">
                        <h3>Pricing</h3>
                        <p>Price</p>
                        <div class="input-group">
                            <div class="input-group-addon">Rs</div>
                            <input type="text" class="form-control" name="price" id="price" placeholder="0.00" required>
                        </div>
                        <br>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="well">
                        <h3>Category</h3>
                        <p>Product type</p>
                        <input type="number" name="product_type" id="product_type" class="form-control"
                               placeholder="1 electronic,2 Ladies Wears,3 Mens Wear">
                        <br>
                        <p>Vendor / Brand</p>
                        <input type="number" name="brand" id="brand" class="form-control"
                               placeholder="1 HP,2 Samsung,3 Apple,4 motorolla">
                        <br>
                        <p>Other tags</p>
                        <input type="text" name="tags" id="tags" class="form-control"
                               placeholder="Summer, Soft, Cotton etc">
                    </div>
                </div>
                <div align="center">
                    <button type="submit" name="submit" id="submit" class="btn btn-default"
                            style="width:100px; height:60px"> Cancel
                    </button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../layout/dashboard/admin/footer.jsp" %>
</body>
</html>
