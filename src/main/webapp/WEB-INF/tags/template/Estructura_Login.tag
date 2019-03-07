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
  
   <link rel="shortcut icon" href="views/Assets/img/favicon.ico" type="image/x-icon">
   <link rel="icon" href="views/Assets/img/favicon.ico" type="image/x-icon">

    

    

    <!-- Invoke Styles -->
    <jsp:invoke fragment="styles"/>
	<!-- /Invoke Styles -->
</head>
<body class="bg-dark">
   
        <!-- sidebar menu -->
  <div class="container">
        
                 <jsp:doBody/>
            
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