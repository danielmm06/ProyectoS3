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
    	<script type="text/javascript">
    		function myFormFunction() {
    			console.log("myFormFunction.................");
    			return true;
    		}
    	</script>
		<!-- /Scripts -->
    </jsp:attribute>
    
    <jsp:body>
    	<!-- Content -->
    	<div class="card card-login mx-auto mt-5">
      <div class="card-header">Inicio de Sesión</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="Usuario" class="form-control" placeholder="Cedula" required="required" autofocus="autofocus" title="Recuerde que su usuario es la cedula">
              <label for="Usuario">Usuario</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="Contrasena" class="form-control" placeholder="Contrasena" required="required">
              <label for="Contrasena">Contraseña</label>
            </div>
          </div>
          <div class="form-group">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me">
                Recordar Contraseña
              </label>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="Registro.jps">Ingresar</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Resgistrarme</a>
          
        </div>
      </div>
    </div>
        
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Login>