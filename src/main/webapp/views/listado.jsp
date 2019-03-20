<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Admin>
    <jsp:attribute name="title">
        <c:out value="${title}" />
    </jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Styles -->
        <!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Scripts -->
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="views/js/formulario.js"></script>
        <!-- /Scripts -->
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="card mb-3">
                <div id="info" hidden>${formulario}</div>
                <div class="card-header">                    
                    <h2><i class="fa fa-file-alt" aria-hidden="true"></i> Listado Aspirantes</h2>

                </div>
                <div class="card-body  mx-auto mt-2">  
                    <form id="myform" method="POST" action="Formulario">
                       
                      
                       
                       
                      
                        <h5><label> Aspirantes a la Especialización de Gestion de Proyectos</label></h5>
                        <!--<p> Estudios a nivel de pregrado, postgrado y otros </p>-->
                        <hr>
                        <div class="table-responsive">
                            <table class="table table-bordered text-center" id="InfoAcademica"  width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                       
                                        <th  class="text-center" style="width: 15%;">Documento</th>
                                        <th  class="text-center">Aspirtante</th>
                                        <th  class="text-center"  style="width: 15%;">Estado</th>
                                        <th  class="text-center" style="width: 15%;">Aprobacion</th>
                                        <th  class="text-center" style="width: 10%;">Evaluar</th>
                                       
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        
                                        <td><input class="border-0 text-center container-fluid numeros" type="text" id="a12" name="a12" style="outline: none"value="${academica.size()>=1?academica.get(0).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a13" name="a13" style="outline: none"value="${academica.size()>=1?academica.get(0).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a14" name="a14"  style="outline: none"value="${academica.size()>=1?academica.get(0).ano:''}"></td>
                                         <td><input class="border-0 text-center container-fluid letras" type="text" id="a14" name="a14"  style="outline: none"value="${academica.size()>=1?academica.get(0).ano:''}"></td>
                              
                                        <td ><div class="btn btn-success "  id="enviar" onclick="sendFormReciboPublico(this)">		  								
                                            &nbsp;Evaluar&nbsp;		  										  					
                                        </div>
                                            </td>
                                           
                                    </tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="a21" name="a21" style="outline: none"value="${academica.size()>=2?academica.get(1).universidad:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a22" name="a22" style="outline: none"value="${academica.size()>=2?academica.get(1).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a23" name="a23" style="outline: none"value="${academica.size()>=2?academica.get(1).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a14" name="a14"  style="outline: none"value="${academica.size()>=1?academica.get(0).ano:''}"></td>
                                       
                                        <td ><div class="btn btn-success "  id="enviar" onclick="sendFormReciboPublico(this)">		  								
                                            &nbsp;Evaluar&nbsp;		  										  					
                                        </div>
                                            </td>
                                            
                                    </tr>
                                   
                                </tbody>
                            </table>
                        </div>

                        







                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4">
                                    <!--<input type="submit" id="botonFormulario" name="botonFormulario" class="btn btn-primary btn-lg btn-block" value="Siguiente" >-->
                                    <!--<a class="btn btn-primary btn-block " href="login.html">Siguiente</a>-->
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </div>

                        <input type="text" id="name" name="name" value="" style="display: none">

                    </form>



                </div>
                <div class="card-footer small text-muted">
                   
                </div>



            </div>
        </div>
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Admin>