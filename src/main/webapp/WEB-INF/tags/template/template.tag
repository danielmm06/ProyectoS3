<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@ attribute name="title" fragment="true" %>
<%@ attribute name="styles" fragment="true" %>
<%@ attribute name="scripts" fragment="true" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="Assets/img/favicon.ico">
	
	<!-- Invoke Title -->
	<title>
		<jsp:invoke fragment="title"/>
	</title>
	<!-- /Invoke Title -->

    <!-- Bootstrap -->
    <link href="Assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="Assets/lib/font-awesome/css/fontawesome-all.min.css" rel="stylesheet">
    <link href="Assets/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- jQuery custom content scroller -->
    <link href="Assets/lib/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet" />
    <!-- Animate.css -->
    <link href="Assets/lib/animate.css/animate.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="Assets/lib/nprogress/nprogress.css" rel="stylesheet">
    
    <link rel="stylesheet" href="Assets/lib/bootstrap-select/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="Assets/lib/jquery-ui/jquery-ui.min.css">

    <!-- Theme Style -->
    <link href="Assets/css/template.css" rel="stylesheet">
    
    <!-- App Style -->
    <link href="Assets/css/app.css" rel="stylesheet">
    <link href="Assets/css/style.css" rel="stylesheet">
    
    <!-- Invoke Styles -->
    <jsp:invoke fragment="styles"/>
	<!-- /Invoke Styles -->
</head>
<body class="nav-md footer_fixed header_fixed">
    <div class="container body">
        <!-- sidebar menu -->
        <aside>
            <div class="col-md-3 left_col menu_fixed">
                <div class="left_col scroll-view">
	                <div class="navbar nav_title">
					    <a class="site_title">
					    	<img src="Assets/img/logo.png"/> 
					    	<span><%= request.getAttribute("title").toString().split(" - ")[0] %></span>
					    </a>
					</div>
					<div class="clearfix"></div>
                	<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                		<!-- Menu -->
                    	<jsp:include page="/WEB-INF/tags/template/sections/menu.jsp" />
                		<!-- /Menu -->
                    </div>
                </div>
            </div>
        </aside>
        <!-- /sidebar menu -->
        <!-- top navigation -->
        <header>
            <div class="top_nav">
                <div class="nav_menu">
                	<!-- Header -->
                    <jsp:include page="/WEB-INF/tags/template/sections/header.jsp" />
                    <!-- /Header -->
                </div>
            </div>
        </header>
        <!-- /top navigation -->
        <!-- page content -->
        <main class="height100">
            <div class="main_container height100">
                <div class="right_col height100" role="main" id="bodyMain" >
                    <div class="height100">
                        <!-- Content -->
                        <jsp:doBody/>
                        <!-- /Content -->
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </main>
        <!-- /page content -->
        <!-- footer content -->
        <footer>
            <!-- Footer -->
            <jsp:include page="/WEB-INF/tags/template/sections/footer.jsp" />
            <!-- /Footer -->
        </footer>
        <!-- /footer content -->
    </div>
	

    <!-- jQuery -->
    <script type="text/javascript" src="Assets/lib/jquery/jquery.min.js" charset="UTF-8"></script>
    <!-- Bootstrap -->
    <script type="text/javascript" src="Assets/lib/bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
    <!-- jQuery custom content scroller -->
    <script type="text/javascript" src="Assets/lib/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js" charset="UTF-8"></script>
    <!-- NProgress -->
    <script type="text/javascript" src="Assets/lib/nprogress/nprogress.js" charset="UTF-8"></script>
    
    <script type="text/javascript" src="Assets/lib/bootstrap-select/js/bootstrap-select.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="Assets/lib/jquery-ui/jquery-ui.min.js" charset="UTF-8"></script>

    <!-- Theme Scripts -->
    <script type="text/javascript" src="Assets/js/template.js" charset="UTF-8"></script>
    
    <!-- App Scripts -->
    <script type="text/javascript" src="Assets/js/app.js" charset="UTF-8"></script>
    <script type="text/javascript" src="Assets/js/script.js" charset="UTF-8"></script>
    
    <!-- Invoke Scripts -->
    <jsp:invoke fragment="scripts"/>
    <!-- /Invoke Scripts -->
</body>
</html>