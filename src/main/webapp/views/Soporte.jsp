

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
        <!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Scripts -->
        <script src="views/Assets/soporte/SoportesIndividual.js" type="text/javascript"></script>
        <script src="views/Assets/soporte/jquery.smartWizard.js" type="text/javascript"></script>
        <!-- /Scripts -->
        <script type="text/javascript">

            var goToStep = '<c:out value="${goToStep}"/>';



        </script>
    </jsp:attribute>

    <jsp:body>
        <!-- Content -->

        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-md-6 col-lg-8 col-lg-offset-2"> 
                    <div class="">                    
                        <h3><i class="fas fa-file-pdf" aria-hidden="true"></i> <strong>SOPORTES DIGITALES</strong></h3>
                        <p>Los campos marcados con <label  style="color: red;">(*)</label> son obligatorios.</p> 
                        <h5>Esta sección recoge todos los soportes de los documentos, por tanto deben ser veraces y legibles </h5><hr>                      	                    	
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">  
                        <div id="wizard" class="form_wizard wizard_horizontal">
                            <!--                            <ul class="wizard_steps">
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
                                                        </ul> -->
                            <div id="step-1" class="col-md-10 col-sm-10 col-xs-12 col-lg-10 col-md-offset-4 col-lg-offset-2">                  		    		
                                <div class="row">
                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>	
                                        <span><strong>COMPROBANTE PAGO DE INSCRIPCIÓN<label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboPublico" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboP" class ="reciboPublico" value='<c:if test="${listaPathsNamestmp[0] ne ''}"><c:out value="${listaPathsNamestmp[0]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOPUBLICO" onchange="ReciboPublico(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormReciboPublico(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[0] ne null}">
                                                <div class="btn btn-success" id="verRECIBOPUBLICO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[0]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[0] eq null}">
                                                <div class="btn btn-success" id="verRECIBOPUBLICO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[0]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[0] ne null}">					
                                                <div class="btn btn-danger" id="eliminarRECIBOPUBLICO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[0]}"/>', 'reciboP')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[0] eq null}">					
                                                <div class="btn btn-danger" id="eliminarRECIBOPUBLICO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[0]}"/>', 'reciboP')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div> <!-- END COL-SM-11 -->

                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">	
                                        <span><strong>FOTO <label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="FormFosyga" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="fosyga" class ="fosyga" value='<c:if test="${listaPathsNamestmp[1] ne ''}"><c:out value="${listaPathsNamestmp[1]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="FOSYGA" onchange="FoSyga(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormFoSyga(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[1] ne null}">
                                                <div class="btn btn-success" id="verFOSYGA" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[1]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[1] eq null}">
                                                <div class="btn btn-success" id="verFOSYGA" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[1]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[1] ne null}">					
                                                <div class="btn btn-danger" id="eliminarFOSYGA" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[1]}"/>', 'fosyga')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[1] eq null}">					
                                                <div class="btn btn-danger" id="eliminarFOSYGA" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[1]}"/>', 'fosyga')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>
                                    </div>

                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">	
                                        <span><strong>DIPLOMA DE PREGRADO <label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="FormCertHijos" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="hijos" class ="hijos" value='<c:if test="${listaPathsNamestmp[2] ne ''}"><c:out value="${listaPathsNamestmp[2]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="HIJOS" onchange="CertHijos(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormCertHijos(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[2] ne null}">
                                                <div class="btn btn-success" id="vercertificadoHijos" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[2]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[2] eq null}">
                                                <div class="btn btn-success" id="vercertificadoHijos" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[2]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[2] ne null}">					
                                                <div class="btn btn-danger" id="eliminarcertificadoHijos" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[2]}"/>', 'hijos')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[2] eq null}">					
                                                <div class="btn btn-danger" id="eliminarcertificadoHijos" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[2]}"/>', 'hijos')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>
                                    </div> <!-- END COL-SM-11 -->



                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>ACTA DE GRADO DE PREGRADO<label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>

                                    <!--toca arreglar de aqui para abajo-->
                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>RESOLUCIÓN SERVICIO SOCIAL OBLIGATORIO (SOLO PARA PROFESIONALES EN SALUD)</strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>

                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>FOTOCOPIA CÉDULA DE CIUDADANÍA ACTUAL AMPLIADA AL 150%<label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>

                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>CERTIFICADO EPS<label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>


                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>COPIA DEL CARNÉ DE EGRESADO PARA EL DESCUENTO 10% SI ES EGRESADO</strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>

                                    <div class="col-sm-11 col-lg-12 col-sm-offset-3 col-lg-offset-0">
                                        <br>
                                        <span><strong>CERTIFICADO DE VOTACIÓN DESCUENTO 10% SOBRE LA MATRICULA<label  style="color: red;">*</label></strong></span><br>
                                        <form action="SoportesIndividual" method="post" id="reciboImpuesto" enctype="multipart/form-data">

                                            <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                            <input type="text" id="reciboI" class ="impuesto" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                                <div class="btn btn-default btn-file">		  								
                                                    <strong style="color: #73879C;">Adjuntar</strong>
                                                    <input type="file" id="btn-file" name="RECIBOIMPUESTO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                                </div>
                                                <div class="btn btn-primary btn-file" id="enviar" onclick="sendFormImpuesto(this)">		  								
                                                    &nbsp;Enviar&nbsp;		  										  					
                                                </div>
                                            <c:if test="${listaPathsNames[3] ne null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                                    Visualizar		   						
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">
                                                <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('ViewFilePDF?path=soportes<c:out value="${listaPathsNames[3]}"/>')" style='pointer-events: none;'>		   									
                                                    Visualizar
                                                </div>
                                            </c:if>    
                                            <c:if test="${listaPathsNames[3] ne null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                                    Eliminar     					
                                                </div>
                                            </c:if>
                                            <c:if test="${listaPathsNames[3] eq null}">					
                                                <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')" style='pointer-events: none;'>			  								
                                                    Eliminar    					
                                                </div>
                                            </c:if>		  				
                                        </form>	
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                    



                                </div> <!-- END COL-SM-11 -->




                                <form action="SoportesIndividual" method="post" id="general" name="general">

                                    <div class="row">
                                        <div class="text-center">
                                            <div class="col-md-12">
                                                <input type="button"  id="Submit" name="Submit" class="btn btn-primary btn-lg "  value="Finalizar carga de Soportes" onclick="General2()" >
                                                <br><br>
                                            </div>

                                        </div>	
                                    </div>
                                </form>




                            </div> <!-- END COL XS -->
                        </div> <!-- END ROW PRINCIPAL -->
                    </div> <!-- END CLASS CONTAINER -->

                </div> <!-- END COL XS -->
            </div> <!-- END ROW PRINCIPAL -->
        </div> <!-- END CLASS CONTAINER -->
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>