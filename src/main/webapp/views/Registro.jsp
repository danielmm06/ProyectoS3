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
            
            
         function otros(sel){
    if (sel.value=="10"){
        document.getElementById('Otrosok').style.display='block';
        document.getElementById('Otrosok').required = true;
    } else {
        document.getElementById('Otrosok').style.display='none';
        document.getElementById('Otrosok').required = false;
        
    }
    }

            
 $("input[name='text']").on("keypress", function(evt) {
     
     
    this.value = this.value.replace(/[^a-zA-Z]/g, ''); 
  }
);
$("#Prestamos").on("keypress", function(evt) {
  var keycode = evt.charCode || evt.keyCode;
  if (keycode == 46 || this.value.length==3) {
    return false;
  }
});

            
$("#ano").on("keypress", function(evt) {
  var keycode = evt.charCode || evt.keyCode;
  if (keycode == 46 || this.value.length==4) {
    return false;
  }
});

$("#mes").on("keypress", function(evt) {
  var keycode = evt.charCode || evt.keyCode;
  if (keycode == 46 || this.value.length==2) {
    return false;
  }
});

$("#dia").on("keypress", function(evt) {
  var keycode = evt.charCode || evt.keyCode;
  if (keycode == 46 || this.value.length==2) {
    return false;
  }
});
    	
    	</script>
		<!-- /Scripts -->
    </jsp:attribute>
    
    <jsp:body>
    	<div class="container-fluid">
            <div class="card mb-3">
            
                <div class="card-header">                    
                    <h2><i class="fa fa-file-alt" aria-hidden="true"></i> Formulario de Registro</h2>
                    
                </div>
                <div class="card-body  mx-auto mt-2">  
                    <form id="myform">
                        <h4><label> Datos Personales</label></h4>
                        <hr>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="text" id="Nombre1" name="text" class="form-control" placeholder="Primer Nombre" required="required" autofocus="autofocus"   pattern="[a-z]{1,15}" title="el nombre debe contener solo letras en minisculas. Ej: camilo">
                                <label for="Nombre1"  >Primer Nombre</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="text" id="Nombre2" name="text" class="form-control" placeholder="Segundo Nombre" required="required" pattern="[a-z]{1,15}" title="el nombre debe contener solo letras en minisculas. Ej: andres">
                                <label for="Nombre2">Segundo Nombre</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="text" id="Apellido1" name="text" class="form-control" placeholder="Primer Apellido" required="required" pattern="[a-z]{1,15}" title="el apellido debe contener solo letras en minisculas. Ej: ramirez">
                                <label for="Apellido1">Primer Apellido</label>
                              </div>
                            </div>
                             <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="text" id="Apellido2"  name="text" class="form-control" placeholder="Segundo Apellido" required="required" pattern="[a-z]{1,15}" title="el apellido debe contener solo letras en minisculas. Ej: rodriguez">
                                <label for="Apellido2">Segundo Apellido</label>
                              </div>
                            </div>  
                              
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-2">
                              
                            </div>
                            <div class="col-md-4">
                              <div class="form-label-group ">
                                <input type="number" id="Documento" class="form-control form-control-sm" placeholder="N° Documento" required="required" >
                                <label for="Documento"  >N° Documento</label>
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="input-group mb-3" style=" height: 34px; ">
                                <div class="input-group-prepend">
                                    <label class="input-group-text " id="inputGroup-sizing-default" for="TipoDocumento"  style=" padding-bottom: 11px; padding-top: 11px; ">Tipo Documento</label>
                                </div>
                                <select class="form-control" id="TipoDocumento" style=" padding-bottom: 11px; padding-top: 11px; height: 48px; " required="required">
                                    <option selected>--</option>
                                    <option value="1">CC</option>
                                    <option value="2">TI</option>
                                    <option value="3">CE</option>
                                    <option value="4">Pasaporte</option>
                                </select>
                               
                              </div>
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
                                <select class="form-control" id="ExpPais" required="required">
                                    <option selected>--</option>
                                    <option value="1">Colombia</option>
                                    <option value="2">Venezuela</option>
                                    <option value="3">Estados Unidos</option>
                                    <option value="4">:v</option>
                                </select>
                                  
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="ExpDepartamento">Departamento</label>
                                </div>
                                <select class="form-control" id="ExpDepartamento" required="required">
                                    <option selected>--</option>
                                    <option value="1">Meta</option>
                                    <option value="2">Arauca</option>
                                    <option value="3">Antioquia</option>
                                    <option value="4">Amazonas</option>
                                </select>
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="ExpCiudad">Ciudad</label>
                                </div>
                                <select class="form-control" id="ExpCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">Villavicencio</option>
                                    <option value="2">Cali</option>
                                    <option value="3">Medellin</option>
                                    <option value="4">Bogota</option>
                                </select>
                               
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            
                            <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="text" id="Direccion" class="form-control" placeholder="Direccion" required="required" >
                                <label for="Direccion"  >Dirección</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                             <div class="form-label-group">
                                <input type="text" id="Barrio" class="form-control" placeholder="Barrio" required="required" >
                                <label for="Barrio">  Barrio</label>
                              </div>
                            </div>
                            <div class="col-md-2">
                              <div class="form-label-group">
                                <input type="number" id="Celular" class="form-control" placeholder="Celular"  >
                                <label for="Celular"  >Celular</label>
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-label-group">
                                <input type="email" id="Correo" class="form-control" placeholder="Correo" required="required" >
                                <label for="Correo"  >Correo</label>
                              </div>
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
                                <select class="form-control" id="ResPais" required="required">
                                    <option selected>--</option>
                                    <option value="1">Colombia</option>
                                    <option value="2">Venezuela</option>
                                    <option value="3">Estados Unidos</option>
                                    <option value="4">:v</option>
                                </select>
                                  
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="ResDepartamento">Departamento</label>
                                </div>
                                <select class="form-control" id="ResDepartamento" required="required">
                                    <option selected>--</option>
                                    <option value="1">Meta</option>
                                    <option value="2">Arauca</option>
                                    <option value="3">Antioquia</option>
                                    <option value="4">Amazonas</option>
                                </select>
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="ResCiudad">Ciudad</label>
                                </div>
                                <select class="form-control" id="ResCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">Villavicencio</option>
                                    <option value="2">Cali</option>
                                    <option value="3">Medellin</option>
                                    <option value="4">Bogota</option>
                                </select>
                               
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            
                            <div class="col-md-4">
                              <div class="form-label-group">
                                <input type="text" id="OfiDireccion" class="form-control" placeholder="OfiDireccion" required="required" >
                                <label for="OfiDireccion"  >Dirección Oficina</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                             <div class="form-label-group">
                                <input type="number" id="OfiTelefono" class="form-control" placeholder="OfiTelefono" required="required" >
                                <label for="OfiTelefono"> Telefono</label>
                              </div>
                            </div>
                            <div class="col-md-2">
                              <div class="form-label-group">
                                <input type="text" id="Fax" class="form-control" placeholder="Fax"  >
                                <label for="Fax"  >Fax</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="form-label-group">
                                <input type="number" id="OfiCelular" class="form-control" placeholder="OfiCelular" required="required" >
                                <label for="OfiCelular"  >Celular</label>
                              </div>
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
                                <select class="form-control" id="OfiPais" required="required">
                                    <option selected>--</option>
                                    <option value="1">Colombia</option>
                                    <option value="2">Venezuela</option>
                                    <option value="3">Estados Unidos</option>
                                    <option value="4">:v</option>
                                </select>
                                  
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="OfiDepartamento">Departamento</label>
                                </div>
                                <select class="form-control" id="OfiDepartamento" required="required">
                                    <option selected>--</option>
                                    <option value="1">Meta</option>
                                    <option value="2">Arauca</option>
                                    <option value="3">Antioquia</option>
                                    <option value="4">Amazonas</option>
                                </select>
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="OfiCiudad">Ciudad</label>
                                </div>
                                <select class="form-control" id="OfiCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">Villavicencio</option>
                                    <option value="2">Cali</option>
                                    <option value="3">Medellin</option>
                                    <option value="4">Bogota</option>
                                </select>
                               
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-8">
                              <div class="input-group mx-3">
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="Nacimiento">Fecha Nacimiento</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="number" class="form-control" id="ano" placeholder="Año" required="required"  required pattern="[0-9]{4}"  min="1950" max="2009" onfocusout="if(this.value>2009){this.value='2009';}else if(this.value<1950){this.value='1950';}">
                                    <label for="ano"  >Año</label>
                                    


                                </div>
                                <div class="form-label-group">
                                    <input type="number" id="mes" class="form-control" placeholder="Mes" required="required"  min="1" max="12" onfocusout="if(this.value>12){this.value='12';}else if(this.value<1){this.value='1';}">
                                    <label for="mes"  >Mes</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="number" id="dia" class="form-control" placeholder="Dia" required="required"  min="1" max="31" onfocusout="if(this.value>31){this.value='31';}else if(this.value<1){this.value='1';}">
                                    <label for="dia"  >Dia</label>
                                </div>
                               
                               
                              </div>
                              <div class="col-md-2">
                            </div>
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
                                <select class="form-control" id="NacPais" required="required">
                                    <option selected>--</option>
                                    <option value="1">Colombia</option>
                                    <option value="2">Venezuela</option>
                                    <option value="3">Estados Unidos</option>
                                    <option value="4">:v</option>
                                </select>
                                  
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="NacDepartamento">Departamento</label>
                                </div>
                                <select class="form-control" id="NacDepartamento" required="required">
                                    <option selected>--</option>
                                    <option value="1">Meta</option>
                                    <option value="2">Arauca</option>
                                    <option value="3">Antioquia</option>
                                    <option value="4">Amazonas</option>
                                </select>
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="NacCiudad">Ciudad</label>
                                </div>
                                <select class="form-control" id="NacCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">Villavicencio</option>
                                    <option value="2">Cali</option>
                                    <option value="3">Medellin</option>
                                    <option value="4">Bogota</option>
                                </select>
                               
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-4">
                              <div class="input-group">
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="Sexo">Sexo</label>
                                </div>
                                <select class="form-control" id="Sexo" required="required">
                                    <option selected>--</option>
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                   
                                </select>
                              </div>
                            </div>
                            <div class="col-md-5">
                              <div class="input-group">
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="Estado">Estado Civil</label>
                                </div>
                                <select class="form-control" id="Estado" required="required">
                                    <option selected>--</option>
                                    <option value="1">Soltero</option>
                                    <option value="2">Casado</option>
                                    <option value="3">Unión Libre</option>
                                    <option value="4">Separado</option>
                                    <option value="5">Viudo</option>
                                    <option value="6">Religioso</option>
                                    <option value="7">Madre Soltera</option>
                                </select>
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="input-group">
                                
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="ResCiudad">Estrato</label>
                                </div>
                                <select class="form-control" id="ResCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">0</option>
                                    <option value="2">1</option>
                                    <option value="3">1-1/2</option>
                                    <option value="4">2</option>
                                    <option value="5">2-1/2</option>
                                    <option value="6">3</option>
                                    <option value="7">3-1/2</option>
                                    <option value="8">4</option>
                                    <option value="9">4-1/2</option>
                                    <option value="10">5</option>
                                    <option value="11">5-1/2</option>
                                    <option value="12">6</option>
                                </select>
                               
                              </div>
                             
                            </div>
                          </div>
                        </div>
                        
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
                                  <td  contenteditable="true"></td>
                                  <td  contenteditable="true"></td>
                                  <td  contenteditable="true"></td>
                                  <td contenteditable="true">  </td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
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
                              <div class="form-label-group">
                                <input type="text" id="Empresa" class="form-control" placeholder="Empresa" required="required" >
                                <label for="Empresa"  >Nombre Empresa</label>
                              </div>
                            </div>
                            <div class="col-md-3">
                              <div class="input-group mb-3" style=" height: 34px; ">
                                <div class="input-group-prepend">
                                    <label class="input-group-text " id="inputGroup-sizing-default" for="TipoEmpresa"  style=" padding-bottom: 11px; padding-top: 11px; ">Tipo</label>
                                </div>
                                <select class="form-control" id="TipoEmpresa" style=" padding-bottom: 11px; padding-top: 11px; height: 48px; " required="required">
                                    <option selected>--</option>
                                    <option value="1">Publica</option>
                                    <option value="2">Privada</option>
                                    
                                </select>
                               
                              </div>
                            </div>
                            <div class="col-md-5">
                              <div class="form-label-group">
                                <input type="text"  name="text" id="Cargo" class="form-control" placeholder="Cargo"  >
                                <label for="Cargo"  >Cargo</label>
                              </div>
                            </div>
                            
                           
                            
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            
                            
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-4">
                              <div class="form-label-group">
                                <input type="text" id="EmpDireccion" class="form-control" placeholder="Direccion" required="required" >
                                <label for="EmpDireccion"  >Dirección</label>
                              </div>
                            </div>
                            <div class="col-md-4">
                              <div class="form-label-group">
                                <input type="number" id="EmpTelefono" class="form-control" placeholder="Telefono"  >
                                <label for="EmpTelefono"  >Telefono</label>
                              </div>
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
                                <select class="form-control" id="EmpPais" required="required">
                                    <option selected>--</option>
                                    <option value="1">Colombia</option>
                                    <option value="2">Venezuela</option>
                                    <option value="3">Estados Unidos</option>
                                    <option value="4">:v</option>
                                </select>
                                  
                                <div class="input-group-prepend">
                                    
                                    <label class="input-group-text " for="ResDepartamento">Departamento</label>
                                </div>
                                <select class="form-control" id="EmpDepartamento" required="required">
                                    <option selected>--</option>
                                    <option value="1">Meta</option>
                                    <option value="2">Arauca</option>
                                    <option value="3">Antioquia</option>
                                    <option value="4">Amazonas</option>
                                </select>
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="ResCiudad">Ciudad</label>
                                </div>
                                <select class="form-control" id="EmpCiudad" required="required">
                                    <option selected>--</option>
                                    <option value="1">Villavicencio</option>
                                    <option value="2">Cali</option>
                                    <option value="3">Medellin</option>
                                    <option value="4">Bogota</option>
                                </select>
                               
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-12">
                              <div class="input-group">
                                <div class="input-group-prepend">
                                    <label class="input-group-text " for="Conocimiento">¿Cómo obtuvo conocimiento de la existencia de este programa?</label>
                                </div>
                                <select class="form-control" id="Conocimiento" name="Conocimiento" required="required"  onclick="otros(this)">
                                    <option selected>--</option>
                                    <option value="1">Folleto</option>
                                    <option value="2">Ventanilla</option>
                                    <option value="3">Fax</option>
                                    <option value="4">Internet</option>
                                    <option value="5">Familiar</option>
                                    <option value="6">Amigo</option>
                                    <option value="7">Empresa</option>
                                    <option value="8">Aviso de Prensa</option>
                                    <option value="9">Promoción Universitaria</option>
                                    <option value="10"  >Otros   </option>
                                </select>
                                   <input type="text" id="Otrosok" style="display:none;" class="form-control" placeholder="¿Cuales?"  autofocus="autofocus">
                                      
                              </div>
                            </div>
                          </div>
                        </div>
                        
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
                                <textarea class="form-control" id="funciones"   required="required"></textarea>
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
                                  <td  contenteditable="true"></td>
                                  <td  contenteditable="true"></td>
                                  <td  contenteditable="true"></td>
                                  <td  contenteditable="true"></td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                </tr>
                                <tr>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
                                  <td contenteditable="true"></td>
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
                                    <select class="form-control" id="EspComprende"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                               </div>
                               <div class="col-md-3">
                                    <select class="form-control" id="EspHabla"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                                   
                               </div>
                               <div class="col-md-3">
                                    <select class="form-control" id="EspEscribe"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
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
                                   <select class="form-control" id="IngComprende"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                               </div>
                               <div class="col-md-3">
                                   <select class="form-control" id="IngHabla"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                                   
                               </div>
                               <div class="col-md-3">
                                     <select class="form-control" id="IngEscribe"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
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
                                   <select class="form-control" id="FranComprende"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                               </div>
                               <div class="col-md-3">
                                    <select class="form-control" id="FranHabla"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                               </div>
                               <div class="col-md-3">
                                    <select class="form-control" id="FranEscribe"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
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
                                       <input type="text" id="otroIdioma" class="form-control" placeholder="¿Cual?" required="required">
                                   
                                       
                                   </div>
                                   
                               </div>
                               <div class="col-md-3">
                                    <select class="form-control" id="otroComprende"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                                   
                               </div>
                               <div class="col-md-3">
                                   <select class="form-control" id="otroHabla"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
                                     </select>
                                   
                                   
                               </div>
                               <div class="col-md-3">
                                   <select class="form-control" id="otroEscribe"  required="required"  >
                                        <option selected>--</option>
                                        <option value="1">Muy Bien</option>
                                        <option value="2">Bien</option>
                                        <option value="3">Regular</option>
                                        <option value="4">Mal</option>

                                  
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
                                
                                <textarea class="form-control" id="razones"   required="required"></textarea>
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
                                    <input type="number" id="Prestamo"  class="form-control" placeholder=""  min="0" max="100" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
                                    <div class="input-group-append">
                                         <span class="input-group-text" >%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                         <label for="Prestamo" class="input-group-text" >Auxilio Empresarial</label>
                                    </div>
                                    <input type="number" id="AuxEmp"  class="form-control" placeholder=""  min="0" max="100" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                                         <label for="Prestamo" class="input-group-text" >Recursos Propios</label>
                                    </div>
                                    <input type="number" id="Recursos"  class="form-control" placeholder=""  min="0" max="100" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
                                    <div class="input-group-append">
                                         <span class="input-group-text" >%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                         <label for="Prestamo" class="input-group-text" >Beca</label>
                                    </div>
                                    <input type="number" id="Beca"  class="form-control" placeholder=""  min="0" max="100" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                          <div class="form-label-group">
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required">
                            <label for="inputEmail">Email address</label>
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-6">
                              <div class="form-label-group">
                                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                                <label for="inputPassword">Password</label>
                              </div>
                            </div>
                            <div class="col-md-6">
                              <div class="form-label-group">
                                <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                                <label for="confirmPassword">Confirm password</label>
                              </div>
                            </div>
                          </div>
                        </div>
                        <a class="btn btn-primary btn-block" href="login.html">Register</a>
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