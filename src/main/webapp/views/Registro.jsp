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
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-3">
                                <label for="Nombre1"  >Categoria</label>
                                <select class="form-control" id="Categoria" required="required" autofocus="autofocus"  >
                                    <option selected>--</option>
                                    <option value="1">Especialización</option>
                                    <option value="2">Maestría</option>
                                    <option value="3">Doctorado</option>
                                   
                                </select>
                              
                            </div>
                            <div class="col-md-4">
                              <label for="Programa">Programa al que se inscrbe</label>
                                <input type="text" id="Programa" name="text" class="form-control" placeholder="Programa Inscripción" required="required" >
                                
                             
                            </div>
                            <div class="col-md-5">
                             <label for="Facultad">Perteneciente a la facultad</label>
                                <input type="text" id="Facultad" name="text" class="form-control" placeholder="Facultad" required="required" >
                                
                              
                            </div>
                              
                              
                          </div>
                        </div>
                        <hr> <br>
                        
                        <h4><label> Datos Personales</label></h4>
                        <hr>
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-3">
                                <label for="Nombre1"  >Primer Nombre</label>
                                <input type="text" id="Nombre1" name="text" class="form-control" placeholder="Primer Nombre" required="required"  >
                                
                              
                            </div>
                            <div class="col-md-3">
                              <label for="Nombre2">Segundo Nombre</label>
                                <input type="text" id="Nombre2" name="text" class="form-control" placeholder="Segundo Nombre" required="required" >
                                
                             
                            </div>
                            <div class="col-md-3">
                             <label for="Apellido1">Primer Apellido</label>
                                <input type="text" id="Apellido1" name="text" class="form-control" placeholder="Primer Apellido" required="required">
                                
                              
                            </div>
                             <div class="col-md-3">
                             <label for="Apellido2">Segundo Apellido</label>
                                <input type="text" id="Apellido2"  name="text" class="form-control" placeholder="Segundo Apellido" required="required">
                                
                              
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
                              
                                <input type="text" id="Documento" class="form-control " placeholder="N° Documento" required="required" >
                                
                             
                            </div>
                            <div class="col-md-4">
                              <label  id="inputGroup-sizing-default" for="TipoDocumento"  >Tipo Documento</label>
                              
                                
                                <select class="form-control " id="TipoDocumento" required="required">
                                    <option selected>--</option>
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
                        <hr><br>
                        <div class="form-group">
                          <div class="form-row">
                            
                            <div class="col-md-3">
                             
                                  <label for="Direccion"  >Dirección</label>
                                <input type="text" id="Direccion" class="form-control" placeholder="Direccion" required="required" >
                                
                             
                            </div>
                            <div class="col-md-3">
                             
                                 <label for="Barrio">  Barrio</label>
                                <input type="text" id="Barrio" class="form-control" placeholder="Barrio" required="required" >
                                
                              
                            </div>
                            <div class="col-md-2">
                              
                                  <label for="Celular"  >Celular</label>
                                <input type="text" id="Celular" class="form-control" placeholder="Celular"  >
                                
                              
                            </div>
                            <div class="col-md-4">
                              
                                  <label for="Correo" >Correo</label>
                                <input type="email" id="Correo" class="form-control" placeholder="Correo" required="required" >
                                
                              
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
                        <hr><br>
                        <div class="form-group">
                          <div class="form-row">
                            
                            <div class="col-md-4">
                              
                                  <label for="OfiDireccion"  >Dirección Oficina</label>
                                <input type="text" id="OfiDireccion" class="form-control" placeholder="OfiDireccion" required="required" >
                                
                             
                            </div>
                            <div class="col-md-3">
                             
                                  <label for="OfiTelefono"> Telefono</label>
                                <input type="text" id="OfiTelefono" class="form-control" placeholder="OfiTelefono" required="required" >
                               
                              
                            </div>
                            <div class="col-md-2">
                             <label for="Fax"  >Fax</label>
                                <input type="text" id="Fax" class="form-control" placeholder="Fax"  >
                                
                              
                            </div>
                            <div class="col-md-3">
                              <label for="OfiCelular"  >Celular</label>
                                <input type="text" id="OfiCelular" class="form-control" placeholder="OfiCelular" required="required" >
                                
                              
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
                          <hr><br>
                          <strong> <p> Fecha de Nacimiento</p> </strong>
                        <div class="form-group">
                          <div class="form-row">
                              
                              
                            <div class="col-md-4">
                                
                               
                                    <label for="ano"  >Año</label>
                                    <input type="text" class="form-control " id="ano" placeholder="Año" required="required"  maxlength="4" required pattern="[0-9]{4}"  onfocusout="if(this.value>2009){this.value='2009';}else if(this.value<1950){this.value='1950';}">
                                 
                            </div>
                            <div class="col-md-4">
                                
                                    


                                
                                
                                    <label for="mes"  >Mes</label>
                                    <input type="text" id="mes" class="form-control " placeholder="Mes" maxlength="2" required="required"   onfocusout="if(this.value>12){this.value='12';}else if(this.value<1){this.value='1';}">
                                    
                                
                               
                               
                               
                              
                            
                            
                          </div>
                                <div class="col-md-4">
                                  
                                    <label for="dia"  >Dia</label>
                                    <input type="text" id="dia" class="form-control " placeholder="Dia" required="required"  maxlength="2" onfocusout="if(this.value>31){this.value='31';}else if(this.value<1){this.value='1';}">
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
                              
                                
                                    
                                    <label  for="Sexo">Sexo</label>
                                
                                <select class="form-control" id="Sexo" required="required">
                                    <option selected>--</option>
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                   
                                </select>
                             
                            </div>
                            <div class="col-md-5">
                              
                                    <label  for="Estado">Estado Civil</label>
                                
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
                            <div class="col-md-3">
                              
                                
                                
                                    <label  for="ResCiudad">Estrato</label>
                                
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
                               <label for="Empresa"  >Nombre Empresa</label>
                                <input type="text" id="Empresa" class="form-control" placeholder="Empresa" required="required" >
                               
                              
                            </div>
                            <div class="col-md-3">
                              
                                
                                    <label   for="TipoEmpresa" >Tipo Empresa</label>
                            
                                <select class="form-control " id="TipoEmpresa"  required="required">
                                    <option selected>--</option>
                                    <option value="1">Publica</option>
                                    <option value="2">Privada</option>
                                    
                                </select>
                               
                              
                            </div>
                            <div class="col-md-5">
                              <label for="Cargo"  >Cargo</label>
                                <input type="text"  name="text" id="Cargo" class="form-control" placeholder="Cargo"  >
                                
                            
                            </div>
                            
                           
                            
                          </div>
                        </div>
                        <div class="form-group">
                          <div class="form-row">
                            
                            
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-4">
                             <label for="EmpDireccion"  >Dirección</label>
                                <input type="text" id="EmpDireccion" class="form-control" placeholder="Direccion" required="required" >
                                
                              
                            </div>
                            <div class="col-md-4">
                              <label for="EmpTelefono"  >Telefono</label>
                                <input type="text" id="EmpTelefono" class="form-control" placeholder="Telefono"  >
                               
                              
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
                        <hr><br>
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
                                    <input type="text" id="Prestamo"  class="form-control" placeholder=""  maxlength="4" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                                    <input type="text" id="AuxEmp"  class="form-control" placeholder="" maxlength="4" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                                    <input type="text" id="Recursos"  class="form-control" placeholder=""  maxlength="4" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                                    <input type="text" id="Beca"  class="form-control" placeholder=""  maxlength="4" onfocusout="if(this.value>100){this.value='100';}else if(this.value<0){this.value='0';}" >
                              
                                
                              
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
                                <select class="form-control" id="Egresado"  required="required">
                                    <option selected>--</option>
                                    <option value="1">Si</option>
                                    <option value="2">No</option>
                                    
                                </select>
                                  
                              </div>
                                <p> No aplican Convenios U.Nacional-Idead-Ceres-U.Caldas </p>
                            </div>
                            <div class="col-md-3">
                            </div>
                          </div>
                         </div>
                        <hr> <br><br>
                        
                               
                           
                               

                        
                        
                                
                        <div class="form-group">
                          <div class="form-row">
                            <div class="col-md-4">
                            </div>
                              <div class="col-md-4">
                                  <a class="btn btn-primary btn-block " href="login.html">Siguiente</a>
                            </div>
                              <div class="col-md-4">
                            </div>
                          </div>
                        </div>
                       
                        
                        
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