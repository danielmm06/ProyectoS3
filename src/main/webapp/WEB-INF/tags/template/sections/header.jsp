<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="nav toggle">
    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
</div>
<ul class="nav navbar-nav navbar-right">
    <li class="">
        <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false" align="right" >
        	<label class="labelName">
        		<c:out value="${usuario.persona.nombre1}" /> <c:out value="${usuario.persona.nombre2}" /> <c:out value="${usuario.persona.apellido1}" /> <c:out value="${usuario.persona.apellido2}" />
        	</label>
        	<img src="Assets/img/user.png" alt="">
        	<br>
        	<c:if test="${usuario.nickname eq 'app'}">
        		<label class="labelRol">SUPER ADMIN</label>
        	</c:if>
        	<c:if test="${usuario.nickname ne 'app'}">
        		<label class="labelRol"><c:out value="${rolUser.nombre}" /></label>
        	</c:if>
        </a>
        <ul class="dropdown-menu dropdown-usermenu pull-right">
            <li>
                <a href="Other?p=Help">
                    <i class="fa fa-question-circle pull-left"></i>
                    <span class="itemMenuHelp">Ayuda</span>
                </a>
            </li>
            <li>
                <a href="Other?p=AcercaDe">
                    <i class="fa fa-list-alt pull-left"></i>
                    <span class="itemMenuHelp">Acerca de</span>
                </a>
            </li>
            <li>
            	<a href="Logout">
            		<i class="fa fa-sign-out pull-left"></i> 
            		<span class="itemMenuHelp">Cerrar Sesión</span>
            	</a>
            </li>
        </ul>
    </li>
    <li role="presentation" class="dropdown menuMensajesHeader">
        <a href="https://mail.google.com/mail" target="_blank" class="dropdown-toggle info-number">
            <i class="fa fa-envelope-o"></i>
            <span class="badge bg-green numMensajesHeader">G</span>
        </a>
    </li>
</ul>