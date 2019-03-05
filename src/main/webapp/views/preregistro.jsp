<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Login>
	<jsp:attribute name="title">
		<c:out value="${title}" />
    </jsp:attribute>
	<jsp:attribute name="styles">
		<!-- Styles -->
		<!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
    	<!-- Scripts -->
    	<script type="text/javascript" src="views/js/login.js"></script>
		<!-- /Scripts -->
    </jsp:attribute>
    
    <jsp:body>
    	<div class="card card-login mx-auto mt-5">
      <div class="card-header">Pre Registro</div>
      
      <div class="card-body">
        <form name="Registroform" id="Registroform" method="post" action="Registro" autocomplete="off" data-check="true" data-confirm="true">
          
          <div class="form-group">
              <p> El Usuario debe ser su Numero de Cedula</p>
              <hr>
            <label for="Usuario">Usuario</label>
              <input type="text" onkeypress="return soloNumeros(event)" id="Usuario" class="form-control" placeholder="Cedula" required="required" autofocus="autofocus" title="Recuerde que su usuario es la cedula">
              
            
          </div>
          <div class="form-group">
              <label for="Contrasena">Contraseña</label>
                  <input type="password" id="Contrasena" class="form-control" placeholder="Contraseña" required="required">
              
                
          </div>
          <div class="form-group">
               <label for="ConfirmContrasena">Confirmar Contraseña</label>
                  <input type="password" id="ConfirmContrasena" class="form-control" placeholder="Confirmar Contraseña" required="required">
              
                
          </div>
          
          <input type="submit" id="botonRegistrar" name="botonRegistrar" class="btn btn-primary btn-lg btn-block" value="Registrarme" >
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="Login">Pagina del Login</a>
          
        </div>
      </div>
    </div>
    </jsp:body>
</t:Estructura_Login>