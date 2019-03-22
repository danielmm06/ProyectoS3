

<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Sistema>
    <jsp:attribute name="title">
        <c:out value="${title}" />
    </jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Styles -->
        <!--<link href="views/Assets/soporte/SoportesIndividual.css" rel="stylesheet" type="text/css">-->
        <!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Scripts -->
        <script src="views/Assets/soporte/SoportesIndividual.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <!--<script src="views/Assets/soporte/jquery.smartWizard.js" type="text/javascript"></script>-->
        <!-- /Scripts -->
        <script type="text/javascript">

//            var goToStep = '<c:out value="${goToStep}"/>';



        </script>
    </jsp:attribute>

    <jsp:body>
        <!-- Content -->

        <div class="container-fluid">
            <div class="card mb-3">

                <div class="card-header">                    
                    <h2><i class="fas fa-file-pdf" aria-hidden="true"></i>Soportes Digitales</h2>

                    <h6>Esta sección recoge todos los soportes de los documentos, por tanto deben ser veraces y legibles </h6><hr>                      	                    	

                </div>

                <div class="card-body  mx-auto mt-2">  

                    <h5><label> Comprobante pago de inscripción </label></h5>

                    <form action="Soportes" method="post" id="reciboPublico" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboP" class="form-control" value='<c:if test="${listaPathsNamestmp[0] ne ''}"><c:out value="${listaPathsNamestmp[0]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">		  								
                                            Adjuntar
                                            <input type="file"  name="PAGO" onchange="ReciboPublico(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary" id="enviar" onclick="sendFormReciboPublico(this)">		  								
                                            &nbsp;Enviar&nbsp;		  										  					
                                        </div>

                                    <c:if test="${listaPathsNames[0] ne null}">
                                        <div class="btn btn-success" id="verRECIBOPUBLICO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[0]}"/>')">		   									
                                            Visualizar		   						
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[0] eq null}">
                                        <div class="btn btn-success" id="verRECIBOPUBLICO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[0]}"/>')" style='display: none;' >		   									
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[0] ne null}">					
                                        <div class="btn btn-danger" id="eliminarRECIBOPUBLICO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[0]}"/>', 'reciboP')">			  								
                                            Eliminar     					
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[0] eq null}">					
                                        <div class="btn btn-danger" id="eliminarRECIBOPUBLICO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[0]}"/>', 'reciboP')"  style='display: none;'>			  								
                                            Eliminar    					
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div> <!-- END COL-SM-11 -->
                    </form>
                    <hr>

                    <h5><label> Foto</label></h5>

                    <form action="Soportes"  method="post" id="FormFosyga" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="fosyga" class="form-control" value='<c:if test="${listaPathsNamestmp[1] ne ''}"><c:out value="${listaPathsNamestmp[1]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">		  								
                                            Adjuntar
                                            <input type="file"  name="FOTO" onchange="FoSyga(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary" id="enviar" onclick="sendFormFoSyga(this)">		  								
                                            &nbsp;Enviar&nbsp;		  										  					
                                        </div>
                                    <c:if test="${listaPathsNames[1] ne null}">
                                        <div class="btn btn-success" id="verFOTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[1]}"/>')">		   									
                                            Visualizar		   						
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[1] eq null}">
                                        <div class="btn btn-success" id="verFOTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[1]}"/>')" style='display: none;'>		   									
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[1] ne null}">					
                                        <div class="btn btn-danger" id="eliminarFOTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[1]}"/>', 'fosyga')">			  								
                                            Eliminar     					
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[1] eq null}">					
                                        <div class="btn btn-danger" id="eliminarFOTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[1]}"/>', 'fosyga')" style='display: none;'>			  								
                                            Eliminar    					
                                        </div>
                                    </c:if>	
                                </div>
                            </div>
                        </div>
                    </form>

                    <hr>
                    <h5><label> Diploma de Pregrado</label></h5>


                    <form action="Soportes"  method="post" id="FormCertHijos" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="hijos" class="form-control" value='<c:if test="${listaPathsNamestmp[2] ne ''}"><c:out value="${listaPathsNamestmp[2]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="btn btn-adjuntar btn-file">				  								
                                            Adjuntar
                                            <input type="file" name="DIPLOMA" onchange="CertHijos(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormCertHijos(this)">		  								
                                            &nbsp;Enviar&nbsp;		  										  					
                                        </div>
                                    <c:if test="${listaPathsNames[2] ne null}">
                                        <div class="btn btn-success" id="vercertificadoHijos" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[2]}"/>')">		   									
                                            Visualizar		   						
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[2] eq null}">
                                        <div class="btn btn-success" id="vercertificadoHijos" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[2]}"/>')" style='display: none;'>		   									
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[2] ne null}">					
                                        <div class="btn btn-danger" id="eliminarcertificadoHijos" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[2]}"/>', 'hijos')">			  								
                                            Eliminar     					
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[2] eq null}">					
                                        <div class="btn btn-danger" id="eliminarcertificadoHijos" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[2]}"/>', 'hijos')" style='display: none;' >			  								
                                            Eliminar    					
                                        </div>
                                    </c:if>	
                                </div>
                            </div>
                        </div>
                    </form>



                    <hr> 
                    <h5><label> Acta de grado de Pregrado</label></h5>


                    <form action="Soportes"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI" class="form-control" value='<c:if test="${listaPathsNamestmp[3] ne ''}"><c:out value="${listaPathsNamestmp[3]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="btn btn-adjuntar btn-file">				  								
                                            Adjuntar
                                            <input type="file"  name="PREGRADO" onchange="ReciboImpuesto(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto(this)">		  								
                                            &nbsp;Enviar&nbsp;		  										  					
                                        </div>
                                    <c:if test="${listaPathsNames[3] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                            Visualizar		   						
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[3] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[3]}"/>')"  style='display: none;'>		   									
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[3] ne null}">					
                                        <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')">			  								
                                            Eliminar     					
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[3] eq null}">					
                                        <div class="btn btn-danger" id="eliminarIMPUESTO" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[3]}"/>', 'reciboI')"  style='display: none;'>			  								
                                            Eliminar    					
                                        </div>
                                    </c:if>	
                                </div>
                            </div>
                        </div>
                    </form>	



                    <hr> 
                    <label>  <h5>Resolución - Servicio social obligatorio </h5> -Solo para profesionales en Salud-</label>

                    <form action="Soportes"  method="post" id="reciboImpuesto1" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI1" class="form-control" value='<c:if test="${listaPathsNamestmp[4] ne ''}"><c:out value="${listaPathsNamestmp[4]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">			  								
                                            Adjuntar
                                            <input type="file"  name="RESOLUCION" onchange="ReciboImpuesto1(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto1(this)">		  								
                                            &nbsp;Enviar&nbsp;		  										  					
                                        </div>
                                    <c:if test="${listaPathsNames[4] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[4]}"/>')">		   									
                                            Visualizar		   						
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[4] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[4]}"/>')" style='display: none;'>		   									
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[4] ne null}">					
                                        <div class="btn btn-danger" id="eliminarIMPUESTO1" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[4]}"/>', 'reciboI1')">			  								
                                            Eliminar     					
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[4] eq null}">					
                                        <div class="btn btn-danger" id="eliminarIMPUESTO1" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[4]}"/>', 'reciboI1')"  style='display: none;'>			  								
                                            Eliminar    					
                                        </div>
                                    </c:if>	
                                </div>
                            </div>
                        </div>
                    </form>	

                    <hr> 
                    <h5><label> Fotocopia de cédula ampliada al 150% </label></h5> 

                    <form action="Soportes"  method="post" id="reciboImpuesto2" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI2" class="form-control" value='<c:if test="${listaPathsNamestmp[5] ne ''}"><c:out value="${listaPathsNamestmp[5]}" /></c:if>' placeholder=" Elija archivo..." readonly required/>
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">                                         
                                            Adjuntar
                                            <input type="file"  name="CEDULA" onchange="ReciboImpuesto2(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto2(this)">                                        
                                            &nbsp;Enviar&nbsp;                                                                  
                                        </div>
                                    <c:if test="${listaPathsNames[5] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO2" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[5]}"/>')">                                         
                                            Visualizar                              
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[5] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO2" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[5]}"/>')" style='display: none;'>                                          
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[5] ne null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO2" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[5]}"/>', 'reciboI2')">                                         
                                            Eliminar                        
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[5] eq null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO2" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[5]}"/>', 'reciboI2')"  style='display: none;'>                                         
                                            Eliminar                        
                                        </div>
                                    </c:if> 
                                </div>
                            </div>
                        </div>
                    </form> 
                    <hr> 
                    <h5><label> Certificado EPS</label></h5> 

                    <form action="Soportes"  method="post" id="reciboImpuesto3" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI3" class="form-control" value='<c:if test="${listaPathsNamestmp[6] ne ''}"><c:out value="${listaPathsNamestmp[6]}" /></c:if>' placeholder=" Elija archivo..." readonly />
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">                                         
                                            Adjuntar
                                            <input type="file"  name="EPS" onchange="ReciboImpuesto3(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto3(this)">                                        
                                            &nbsp;Enviar&nbsp;                                                                  
                                        </div>
                                    <c:if test="${listaPathsNames[6] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO3" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[6]}"/>')">                                         
                                            Visualizar                              
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[6] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO3" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[6]}"/>')" style='display: none;'>                                          
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[6] ne null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO3" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[6]}"/>', 'reciboI3')">                                         
                                            Eliminar                        
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[6] eq null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO3" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[6]}"/>', 'reciboI3')"  style='display: none;'>                                         
                                            Eliminar                        
                                        </div>
                                    </c:if> 
                                </div>
                            </div>
                        </div>
                    </form> 
                    <hr> 
                    <label>  <h5>Copia Carné de Egresado </h5>-10% de descuento, si es Egresado-</label> 

                    <form action="Soportes"  method="post" id="reciboImpuesto4" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI4" class="form-control" value='<c:if test="${listaPathsNamestmp[7] ne ''}"><c:out value="${listaPathsNamestmp[7]}" /></c:if>' placeholder=" Elija archivo..." readonly />
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">                                         
                                            Adjuntar
                                            <input type="file"  name="EGRESADO" onchange="ReciboImpuesto4(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto4(this)">                                        
                                            &nbsp;Enviar&nbsp;                                                                  
                                        </div>
                                    <c:if test="${listaPathsNames[7] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO4" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[7]}"/>')">                                         
                                            Visualizar                              
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[7] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO4" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[7]}"/>')" style='display: none;'>                                          
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[7] ne null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO4" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[7]}"/>', 'reciboI4')">                                         
                                            Eliminar                        
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[7] eq null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO4" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[7]}"/>', 'reciboI4')"  style='display: none;'>                                         
                                            Eliminar                        
                                        </div>
                                    </c:if> 
                                </div>
                            </div>
                        </div>
                    </form> 	
                    <hr> 
                    <label><h5> Certificado de votación </h5>-10% de descuento sobre la matricula- </label> 
                    <form action="Soportes"  method="post" id="reciboImpuesto5" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                    <!-- <input type="hidden" value="1" id="cp" name="cp"> -->
                                    <input type="text" id="reciboI5" class="form-control" value='<c:if test="${listaPathsNamestmp[8] ne ''}"><c:out value="${listaPathsNamestmp[8]}" /></c:if>' placeholder=" Elija archivo..." readonly />
                                    </div>
                                    <div class="col-md-8">    
                                        <div class="btn btn-adjuntar btn-file">                                         
                                            Adjuntar
                                            <input type="file"  name="VOTACION" onchange="ReciboImpuesto5(this)" accept=".pdf">
                                        </div>
                                        <div class="btn btn-primary " id="enviar" onclick="sendFormImpuesto5(this)">                                        
                                            &nbsp;Enviar&nbsp;                                                                  
                                        </div>
                                    <c:if test="${listaPathsNames[8] ne null}">
                                        <div class="btn btn-success" id="verIMPUESTO5" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[8]}"/>')">                                         
                                            Visualizar                              
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[8] eq null}">
                                        <div class="btn btn-success" id="verIMPUESTO5" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[8]}"/>')" style='display: none;'>                                          
                                            Visualizar
                                        </div>
                                    </c:if>    
                                    <c:if test="${listaPathsNames[8] ne null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO5" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[8]}"/>', 'reciboI5')">                                         
                                            Eliminar                        
                                        </div>
                                    </c:if>
                                    <c:if test="${listaPathsNames[8] eq null}">                 
                                        <div class="btn btn-danger" id="eliminarIMPUESTO5" onclick="deleteSoporte('<c:out value="${pathDelete}"/><c:out value="${listaPathsNames[8]}"/>', 'reciboI5')"  style='display: none;'>                                         
                                            Eliminar                        
                                        </div>
                                    </c:if> 
                                </div>
                            </div>
                        </div>
                    </form> 
                    <hr> <br>
                    <div class="form-group" id="notasevaluador" <c:out value="${(notas==null)?'hidden':''}"/>>
                        <div class="form-row">
                            <div class="col-md-12">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <label class="input-group-text " for="notas">Observaciones </label>
                                    </div>
                                    <textarea class="form-control letras" id="notas" name="notas" readonly><c:out value="${(notas!=null)?notas:''}"/></textarea>
                                </div>
                            </div>
                           
                        </div>
                        <br>


                    </div>

                    <form action="Login"  method="get" id="general" name="general" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3"></div>

                                <div class="col-md-6">
                                    <input type="button"  id="botonSoporte" name="Submit" class="btn btn-primary btn-lg btn-block"  value="Finalizar" onclick="General2()">

                                </div>
                                <div class="col-md-3"></div>

                            </div>	
                        </div>
                    </form>




                    <!-- END COL XS -->

                </div> <!-- END CLASS CONTAINER -->


            </div> <!-- END ROW PRINCIPAL -->
        </div> <!-- END CLASS CONTAINER -->
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>