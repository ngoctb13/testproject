<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!-- 
* Bootstrap Simple Admin Template
* Version: 2.1
* Author: Alexis Luna
* Website: https://github.com/alexis-luna/bootstrap-simple-admin-template
-->
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Feedback | Bootstrap Simple Admin Template</title>
        <link href="assets/vendor/fontawesome/css/fontawesome.min.css" rel="stylesheet">
        <link href="assets/vendor/fontawesome/css/solid.min.css" rel="stylesheet">
        <link href="assets/vendor/fontawesome/css/brands.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/datatables/datatables.min.css" rel="stylesheet">
        <link href="assets/css/master.css" rel="stylesheet">
    </head>

    <body>
        <div class="wrapper">
            <!-- sidebar navigation component -->



            <jsp:include page="../admin/layout/sidebar.jsp"/>




            <!-- end of sidebar component -->
            <div id="body" class="active">
                <!-- navbar navigation component -->




                <jsp:include page="../admin/layout/head.jsp"/>



                <!-- end of navbar navigation -->
                <div class="content">
                    <div class="container">
                        <div class="page-title">
                            <h3>Delete Request                
                            </h3>
                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="card">
                                <div class="card-header">Delete Request List</div>
                                <div class="card-body">
                                    <table class="table table-hover" id="dataTables-example" width="100%">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Reason</th>
                                                <th>Email</th>
                                                <th>User ID</th>
                                                <<th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${rqList}" var="r">
                                            <tr>
                                                <td>${r.request_id}</td>
                                                <td>${r.reason}</td>
                                                <td>${r.email}</td>
                                                <td>${r.user_id}</td>
                                                <td><a href="user?action=delete_feedback&id=${f.user_id}" class="btn btn-outline-danger btn-rounded"><i class="fas fa-check-square"></i></a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/datatables/datatables.min.js"></script>
        <script src="assets/js/initiate-datatables.js"></script>
        <script src="assets/js/script.js"></script>
    </body>

</html>