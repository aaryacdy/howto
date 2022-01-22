<%--
  Created by Aarya Chaudhary
  User: aarya
  Date: 1/16/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../layout/login-sigup/header.jsp"></jsp:include>
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="${baseUrl}/admin/signup/add" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-26">
						Signup
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="name">
                    <span class="focus-input100" data-placeholder="Name"></span>
                </div>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="username">
                    <span class="focus-input100" data-placeholder="Enter Username"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Valid email is: a@b.c">
                    <input class="input100" type="text" name="email">
                    <span class="focus-input100" data-placeholder="Email"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="password">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="number" name="phoneNo" minlength="6" maxlength="15">
                            <span class="focus-input100" data-placeholder="Phone No."></span>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="number" name="mobileNo" minlength="10" maxlength="10">
                            <span class="focus-input100" data-placeholder="Mobile No."></span>
                        </div>
                    </div>

                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Signup
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>
<jsp:include page="../layout/login-sigup/footer.jsp"></jsp:include>
</body>
</html>