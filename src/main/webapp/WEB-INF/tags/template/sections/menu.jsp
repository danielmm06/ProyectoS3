<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="menu_section">
    <h3>Menú general</h3>
    <ul class="nav side-menu">
        <li>
            <a href="javascript:void(0)" onclick="location.href=pathURL+'Home'" >
            	<i class="fa fa-home"></i> Inicio 
            </a>
        </li>
        <c:forEach items="${listaMenus}" var="menu" varStatus="loop">
        	<c:if test="${menu.codMenuPadre==0}">
        		<li>
		            <a>
		            	<i class="fa fa-<c:out value="${menu.icono}" />"></i>
		            	<c:out value="${menu.nombre}" />
		            	<span class="fa fa-chevron-down"></span>
		            </a>
		            <ul class="nav child_menu">
		                <c:forEach items="${listaMenus}" var="item" varStatus="loop">
		                	<c:if test="${item.codMenuPadre!=0 && item.codMenuPadre==menu.codMenu}">
								<li>
									<a onclick="location.href=pathURL+'<c:out value="${item.ruta}" />'" 
									   target="_<c:out value="${item.target}" />"><c:out value="${item.nombre}" /></a>
								</li>
							</c:if>
				    	</c:forEach>
		            </ul>
		        </li>
        	</c:if>
    	</c:forEach>
    </ul>
</div>