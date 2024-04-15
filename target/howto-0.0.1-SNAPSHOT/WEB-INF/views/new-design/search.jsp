<%--
  Created by Aarya
  User: aarya
  Date: 5/29/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${baseUrl}/resources/new-design/search/css/style.css">

</head>
<body>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Search your answer from here.</h2>
                <a href="${baseUrl}/dashboard-v2" class="btn btn-secondary">Back</a>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-5 col-lg-4 d-flex">
                <form action="#" class="search-container">
                    <div class="search-icon-btn">
                        <i class="fa fa-search"></i>
                    </div>
                    <div class="search-input">
                        <input type="search" id="askQuestion" class="search-bar form-control" autocomplete="off"
                               placeholder="Search...">
                    </div>
                </form>
            </div>
        </div>

        <div class="firstTimeShow mt-5">
            <c:if test="${not empty posts}">
                <c:forEach var="post" items="${posts}" varStatus="i">
                    <div style="border-width: thin !important;">
                        <h1 style="text-align: center">${i.index+1}. ${post.title}
                            <c:if test="${not empty post.blogUrl}">
                                <h5 style="text-align: center"><a href="${post.blogUrl}"
                                                                  target="_blank">${post.blogUrl}</a></h5>
                            </c:if>
                        </h1>
                        <br><br>

                        <c:if test="${not empty post.image}">
                            <div style="text-align: center">
                                <a href="${baseUrl}/files/post/${post.image}" target="_blank">
                                    <image src="${baseUrl}/files/post/${post.image}" width="250" height="150"/>
                                </a>
                            </div>
                            <br>
                        </c:if>

                        <c:if test="${not empty post.youtubeUrl}">
                            <div style="text-align: center">
                                <iframe width="500" height="400"
                                        src="https://www.youtube.com/embed/${post.youtubeUrl}">
                                </iframe>
                            </div>
                        </c:if>

                        <div class="description" style="text-align: center;">
                                ${post.description}

                                <%--feedback here--%>
                            <c:set var="hasDataMap" value="${not empty feedbackMap}"/>
                            <c:if test="${hasDataMap}">
                                <c:set var="finalFeedbacks" value="${feedbackMap[post.id]}"/>
                                <c:if test="${not empty finalFeedbacks}">
                                    <label class="font-weight-bold">Previous Feedback</label><br>
                                   <div class="card">
                                       <div class="card-body">
                                           <c:forEach var="finalFeedback" items="${finalFeedbacks}">
                                               ${finalFeedback.feedback}
                                               <br>
                                           </c:forEach>
                                       </div>
                                   </div>
                                    <br>
                                </c:if>

                            </c:if>

                            <div class="row">
                                <div class="col-6">
                                    <textarea type="text" name="feedback" class="form-control"
                                              id="postReplyId_${post.id}"
                                              placeholder="Your feedback please"></textarea>
                                </div>

                                <button type="button" class="btn btn-success" onclick="submitFeedback('${post.id}')">
                                    Submit
                                </button>

                            </div>

                        </div>
                        <hr>
                    </div>
                    <br>
                </c:forEach>
            </c:if>
        </div>

        <div class="dynamicContainer" style="display: none"></div>

    </div>
</section>

<script src="${baseUrl}/resources/new-design/search/js/jquery.min.js"></script>
<script src="${baseUrl}/resources/new-design/search/js/popper.js"></script>
<script src="${baseUrl}/resources/new-design/search/js/bootstrap.min.js"></script>
<script src="${baseUrl}/resources/new-design/search/js/main.js"></script>
<script type="text/javascript" src="${baseUrl}/resources/js/ask.js"></script>
<script class="text/javascript">/**/
let baseUrl = "${baseUrl}";
$("#askQuestion").keyup(function (e) {
    if (e.keyCode == '13') {
        searchAnswer();
    }
});
</script>
</body>
</html>

