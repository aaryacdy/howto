<%--
  Created by Aarya
  User: aarya
  Date: 3/8/2022
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../layout/dashboard/admin-v2/header.jsp" %>
<div class="app-wrapper">

    <div class="app-content pt-3 p-md-3 p-lg-4">
        <div class="container-xl">

            <div class="tab-content" id="orders-table-tab-content">
                <div class="tab-pane fade show active" id="orders-all" role="tabpanel" aria-labelledby="orders-all-tab">
                    <div class="app-card app-card-orders-table shadow-sm mb-5">
                        <div class="app-card-body">
                            ${message}
                            <div class="table-responsive">
                                <table class="table app-table-hover mb-0 text-left">
                                    <thead>
                                    <tr>
                                        <th class="cell">S.N.</th>
                                        <th class="cell">Name</th>
                                        <th class="cell">Username</th>
                                        <th class="cell">Email</th>
                                        <th class="cell">Block</th>
                                        <th class="cell">Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% int index = 1;%>
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td class="cell"><%=index++%>.</td>
                                            <td class="cell">${user.name}</td>
                                            <td class="cell">${user.username}</td>
                                            <td class="cell">${user.email}</td>
                                            <td class="cell">
                                                <c:choose>
                                                    <c:when test="${user.blocked}">
                                                        Blocked
                                                    </c:when>
                                                    <c:otherwise>
                                                        Unblocked
                                                    </c:otherwise>
                                                </c:choose></td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${user.blocked}">
                                                        <a class="" href="${baseUrl}/user/${user.id}/unblock"
                                                           target="_blank">Unblock</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a class="" href="${baseUrl}/user/${user.id}/block"
                                                           target="_blank">Block</a>
                                                    </c:otherwise>
                                                </c:choose>
                                                <%--<a class="" href="${baseUrl}/user/${user.id}/edit"
                                                   target="_blank">Edit</a>--%>
                                                <a class="" href="${baseUrl}/user/${user.id}/delete">Delete</a>

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

