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
    	<div class="card card-login mx-auto mt-5">
      <div class="card-header">Pre Registro</div>
      
      <div class="card-body">
        <form>
          
          <div class="form-group">
              <p> El Usuario debe ser su Numero de Cedula</p>
            <div class="form-label-group">
              <input type="text" id="Usuario" class="form-control" placeholder="Cedula" required="required" autofocus="autofocus" title="Recuerde que su usuario es la cedula">
              <label for="Usuario">Usuario</label>
            </div>
          </div>
          <div class="form-group">
              <div class="form-label-group">
                  <input type="password" id="Contrasena" class="form-control" placeholder="Contraseña" required="required">
              <label for="Contrasena">Contraseña</label>
                </div>
          </div>
          <div class="form-group">
               <div class="form-label-group">
                  <input type="password" id="ConfirmContrasena" class="form-control" placeholder="Confirmar Contraseña" required="required">
              <label for="ConfirmContrasena">Confirmar Contraseña</label>
                </div>
          </div>
          
          
          <a class="btn btn-primary btn-block" href="login.jsp">Registrarme</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">Pagina del Login</a>
          
        </div>
      </div>
    </div>
    </jsp:body>
</t:Estructura_Login>