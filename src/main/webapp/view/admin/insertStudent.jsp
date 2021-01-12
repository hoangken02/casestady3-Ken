<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Index</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../data/plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../data/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../../data/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../data/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="controller_admin.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Create New Student</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="adminIndex.jsp">Home</a></li>
                                <li class="breadcrumb-item active">Create New Student</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <c:out value="${message}"/>
                                    <form action="/admin?action=insertStudent" class="was-validated" method="post">
                                        <div class="form-group">
                                            <label for="firstname">FirstName:</label>
                                            <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname" required autofocus>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="lastname">LastName:</label>
                                            <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname" required autofocus>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email:</label>
                                            <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required autofocus>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="phoneNumber">Phone number:</label>
                                            <input type="text" class="form-control" id="phoneNumber" placeholder="Enter phone number" name="phoneNumber" required autofocus>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="classroomId">Class:</label>
                                            <input type="text" class="form-control" id="classroomId" placeholder="Enter classroomId" name="classroomId" required autofocus>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <div class="form-group">
                                            <select
                                        name="className" id="className">
                                                <c:forEach items="${classrooms}" var="classroom">
                                                    <option value="${classroom.getId}">${classroom.getName()}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="valid-feedback">Valid.</div>
                                            <div class="invalid-feedback">Please fill out this field.</div>
                                        </div>
                                        <button type="submit" class="u-active-palette-2-dark-2 u-black u-btn u-button-style u-hover-palette-2-light-1 u-btn-1">Create New Student</button>
                                    </form>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Lorem ipsum dolor.</b>
        </div>
        <strong>Lorem ipsum dolor <a href="#">Lorem</a></strong> Lorem ipsum dolor.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../../data/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../data/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="../../data/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../data/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../data/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../data/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="../../data/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../data/dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false,
        });
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
</body>
</html>


