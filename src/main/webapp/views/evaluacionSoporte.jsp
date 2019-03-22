    

<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Admin>
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
                    <h2><i class="fas fa-file-pdf" aria-hidden="true"></i> Evaluación - Soportes Digitales</h2>

                    <h6>Esta sección recoge todos los soportes de los documentos, por tanto deben ser veraces y legibles </h6><hr>                      	                    	

                </div>

                <div class="card-body  mx-auto mt-2">  



                    <form action="evaluarSoporte" method="post" id="reciboPublico" enctype="multipart/form-data">

                        <div class="form-group">
                            <div class="form-row">


                                <div class="col-md-8">
                                    <h5><label> Comprobante pago de inscripción </label></h5> </div>
                                <div class="col-md-4">    



                                    <div class="btn btn-success" id="verRECIBOPUBLICO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[0]}"/>')">		   									
                                        Visualizar		   						
                                    </div>



                                </div>


                            </div>
                        </div> <!-- END COL-SM-11 -->
                    </form>
                    <hr>



                    <form action="evaluarSoporte"  method="post" id="FormFosyga" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <h5><label> Foto</label></h5></div>
                                <div class="col-md-4">    


                                    <div class="btn btn-success" id="verFOSYGA" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[1]}"/>')">		   									
                                        Visualizar		   						
                                    </div>


                                </div>
                            </div>
                        </div>
                    </form>

                    <hr>



                    <form action="evaluarSoporte"  method="post" id="FormCertHijos" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <h5><label> Diploma de Pregrado</label></h5> </div>
                                <div class="col-md-4">


                                    <div class="btn btn-success" id="vercertificadoHijos" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[2]}"/>')">		   									
                                        Visualizar		   						
                                    </div>



                                </div>
                            </div>
                        </div>
                    </form>



                    <hr> 



                    <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <h5><label> Acta de grado de Pregrado</label></h5> </div>
                                <div class="col-md-4">


                                    <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[3]}"/>')">		   									
                                        Visualizar		   						
                                    </div>



                                </div>
                            </div>
                        </div>
                    </form>	



                    <hr> 
                    <c:if test="${listaPathsNames[4] ne null}">
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label>  <h5>Resolución - Servicio social obligatorio </h5> -Solo para profesionales en Salud-</label>
                                    </div>
                                    <div class="col-md-4">    


                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[4]}"/>')">		   									
                                            Visualizar		   						
                                        </div>




                                    </div>
                                </div>
                            </div>
                            <hr>
                        </form>

                    </c:if>                        

                    <c:if test="${listaPathsNames[4] eq null}">                
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data" style='display: none;'>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label>  <h5>Resolución - Servicio social obligatorio </h5> -Solo para profesionales en Salud-</label>
                                    </div>
                                    <div class="col-md-4">    


                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[4]}"/>')">		   									
                                            Visualizar		   						
                                        </div>



                                    </div>
                                </div>
                            </div>
                            <hr> 
                        </form>	

                    </c:if>  




                    <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <h5><label> Fotocopia de cédula ampliada al 150% </label></h5>  </div>
                                <div class="col-md-4">    


                                    <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[5]}"/>')">		   									
                                        Visualizar		   						
                                    </div>



                                </div>
                            </div>
                        </div>
                    </form>	
                    <hr> 


                    <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <h5><label> Certificado EPS</label></h5>   </div>
                                <div class="col-md-4">


                                    <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[6]}"/>')">		   									
                                        Visualizar		   						
                                    </div>



                                </div>
                            </div>
                        </div>
                    </form>	
                    <hr> 
                    <c:if test="${listaPathsNames[7] ne null}">
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label>  <h5>Copia Carné de Egresado </h5>-10% de descuento, si es Egresado-</label> 
                                    </div>
                                    <div class="col-md-4">


                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[7]}"/>')">		   									
                                            Visualizar		   						
                                        </div>



                                    </div> 
                                </div>
                            </div>
                            <hr>           
                        </form>	
                    </c:if>
                    <c:if test="${listaPathsNames[7] eq null}">
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data" style='display: none;'>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label>  <h5>Copia Carné de Egresado </h5>-10% de descuento, si es Egresado-</label> 
                                    </div>
                                    <div class="col-md-4">



                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[7]}"/>')" >		   									
                                            Visualizar
                                        </div>


                                    </div> 
                                </div>
                            </div>
                            <hr>        
                        </form>	
                    </c:if>  
                    <c:if test="${listaPathsNames[8] ne null}">
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label><h5> Certificado de votación </h5>-10% de descuento sobre la matricula- </label> 
                                    </div>
                                    <div class="col-md-4">


                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[8]}"/>')">		   									
                                            Visualizar		   						
                                        </div>



                                    </div>
                                </div>
                            </div>
                            <hr> 
                        </form>	
                    </c:if>
                    <c:if test="${listaPathsNames[8] eq null}">
                        <form action="evaluarSoporte"  method="post" id="reciboImpuesto" enctype="multipart/form-data" style='display: none;'>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-8">
                                        <label><h5> Certificado de votación </h5>-10% de descuento sobre la matricula- </label> 
                                    </div>
                                    <div class="col-md-4">



                                        <div class="btn btn-success" id="verIMPUESTO" onclick="window.open('Pdf?path=soportes<c:out value="${listaPathsNames[8]}"/>')" >		   									
                                            Visualizar
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </form>	
                    </c:if>                         





                    <!-- END COL XS -->

                </div>
                <div class="card-footer small text-muted">
                    <form action="evaluarSoporte"  method="POST" id="observacion">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="notas2">Observaciones: </label>
                                        </div>
                                        <textarea class="form-control" id="notas2" name="notas2"><c:out value="${(notas!=null)?notas:''}"/></textarea>
                                    </div>
                                    <h6> - No diligenciar este campo, daria por sentado que los soportes fueron subidos correctamente - </h6>
                                </div>
                                <div class="col-md-2"></div>
                            </div>
                        </div>
                        <br>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4">
                                    <input type="submit" id="botonEvaluacion" name="botonEvaluacion" class="btn btn-primary btn-lg btn-block" value="Evaluar" >


                                    <!--<a class="btn btn-primary btn-block " href="login.html">Siguiente</a>-->
                                </div>

                                <div class="col-md-4">
                                </div>
                            </div>

                        </div>
                    </form>
                </div>                <!-- END CLASS CONTAINER -->


            </div> <!-- END ROW PRINCIPAL -->
        </div> <!-- END CLASS CONTAINER -->
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Admin>