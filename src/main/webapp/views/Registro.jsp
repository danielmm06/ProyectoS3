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
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="views/js/formulario.js"></script>
        <!-- /Scripts -->
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="card mb-3">
                <div id="info" hidden>${formulario}</div>
                <div class="card-header">                    
                    <h2><i class="fa fa-file-alt" aria-hidden="true"></i> Formulario de Registro</h2>

                </div>
                <div class="card-body  mx-auto mt-2">  
                    <form id="myform" method="POST" action="Formulario">
                        <div class="form-group" style='display: none;'>
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="Categoria"  >Categoria</label>
                                    <select class="form-control" id="Categoria" name="Categoria" required="required"   >
                                        <option value="" >--</option>
                                        <option value="1" selected>Especialización</option>
                                        <option value="2">Maestría</option>
                                        <option value="3">Doctorado</option>

                                    </select>

                                </div>
                                <div class="col-md-4">
                                    <label for="Programa">Programa al que se inscrbe</label>
                                    <input type="text" id="Programa" name="Programa" class="form-control letras" placeholder="Programa Inscripción" required="required" value="Gestion de Proyectos" >


                                </div>
                                <div class="col-md-5">
                                    <label for="Facultad">Perteneciente a la facultad</label>
                                    <input type="text" id="Facultad" name="Facultad" class="form-control letras" placeholder="Facultad" required="required" value="FCE" >


                                </div>


                            </div>
                        </div>
<!--                        <hr> <br>-->

                        <h4><label> Datos Personales</label></h4>
                        <hr>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label for="Nombre1"  >Primer Nombre</label>
                                    <input type="text" id="Nombre1" name="Nombre1" class="form-control letras" placeholder="Primer Nombre" required="required" value="${persona.nombre1}" autofocus="autofocus">


                                </div>
                                <div class="col-md-3">
                                    <label for="Nombre2">Segundo Nombre</label>
                                    <input type="text" id="Nombre2" name="Nombre2" class="form-control letras" placeholder="Segundo Nombre" required="required" value="${persona.nombre2}">


                                </div>
                                <div class="col-md-3">
                                    <label for="Apellido1">Primer Apellido</label>
                                    <input type="text" id="Apellido1" name="Apellido1" class="form-control letras" placeholder="Primer Apellido" required="required" value="${persona.apellido1}">


                                </div>
                                <div class="col-md-3">
                                    <label for="Apellido2">Segundo Apellido</label>
                                    <input type="text" id="Apellido2"  name="Apellido2" class="form-control letras" placeholder="Segundo Apellido" required="required" value="${persona.apellido2}">


                                </div>  

                            </div>
                        </div>
                        <hr> <br>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-2">

                                </div>
                                <div class="col-md-4">
                                    <label for="Documento"  >N° Documento</label>

                                    <input type="text" id="Documento" name="Documento" class="form-control numeros" placeholder="N° Documento" required="required" value="${persona.documento}">


                                </div>
                                <div class="col-md-4">
                                    <label  id="inputGroup-sizing-default" for="TipoDocumento"  >Tipo Documento</label>


                                    <select class="form-control " id="TipoDocumento" name="TipoDocumento" required="required">
                                        <option value="" selected>--</option>
                                        <option value="1">CC</option>
                                        <option value="2">TI</option>
                                        <option value="3">CE</option>
                                        <option value="4">Pasaporte</option>
                                    </select>


                                </div>
                                <div class="col-md-2">


                                </div>

                            </div>
                        </div>



                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Expedicion">Expedición</label>
                                            <label class="input-group-text " for="ExpPais">Pais</label>
                                        </div>
                                        <select class="form-control pais" id="ExpPais" name="ExpPais" required="required">
                                            <option selected value="">Seleccione el Pais</option>
                                            <c:forEach items="${listaPais}" var="ExpPais"> 
                                                <option  value="<c:out value="${ExpPais.idPais}" />" ><c:out value="${ExpPais.nombrePais}" /></option>
                                            </c:forEach>  
                                        </select>

                                        <div class="input-group-prepend">

                                            <label class="input-group-text " for="ExpDepartamento">Departamento</label>
                                        </div>
                                        <select class="form-control departamento" id="ExpDepartamento" name="ExpDepartamento" required="required">
                                            <option selected value="">Seleccione el Departamento</option>
                                        </select>

                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="ExpCiudad">Ciudad</label>
                                        </div>

                                        <select class="form-control" id="ExpCiudad" name="ExpCiudad" required="required">
                                            <option selected value="">Seleccione la Ciudad</option>

                                        </select>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr><br>
                        <div class="form-group">
                            <div class="form-row">

                                <div class="col-md-3">

                                    <label for="Direccion"  >Dirección</label>
                                    <input type="text" id="Direccion" name="Direccion" class="form-control lenum" placeholder="Direccion" required="required" value="${persona.direccion}">


                                </div>
                                <div class="col-md-3">

                                    <label for="Barrio">  Barrio</label>
                                    <input type="text" id="Barrio" name="Barrio" class="form-control lenum" placeholder="Barrio" required="required" value="${persona.barrio}">


                                </div>
                                <div class="col-md-2">

                                    <label for="Celular"  >Celular</label>
                                    <input type="text" id="Celular" name="Celular" class="form-control numeros" placeholder="Celular" value="${persona.telefono}">


                                </div>
                                <div class="col-md-4">

                                    <label for="Correo" >Correo</label>
                                    <input type="email" id="Correo" name="Correo" class="form-control correo" placeholder="Correo" required="required" value="${persona.email}">


                                </div>


                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Residencia">Residencia</label>
                                            <label class="input-group-text " for="ResPais">Pais</label>
                                        </div>
                                        <select class="form-control pais" id="ResPais" name="ResPais" required="required">
                                            <option selected value="">Seleccione el Pais</option>
                                            <c:forEach items="${listaPais}" var="ResPais"> 
                                                <option  value="<c:out value="${ResPais.idPais}" />" ><c:out value="${ResPais.nombrePais}" /></option>
                                            </c:forEach> 
                                        </select>

                                        <div class="input-group-prepend">

                                            <label class="input-group-text " for="ResDepartamento">Departamento</label>
                                        </div>
                                        <select class="form-control departamento" id="ResDepartamento" name="ResDepartamento" required="required">
                                            <option selected value="">Seleccione el Departamento</option>
                                        </select>
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="ResCiudad">Ciudad</label>
                                        </div>
                                        <select class="form-control" id="ResCiudad" name="ResCiudad" required="required">
                                            <option selected value="">Seleccione la Ciudad</option>
                                        </select>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr><br>
                        <div class="form-group">
                            <div class="form-row">

                                <div class="col-md-4">

                                    <label for="OfiDireccion"  >Dirección Oficina</label>
                                    <input type="text" id="OfiDireccion" name="OfiDireccion" class="form-control lenum" placeholder="OfiDireccion" value="${persona.direccionOfic}">


                                </div>
                                <div class="col-md-3">

                                    <label for="OfiTelefono"> Telefono</label>
                                    <input type="text" id="OfiTelefono" name="OfiTelefono" class="form-control numeros" placeholder="OfiTelefono" value="${persona.telefonoOfic}">


                                </div>
                                <div class="col-md-2">
                                    <label for="Fax"  >Fax</label>
                                    <input type="text" id="Fax" name="Fax" class="form-control numeros" placeholder="Fax"  value="${persona.faxOfic}">


                                </div>
                                <div class="col-md-3">
                                    <label for="OfiCelular"  >Celular</label>
                                    <input type="text" id="OfiCelular" name="OfiCelular" class="form-control numeros" placeholder="OfiCelular" value="${persona.celularOfic}">


                                </div>


                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Oficina">Oficina</label>
                                            <label class="input-group-text " for="OfiPais">Pais</label>
                                        </div>
                                        <select class="form-control pais" id="OfiPais" name="OfiPais">
                                            <option selected value="">Seleccione el Pais</option>
                                            <c:forEach items="${listaPais}" var="OfiPais"> 
                                                <option  value="<c:out value="${OfiPais.idPais}" />" ><c:out value="${OfiPais.nombrePais}" /></option>
                                            </c:forEach> 
                                        </select>

                                        <div class="input-group-prepend">

                                            <label class="input-group-text " for="OfiDepartamento">Departamento</label>
                                        </div>
                                        <select class="form-control departamento" id="OfiDepartamento" name="OfiDepartamento">
                                            <option selected value="">Seleccione el Departamento</option>
                                        </select>
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="OfiCiudad">Ciudad</label>
                                        </div>
                                        <select class="form-control" id="OfiCiudad" name="OfiCiudad">
                                            <option selected value="">Seleccione la Ciudad</option>
                                        </select>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr><br>
                        <strong> <p> Fecha de Nacimiento</p> </strong>
                        <div class="form-group">
                            <div class="form-row">

                                <div class="col-md-4">
                                    <label for="ano"  >Año</label>
                                    <input type="text" class="form-control numeros" id="ano" name="ano" placeholder="Año" required="required"  maxlength="4" required pattern="[0-9]{4}"  onfocusout="if(this.value>2009){this.value='2009';}else if(this.value<1950){this.value='1950';}">

                                </div>
                                <div class="col-md-4">

                                    <label for="mes"  >Mes</label>
                                    <input type="text" id="mes" name="mes" class="form-control numeros" placeholder="Mes" maxlength="2" required="required"   onfocusout="if(this.value>12){this.value='12';}else if(this.value<1){this.value='1';}">


                                </div>
                                <div class="col-md-4">

                                    <label for="dia"  >Dia</label>
                                    <input type="text" id="dia" name="dia" class="form-control numeros" placeholder="Dia" required="required"  maxlength="2" onfocusout="if(this.value>31){this.value='31';}else if(this.value<1){this.value='1';}">
                                </div>  
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Nacimiento">Nacimiento</label>
                                            <label class="input-group-text " for="NacPais">Pais</label>
                                        </div>
                                        <select class="form-control pais" id="NacPais" name="NacPais" required="required">
                                            <option selected value="">Seleccione el Pais</option>
                                            <c:forEach items="${listaPais}" var="NacPais"> 
                                                <option  value="<c:out value="${NacPais.idPais}" />" ><c:out value="${NacPais.nombrePais}" /></option>
                                            </c:forEach> 
                                        </select>

                                        <div class="input-group-prepend">

                                            <label class="input-group-text " for="NacDepartamento">Departamento</label>
                                        </div>
                                        <select class="form-control departamento" id="NacDepartamento" name="NacDepartamento" required="required">
                                            <option selected value="">Seleccione el Departamento</option>
                                        </select>
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="NacCiudad">Ciudad</label>
                                        </div>
                                        <select class="form-control" id="NacCiudad" name="NacCiudad" required="required">
                                            <option selected value="">Seleccione la Ciudad</option>
                                        </select>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">



                                    <label  for="Sexo">Sexo</label>

                                    <select class="form-control" id="Sexo" name="Sexo" required="required">
                                        <option value="" selected>--</option>
                                        <option value="Masculino">Masculino</option>
                                        <option value="Femenino">Femenino</option>

                                    </select>

                                </div>
                                <div class="col-md-5">

                                    <label  for="Estado">Estado Civil</label>

                                    <select class="form-control" id="Estado" name="Estado" required="required">
                                        <option value="" selected>--</option>
                                        <option value="1">Soltero</option>
                                        <option value="2">Casado</option>
                                        <option value="3">Unión Libre</option>
                                        <option value="4">Separado</option>
                                        <option value="5">Viudo</option>
                                        <option value="6">Religioso</option>
                                        <option value="7">Madre Soltera</option>
                                    </select>

                                </div>
                                <div class="col-md-3">



                                    <label  for="Estrato">Estrato</label>

                                    <select class="form-control" id="Estrato" name="Estrato" required="required">
                                        <option value="" selected>--</option>
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                    </select>



                                </div>
                            </div>
                        </div>
                        <hr>
                        <br><br>
                        <h4><label> Información Academica</label></h4>
                        <p> Estudios a nivel de pregrado, postgrado y otros </p>
                        <hr>
                        <div class="table-responsive">
                            <table class="table table-bordered text-center" id="InfoAcademica"  width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th  class="text-center">Universidad</th>
                                        <th  class="text-center">Programa</th>
                                        <th  class="text-center">Titulo Obtenido</th>
                                        <th  class="text-center">Año</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="a11" name="a11" style="outline: none" value="${academica.size()>=1?academica.get(0).universidad:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a12" name="a12" style="outline: none"value="${academica.size()>=1?academica.get(0).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a13" name="a13" style="outline: none"value="${academica.size()>=1?academica.get(0).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid numeros" type="text" id="a14" name="a14" maxlength="4" style="outline: none"value="${academica.size()>=1?academica.get(0).ano:''}"></td>
                                    </tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="a21" name="a21" style="outline: none"value="${academica.size()>=2?academica.get(1).universidad:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a22" name="a22" style="outline: none"value="${academica.size()>=2?academica.get(1).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a23" name="a23" style="outline: none"value="${academica.size()>=2?academica.get(1).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid numeros" type="text" id="a24" name="a24" maxlength="4" style="outline: none"value="${academica.size()>=2?academica.get(1).ano:''}"></td>
                                    </tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="a31" name="a31" style="outline: none"value="${academica.size()>=3?academica.get(2).universidad:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a32" name="a32" style="outline: none"value="${academica.size()>=3?academica.get(2).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a33" name="a33" style="outline: none"value="${academica.size()>=3?academica.get(2).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid numeros" type="text" id="a34" name="a34" maxlength="4" style="outline: none"value="${academica.size()>=3?academica.get(2).ano:''}"></td>
                                    </tr>
                                    <tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="a41" name="a41" style="outline: none" value="${academica.size()>=4?academica.get(3).universidad:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a42" name="a42" style="outline: none" value="${academica.size()>=4?academica.get(3).programa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="a43" name="a43" style="outline: none" value="${academica.size()>=4?academica.get(3).tituloObtenido:''}"></td>
                                        <td><input class="border-0 text-center container-fluid numeros" type="text" id="a44" name="a44" maxlength="4" style="outline: none" value="${academica.size()>=4?academica.get(3).ano:''}"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <br><br>
                        <h4><label> Información Laboral</label></h4>
                        <p> Ocupación Actual </p>
                        <hr>
                        <div class="form-group">
                            <div class="form-row">

                                <div class="col-md-4">
                                    <label for="Empresa"  >Nombre Empresa</label>
                                    <input type="text" id="Empresa" name="Empresa" class="form-control letras" placeholder="Empresa" value="${preguntas.empresa}">


                                </div>
                                <div class="col-md-3">


                                    <label   for="TipoEmpresa" >Tipo Empresa</label>

                                    <select class="form-control " id="TipoEmpresa" name="TipoEmpresa">
                                        <option value="" selected>--</option>
                                        <option value="Publica">Publica</option>
                                        <option value="Privada">Privada</option>

                                    </select>


                                </div>
                                <div class="col-md-5">
                                    <label for="Cargo"  >Cargo</label>
                                    <input type="text" id="Cargo" name="Cargo" class="form-control letras" placeholder="Cargo" value="${preguntas.cargo}">


                                </div>



                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">


                                <div class="col-md-2">
                                </div>
                                <div class="col-md-4">
                                    <label for="EmpDireccion"  >Dirección</label>
                                    <input type="text" id="EmpDireccion" name="EmpDireccion" class="form-control lenum" placeholder="Direccion" value="${preguntas.empDireccion}">


                                </div>
                                <div class="col-md-4">
                                    <label for="EmpTelefono"  >Telefono</label>
                                    <input type="text" id="EmpTelefono" name="EmpTelefono" class="form-control numeros" placeholder="Telefono" value="${preguntas.empTelefono}">


                                </div>
                                <div class="col-md-2">
                                </div>


                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Residencia">Empresa</label>
                                            <label class="input-group-text " for="EmpPais">Pais</label>
                                        </div>
                                        <select class="form-control pais" id="EmpPais" name="EmpPais">
                                            <option selected value="">Seleccione el Pais</option>
                                            <c:forEach items="${listaPais}" var="EmpPais"> 
                                                <option  value="<c:out value="${EmpPais.idPais}" />" ><c:out value="${EmpPais.nombrePais}" /></option>
                                            </c:forEach> 
                                        </select>

                                        <div class="input-group-prepend">

                                            <label class="input-group-text " for="EmpDepartamento">Departamento</label>
                                        </div>
                                        <select class="form-control departamento" id="EmpDepartamento" name="EmpDepartamento" >
                                            <option selected value="">Seleccione el Departamento</option>
                                        </select>
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="EmpCiudad">Ciudad</label>
                                        </div>
                                        <select class="form-control" id="EmpCiudad" name="EmpCiudad">
                                            <option selected value="">Seleccione la Ciudad</option>
                                        </select>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr><br>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Conocimiento">¿Cómo obtuvo conocimiento de la existencia de este programa?</label>
                                        </div>
                                        <select class="form-control" id="Conocimiento" name="Conocimiento" required="required">
                                            <option value="" selected>--</option>
                                            <option value="Folleto">Folleto</option>
                                            <option value="Ventanilla">Ventanilla</option>
                                            <option value="Fax">Fax</option>
                                            <option value="Internet">Internet</option>
                                            <option value="Familiar">Familiar</option>
                                            <option value="Amigo">Amigo</option>
                                            <option value="Empresa">Empresa</option>
                                            <option value="Aviso de Prensa">Aviso de Prensa</option>
                                            <option value="Promoción Universitaria">Promoción Universitaria</option>
                                            <option value="Otros" >Otros   </option>
                                        </select>
                                        <input type="text" id="Otrosok" name="Otrosok" style="display:none;" class="form-control letras" placeholder="¿Cuales?"  >

                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>

                        <br><br>
                        <h4><label> Experiencia laboral Laboral</label></h4>

                        <hr>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="funciones">Funciones</label>
                                        </div>
                                        <textarea class="form-control letras" id="funciones" name="funciones"  required="required">${preguntas.expeLaborFunciones}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <br><p>Describa en orden cronológico, partiendo de su empleo actual, los cargos desempeñados.</p>
                        <div class="table-responsive">
                            <table class="table table-bordered text-center" id="InfoExpLaboral"  width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th  class="text-center">Empresa</th>
                                        <th  class="text-center">Cargo</th>
                                        <th  class="text-center">Desde</th>
                                        <th  class="text-center">Hasta</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="l11" name="l11" style="outline: none" value="${laboral.size()>=1?laboral.get(0).empresa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="l12" name="l12" style="outline: none" value="${laboral.size()>=1?laboral.get(0).cargo:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l13" name="l13" style="outline: none" value="${laboral.size()>=1?laboral.get(0).fechaInicio:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l14" name="l14" style="outline: none" value="${laboral.size()>=1?laboral.get(0).fechaFin:''}"></td>
                                    </tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="l21" name="l21" style="outline: none" value="${laboral.size()>=2?laboral.get(1).empresa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="l22" name="l22" style="outline: none" value="${laboral.size()>=2?laboral.get(1).cargo:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l23" name="l23" style="outline: none" value="${laboral.size()>=2?laboral.get(1).fechaInicio:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l24" name="l24" style="outline: none" value="${laboral.size()>=2?laboral.get(1).fechaFin:''}"></td>
                                    </tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="l31" name="l31" style="outline: none" value="${laboral.size()>=3?laboral.get(2).empresa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="l32" name="l32" style="outline: none" value="${laboral.size()>=3?laboral.get(2).cargo:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l33" name="l33" style="outline: none" value="${laboral.size()>=3?laboral.get(2).fechaInicio:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l34" name="l34" style="outline: none" value="${laboral.size()>=3?laboral.get(2).fechaFin:''}"></td>
                                    </tr>
                                    <tr>
                                    <tr>
                                        <td><input class="border-0 text-center container-fluid tabla letras" type="text" id="l41" name="l41" style="outline: none" value="${laboral.size()>=4?laboral.get(3).empresa:''}"></td>
                                        <td><input class="border-0 text-center container-fluid letras" type="text" id="l42" name="l42" style="outline: none" value="${laboral.size()>=4?laboral.get(3).cargo:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l43" name="l43" style="outline: none" value="${laboral.size()>=4?laboral.get(3).fechaInicio:''}"></td>
                                        <td><input class="border-0 text-center container-fluid fechas" type="text" id="l44" name="l44" style="outline: none" value="${laboral.size()>=4?laboral.get(3).fechaFin:''}"></td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <br><br>
                        <h4><label> Conocimiento y manejo de idiomas</label></h4>
                        <hr>

                        <div class="form-group">
                            <div class="form-row">

                                <div class="col-md-3" align="center" >

                                    <label   ><strong>  Idioma </strong></label>


                                </div>
                                <div class="col-md-3" align="center">
                                    <label  > <strong> Comprender al leer </strong></label> 

                                </div>
                                <div class="col-md-3" align="center">

                                    <label   ><strong>  Habla </strong></label> 

                                </div>
                                <div class="col-md-3" align="center">
                                    <label   ><strong>  Escribe </strong></label> 

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3" >

                                    <strong> <label   class="input-group-text ">Español</label></strong>
                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="EspComprende" name="EspComprende" required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="EspHabla" name="EspHabla"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>


                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="EspEscribe" name="EspEscribe" required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <strong> <label   class="input-group-text ">Ingles</label></strong>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="IngComprende" name="IngComprende"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="IngHabla" name="IngHabla" required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>


                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="IngEscribe" name="IngEscribe"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <strong> <label   class="input-group-text ">Frances</label></strong>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="FranComprende" name="FranComprende"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="FranHabla" name="FranHabla"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="FranEscribe" name="FranEscribe"  required="required"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="otroIdioma">Otro</label>
                                        </div>
                                        <input type="text" id="otroIdioma" name="otroIdioma" class="form-control letras" placeholder="¿Cual?" >


                                    </div>

                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="otroComprende" name="otroComprende"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>


                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="otroHabla" name="otroHabla"  >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>


                                </div>
                                <div class="col-md-3">
                                    <select class="form-control" id="otroEscribe" name="otroEscribe" >
                                        <option value="" selected>--</option>
                                        <option value="Muy Bien">Muy Bien</option>
                                        <option value="Bien">Bien</option>
                                        <option value="Regular">Regular</option>
                                        <option value="Mal">Mal</option>


                                    </select>

                                </div>
                            </div>
                        </div>
                        <br>

                        <p> Indique las razones por las que desea realizar este programa.</p>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="input-group">

                                        <textarea class="form-control letras" id="razones" name="razones"  required="required">${preguntas.razones}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <p> Indique la forma como financiara sus estudios</p>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-2">
                                </div>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label for="Prestamo" class="input-group-text" >Prestamos</label>
                                        </div>
                                        <input type="text" id="Prestamo" name="Prestamo"  class="form-control numeros recursos" placeholder=""  maxlength="4" value="${preguntas.finPrestamo}">



                                        <div class="input-group-append">
                                            <span class="input-group-text" >%</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label for="AuxEmp" class="input-group-text" >Auxilio Empresarial</label>
                                        </div>
                                        <input type="text" id="AuxEmp" name="AuxEmp"  class="form-control numeros recursos" placeholder="" maxlength="4" value="${preguntas.finAuxEmpresarial}">



                                        <div class="input-group-append">
                                            <span class="input-group-text" >%</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                </div>


                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-2">
                                </div>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label for="Recursos" class="input-group-text" >Recursos Propios</label>
                                        </div>
                                        <input type="text" id="Recursos" name="Recursos" class="form-control numeros recursos" placeholder=""  maxlength="4" value="${preguntas.finRecPropios}">

                                        <div class="input-group-append">
                                            <span class="input-group-text" >%</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label for="Beca" class="input-group-text" >Beca</label>
                                        </div>
                                        <input type="text" id="Beca" name="Beca" class="form-control numeros recursos" placeholder=""  maxlength="4" value="${preguntas.finBeca}">



                                        <div class="input-group-append">
                                            <span class="input-group-text" >%</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                </div>


                            </div>
                            <hr> <br>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="Egresado">¿Es egresado Unillanos?</label>
                                        </div>
                                        <select class="form-control" id="Egresado" name="Egresado" required="required">
                                            <option value="" selected>--</option>
                                            <option value="Si">Si</option>
                                            <option value="No">No</option>

                                        </select>

                                    </div>
                                    <p> No aplican Convenios U.Nacional-Idead-Ceres-U.Caldas </p>
                                </div>
                                <div class="col-md-3">
                                </div>
                            </div>
                        </div>
                        <hr> <br>
                        <div class="form-group" id="notasevaluador" hidden>
                            <div class="form-row">
                                <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text " for="notas">Notas: </label>
                                        </div>
                                        <textarea class="form-control " id="notas" name="notas"  readonly></textarea>
                                    </div>
                                </div>
                                <div class="col-md-2"></div>
                            </div>
                        <br>
                            
                        
                        </div>
                            







                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-4">
                                </div>
                                <div class="col-md-4">
                                    <input type="submit" id="botonFormulario" name="botonFormulario" class="btn btn-primary btn-lg btn-block" value="Siguiente" >
                                    <!--<a class="btn btn-primary btn-block " href="login.html">Siguiente</a>-->
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </div>

                        <input type="text" id="name" name="name" value="" style="display: none; ">

                    </form>



                </div>
                <div class="card-footer small text-muted">
                    <p style="margin-bottom: 5px;"> 
                        - El valor de la inscripción solo es reembolsable 
                        por circunstancias provenientes de
                        la Universidad. <br>
                        - Para que su inscripción surta efecto, usted deberá cumplir las exigencias del
                        programa al que se inscribe.
                    </p>
                </div>



            </div>
        </div>
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>