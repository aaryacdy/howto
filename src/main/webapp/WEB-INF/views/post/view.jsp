<%--
  Created by Aarya
  User: aarya
  Date: 3/27/2022
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../layout/dashboard/user/header.jsp" %>

<div class="app-wrapper">

    <div class="app-content pt-3 p-md-3 p-lg-4">
        <div class="container-xl">
            <h1 class="app-page-title">View Post</h1>
            <hr class="mb-4">
            <div class="row g-4 settings-section">
                <div class="col-12 col-md-4">
                    <h3 class="section-title"> View Post</h3>
                    <div class="section-intro">You can view Post from here.</div>
                </div>
                <div class="col-12 col-md-8">
                    <div class="app-card app-card-settings shadow-sm p-4">

                        <div class="app-card-body">
                            <div class="mb-3">
                                <label class="form-label">Title : </label> ${post.title}
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Category : </label> ${post.category.name}
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Description : </label> ${post.description}
                            </div>

                            <div class="mb-3">
                                <label>Image</label>
                                <a href="${baseUrl}/files/post/${post.image}" target="_blank">
                                    <img src="${baseUrl}/files/post/${post.image}" alt="${post.title}" class="img-fluid">
                                </a>
                            </div>

                            <div class="mb-3"><br>
                                <label class="youtubeUrl">Video : </label>
                                <iframe width="500" height="400"
                                        src="https://www.youtube.com/embed/${post.youtubeUrl}">
                                </iframe>
                            </div><br>

                            <div class="mb-3">
                                <label class="">Blog Url : </label>
                                <a href="${post.blogUrl}" target="_blank">${post.blogUrl}</a>
                            </div>

                            <div class="mb-3">
                                <label>Document</label>
                            </div>

                            <div class="mb-3">
                                    <label>Status : </label> ${post.status ? "Active" : "In-active"}
                            </div>
                        </div><!--//app-card-body-->

                    </div><!--//app-card-->
                </div>
            </div><!--//row-->
            <hr class="my-4">

        </div><!--//container-fluid-->
    </div>
    <!--//app-content-->
