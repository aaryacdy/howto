<%--
  Created by Aarya Chaudhary
  User: aarya
  Date: 1/19/2022
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<script type="text/javascript">
    $(function () {
        $('.navbar-toggle-sidebar').click(function () {
            $('.navbar-nav').toggleClass('slide-in');
            $('.side-body').toggleClass('body-slide-in');
            $('#search').removeClass('in').addClass('collapse').slideUp(200);
        });

        $('#search-trigger').click(function () {
            $('.navbar-nav').removeClass('slide-in');
            $('.side-body').removeClass('body-slide-in');
            $('.search-input').focus();
        });
    });
</script>
<script src="${baseUrl}/resources/other/admin-dashboard/style/js/jquery.min.js"></script>
<script src="${baseUrl}/resources/other/admin-dashboard/style/js/bootstrap.min.js"></script>
