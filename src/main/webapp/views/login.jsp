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
        <!-- Content -->
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Inicio de Sesión</div>
            <div class="card-body">
                <form name="Loginform" id="Loginform" method="post" action="Login" autocomplete="off" data-check="true" data-confirm="true">
                    <div class="form-group">
                        <label for="Usuario">Usuario</label>
                        <input type="text" id="Usuario" name="Usuario" onkeypress="return soloNumeros(event)" class="form-control" placeholder="Cedula" required="required" autofocus="autofocus" title="Recuerde que su usuario es la cedula" >
                    </div>

                    <div class="form-group">
                        <label for="Contrasena">Contraseña</label>
                        <input type="password"  id="Contrasena" name="Contrasena" class="form-control" placeholder="Contrasena" required="required">
                    </div>

                    
                    <input type="submit" id="botonLogin" name="botonLogin" class="btn btn-primary btn-lg btn-block" value="Iniciar Sesión" >
                    
                    <input type="text" id="name" name="name" value="" style="display: none">
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="Registro">Resgistrarme</a>

                </div>
            </div>
        </div>

        <!-- /Content -->
    </jsp:body>
</t:Estructura_Login>