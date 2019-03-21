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
        <script type="text/javascript" src="views/js/admin.js"></script>
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
                    <form id="myform" method="GET" action="evaluarRegistro">
                        <input hidden="" id="doc" name="doc">
                        <h5><label> Aspirantes a la Especialización de Gestion de Proyectos</label></h5>
                        <!--<p> Estudios a nivel de pregrado, postgrado y otros </p>-->
                        <hr>
                        <div class="table-responsive">
                            <table class="table table-bordered text-center" width="100%" cellspacing="0">
                                <thead>
                                    <tr>

                                        <th  class="text-center" style="width: 15%;">Documento</th>
                                        <th  class="text-center" >Aspirante</th>
                                        <th  class="text-center" style="width: 15%;">Estado</th>
                                        <th  class="text-center" style="width: 15%;">Aprobacion</th>
                                        <th  class="text-center" style="width: 10%;">Evaluar</th>

                                    </tr>
                                </thead>

                                <tbody id="cuerpo">


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