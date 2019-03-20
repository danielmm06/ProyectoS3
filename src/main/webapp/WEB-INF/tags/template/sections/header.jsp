<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"></form>
<ul class="navbar-nav ml-auto ml-md-0">
    
    <li class="nav-item dropdown no-arrow" style="height: 44px;" >
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  >
            <label class="labelName">
        		<c:out value="${usuario.persona.nombre1}" /> <c:out value="${usuario.persona.nombre2}" /> <c:out value="${usuario.persona.apellido1}" /> <c:out value="${usuario.persona.apellido2}" />
        	</label>
                
                <i class="fas fa-user-circle fa-fw"></i>
        	<br>
        	<c:if test="${usuario.nickname eq 'app'}">
        		<label class="labelRol">SUPER ADMIN</label>
        	</c:if>
        	<c:if test="${usuario.nickname ne 'app'}">
        		<label class="labelRol"><c:out value="${rolUser.nombre}" /></label>
        	</c:if>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
<!--          <a class="dropdown-item" href="#">Configuracion</a>-->
          
<!--          <div class="dropdown-divider"></div>-->
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Cerrar Sesión</a>
        </div>
    </li>
</ul>