<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="title" fragment="true" %>
<%@ attribute name="styles" fragment="true" %>
<%@ attribute name="scripts" fragment="true" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
	<!-- Invoke Title -->
	<title>
		<jsp:invoke fragment="title"/>
	</title>
	<!-- /Invoke Title -->
<!-- Custom fonts for this template-->
  <link href="views/Assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="views/Assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="views/Assets/css/sb-admin.css" rel="stylesheet">


    

    <!-- Invoke Styles -->
    <jsp:invoke fragment="styles"/>
	<!-- /Invoke Styles -->
</head>
<body id="page-top">
   
        <!-- sidebar menu -->

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            <img src="views/Assets/img/logook.png" style="margin-right: 6px;" > 
            <a class="navbar-brand mr-1" href="index.html"><%= request.getAttribute("title").toString().split(" - ")[0] %></a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
              <i class="fas fa-bars"></i>
            </button>
            
            <jsp:include page="/WEB-INF/tags/template/sections/header.jsp" />

        </nav>

        <div id="wrapper">
            <jsp:include page="/WEB-INF/tags/template/sections/menu.jsp" />
            <div id="content-wrapper">
                 <jsp:doBody/>
             <!-- Sticky Footer -->
              <footer class="sticky-footer">
                <div class="container my-auto">
                  <div class="copyright text-center my-auto">
                    <span>Universidad de los Llanos © Todos los derechos reservados </span>
                  </div>
                </div>
              </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
          <!-- /#wrapper -->

         <!-- Scroll to Top Button-->
          <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
          </a>

          <!-- Logout Modal-->
          <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                  </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                  <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                  <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
              </div>
            </div>
          </div>


    <!-- Bootstrap core JavaScript-->
      <script src="views/Assets/vendor/jquery/jquery.min.js"></script>
      <script src="views/Assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

      <!-- Core plugin JavaScript-->
      <script src="views/Assets/vendor/jquery-easing/jquery.easing.min.js"></script>

      <!-- Page level plugin JavaScript-->
      <script src="views/Assets/vendor/chart.js/Chart.min.js"></script>
      <script src="views/Assets/vendor/datatables/jquery.dataTables.js"></script>
      <script src="views/Assets/vendor/datatables/dataTables.bootstrap4.js"></script>

      <!-- Custom scripts for all pages-->
      <script src="views/Assets/js/sb-admin.min.js"></script>

      <!-- Demo scripts for this page-->
      <script src="views/Assets/js/demo/datatables-demo.js"></script>
      <script src="views/Assets/js/demo/chart-area-demo.js"></script>
      <script src="views/Assets/js/demo/chart-bar-demo.js"></script>
      <script src="views/Assets/js/demo/chart-pie-demo.js"></script>
      <script src="views/Assets/js/template.js"></script>
      <script src="views/Assets/js/app.js"></script>
      
      
     
    <!-- Invoke Scripts -->
    <jsp:invoke fragment="scripts"/>
    <!-- /Invoke Scripts -->
</body>
</html>