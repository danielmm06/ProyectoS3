<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Sistema>
	<jsp:attribute name="title">
		<c:out value="${title}" />
    </jsp:attribute>
	<jsp:attribute name="styles">
		<!-- Styles -->
		<!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
    	<!-- Scripts -->
    	<script type="text/javascript">
    		function myFormFunction() {
    			console.log("myFormFunction.................");
    			return true;
    		}
    	</script>
		<!-- /Scripts -->
    </jsp:attribute>
    
    <jsp:body>
    	<div class="container-fluid">
            <div class="card mb-3">
            
                <div class="card-header">                    
                    <h2><i class="fa fa-file-pdf" aria-hidden="true"></i> Soporte Digitales</h2>
                    <p style="margin-bottom: 2px;">Los campos marcados con <label style="color: red;">(*)</label> son obligatorios.</p> 
                    <h6>Esta sección recoge todos los soportes de los documentos, por tanto deben ser veraces y legibles </h6>                     	                    	

                </div>
                <div class="card-body">  
                   
                        

                    
                </div>
            
            
            
            </div>
        </div>
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>