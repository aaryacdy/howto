<%@include file="../layout/dashboard/user/header.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

<div class="app-wrapper">

    <div class="app-content pt-3 p-md-3 p-lg-4">
        <div class="container-xl">
            <h1 class="app-page-title">Post</h1>
            <hr class="mb-4">
            <div class="row g-4 settings-section">
                <div class="col-12 col-md-4">
                    <h3 class="section-title">Edit Post</h3>
                    <div class="section-intro">You can edit post from here.</div>
                </div>
                <div class="col-12 col-md-8">
                    <div class="app-card app-card-settings shadow-sm p-4">
                        <div class="app-card-body">
                            <form action="${baseUrl}/post/${post.id}/update" method="post" id="formEditCategory"
                                  class="settings-form" enctype="multipart/form-data">
                                <input type="hidden" name="id" value="${post.id}">
                                <div class="mb-3">
                                    <label for="title" class="form-label">Title</label>
                                    <input type="text" id="title" name="title" class="form-control"
                                           placeholder="Enter Title.." value="${post.title}" required>
                                </div>

                                <div class="mb-3">
                                    <label for="categoryId" class="form-label">Category</label>
                                    <select class="form-control" name="categoryId" id="categoryId" required>
                                        <option value="">Select</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option ${post.category.id eq category.id ? "selected" : ""}
                                                    value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label for="textEditor" class="form-label">Content</label>
                                    <textarea type="text" id="textEditor" rows="5" name="description"
                                              class="form-control"
                                              placeholder="Enter Content" required>${post.description}</textarea>
                                </div>

                                <c:if test="${not empty post.image}">
                                    <div class="mb-3">
                                        <a href="${baseUrl}/files/post/${post.image}" target="_blank">
                                            <img src="${baseUrl}/files/post/${post.image}" alt="${post.title}" class="img-fluid">
                                        </a>
                                    </div>
                                </c:if>

                                <div class="mb-3">
                                    <label for="image">Image</label>
                                    <input type="file" class="form-control" id="image" name="attachment"
                                           class="img-thumbnail" accept="image/*"
                                           placeholder="Enter image">
                                </div>

                                <div class="mb-3">
                                    <label for="video">Video</label>
                                    <input type="text" class="form-control" id="video" name="youtubeUrl"
                                           placeholder="Enter video url" value="${post.youtubeUrl}"
                                           onchange="getVideoCode(this)">
                                </div>

                                <div class="mb-3">
                                    <label for="video" class="">Blog Url</label>
                                    <input type="text" class="form-control" id="blog" name="blogUrl"
                                           placeholder="Enter blog url">
                                </div>

                                <%--<div class="mb-3">
                                    <label for="document">Document</label>
                                    <input type="file" class="form-control" id="document" name="documentFile"
                                           accept="application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint,
                                         text/plain, application/pdf"
                                           placeholder="Enter document">
                                </div>--%>

                                <div class="mb-3">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="status" value="1"
                                               id="status"
                                               onchange="validateStatus(this)" ${post.status ? "checked" : ""}>
                                        <label class="form-check-label" for="status">
                                            Status
                                        </label>
                                    </div>
                                </div>
                                <button type="submit" class="btn app-btn-primary">Update</button>
                                <a href="${baseUrl}/post" class="btn btn-light">Back</a>
                            </form>
                        </div><!--//app-card-body-->
                    </div><!--//app-card-->
                </div>
            </div><!--//row-->
            <hr class="my-4">
        </div><!--//container-fluid-->
    </div>
    <!--//app-content-->

    <%@include file="../layout/dashboard/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#textEditor').summernote();
        });

        function validateStatus(instance) {
            let isChecked = $(instance).is(":checked");
            $(instance).val(isChecked ? 1 : 0);
        }

        function getVideoCode(instance) {
            let videoUrl = $.trim($(instance).val());
            let code = "";
            if (videoUrl) {
                code = videoUrl.split("v=");
                if (code.length > 1)
                    code = code[1].split("&")[0];
            }
            $("input[name=youtubeUrl]").val(code);
        }
    </script>

