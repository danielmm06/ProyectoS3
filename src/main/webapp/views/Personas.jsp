<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:template>
	<jsp:attribute name="title">
		<c:out value="${title}" />
    </jsp:attribute>
	<jsp:attribute name="styles">
		<!-- Styles -->
		<!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
    	<!-- Scripts -->
		<!-- /Scripts -->
    </jsp:attribute>
    
    <jsp:body>
      
       
            <c:forEach items="${listaPersonas}" var="Pers">
                <c:if test="${ Pers.id eq 1}">
                    <div class="col-md-6">
                        <label ><c:out value="${Pers.nombre}"></c:out><label  style="color: red;">*</label></label>
                    </div>
                </c:if>
                
                <c:if test="${ Pers.id eq 2}">
                    <div class="col-md-6">
                        <label ><c:out value="${Pers.nombre}"></c:out><label  style="color: red;">*</label></label>
                    </div>
                </c:if>
                
            </c:forEach>
       
    </jsp:body>
</t:template>
