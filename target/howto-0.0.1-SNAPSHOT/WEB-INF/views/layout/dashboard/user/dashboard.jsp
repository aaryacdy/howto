<%--
  Created by Aarya
  User: aarya
  Date: 2/23/2022
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>
<div class="app-wrapper">

    <div class="app-content pt-3 p-md-3 p-lg-4">
        <div class="container-xl">
            <h1 class="app-page-title">Overview</h1>
            <div class="app-card alert alert-dismissible shadow-sm mb-4 border-left-decoration" role="alert">
                <div class="inner">
                    <div class="app-card-body p-3 p-lg-4">
                        <h3 class="mb-3">Welcome, ${sessionScope.username}!</h3>
                        <div class="row gx-5 gy-3">
                            <div class="col-12 col-lg-9">
                                <div>Now you can post your content, article from here.</div>
                            </div><!--//col-->

                        </div><!--//row-->
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div><!--//app-card-body-->

                </div><!--//inner-->
            </div><!--//app-card-->

            <div class="row g-4 mb-4">
                <div class="col-6 col-lg-3">
                    <div class="app-card app-card-stat shadow-sm h-100">
                        <div class="app-card-body p-3 p-lg-4">
                            <h4 class="stats-type mb-1">Total Post</h4>
                            <div class="stats-figure">${totalPost}</div>
                        </div><!--//app-card-body-->
                        <a class="app-card-link-mask" href="${baseUrl}/post"></a>
                    </div><!--//app-card-->
                </div><!--//col-->
            </div><!--//row-->
        </div><!--//container-fluid-->
    </div><!--//app-content-->
</div>
<!--//app-wrapper-->

<%@include file="../footer.jsp" %>