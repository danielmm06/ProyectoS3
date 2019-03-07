<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Sistema>
	<jsp:attribute name="title">
		<c:out value="${title}" />
    </jsp:attribute>
	<jsp:attribute name="styles">
		<!-- Styles -->
                  <link href="views/Assets/soporte/SoportesIndividual.css" rel="stylesheet" type="text/css">
                    <link href="views/Assets/soporte/template.css" rel="stylesheet" type="text/css">
		<!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
        
        <script src="views/Assets/soporte/SoportesIndividual.js" type="text/javascript"></script>
    	<script src="views/Assets/soporte/jquery.smartWizard.js" type="text/javascript"></script>
		<!-- /Scripts -->
		<script type="text/javascript">

			var goToStep = '<c:out value="${goToStep}"/>'; 
    		
    		
    		
    	</script>
    	<!-- Scripts -->
    	
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
                    <div class="x_content">  
                        <div id="wizard" class="form_wizard wizard_horizontal">
                            <ul class="wizard_steps">
                                    <li>
                                        <a href="#step-1">
                                                <span class="step_no"><strong>1</strong></span>
                                                <span class="step_descr"><strong>Documentos Generales</strong><br/></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#step-2">
                                                <span class="step_no"><strong>2</strong></span>
                                                <span class="step_descr"><strong>Documentación de la Vivienda </strong><br/></span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#step-3">
                                                <span class="step_no"><strong>3</strong></span>
                                                <span class="step_descr"><strong>Dependencia Economica</strong><br/></span>
                                        </a>
                                    </li>	                    					
                            </ul> 




                        </div>
                    </div>
                        

                    
                </div>
            
            
            
            </div>
        </div>
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>