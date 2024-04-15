<%--
  Created by Aarya
  User: aarya
  Date: 3/8/2022
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../layout/dashboard/user/header.jsp" %>
<div class="app-wrapper">
    <div class="app-content pt-3 p-md-3 p-lg-4">
        <div class="container-xl">
            <div class="tab-content" id="orders-table-tab-content">
                <div class="tab-pane fade show active" id="orders-all" role="tabpanel" aria-labelledby="orders-all-tab">
                    <div class="app-card app-card-orders-table shadow-sm mb-5">
                        <div class="app-card-body">
                            <a href="${baseUrl}/post/add" class="btn app-btn-primary ml-2 mt-2">
                                Add
                            </a>

                            ${message}
                            <div class="table-responsive mt-3">
                                <table class="table app-table-hover mb-0 text-left">
                                    <thead>
                                    <tr>
                                        <th class="cell">S.N.</th>
                                        <th class="cell">Title</th>
                                        <th class="cell">Category</th>
                                        <th class="cell">Description</th>
                                        <th class="cell">Image</th>
                                        <th class="cell">Blog Url</th>
                                        <th class="cell">Youtube Url</th>
                                        <th class="cell">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% int index = 1;%>
                                    <c:forEach var="post" items="${posts}">
                                        <tr>
                                            <td class="cell"><%=index++%>.</td>
                                            <td class="cell">${post.title}</td>
                                            <td class="cell">${post.category.name}</td>
                                            <td class="cell">${post.description}</td>
                                                <%--                                            <c:set var="imageSrc" value="${baseUrl}/resources/images/defaultImage.jpg"/>--%>
                                            <c:set var="imageSrc"
                                                   value="${baseUrl}/files/post/${post.image}"/>
                                            <td class="cell"><a href="${imageSrc}" target="_blank">
                                                <image src="${imageSrc}" width="200" height="100"/>
                                            </a></td>
                                            <td class="cell"><a href="${post.blogUrl}"
                                                                target="_blank">${post.blogUrl}</a></td>
                                            <td class="cell">${post.youtubeUrl}</td>
                                            <td>
                                                <a class="" href="${baseUrl}/post/${post.id}" target="_blank">View</a>
                                                <a class="" href="${baseUrl}/post/${post.id}/edit"
                                                   target="_blank">Edit</a>
                                                <a class="" href="${baseUrl}/post/${post.id}/delete">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!--//table-responsive-->
                        </div><!--//app-card-body-->
                    </div><!--//app-card-->
                    <%--<nav class="app-pagination">
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>--%><!--//app-pagination-->
                </div><!--//tab-pane-->
            </div><!--//tab-content-->
        </div><!--//container-fluid-->
    </div><!--//app-content-->

    <%@include file="../layout/dashboard/footer.jsp" %>

