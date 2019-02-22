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
    	<!-- <form action="TestForm" method="post" enctype="multipart/form-data">
		    <input type="text" id="description" name="description" />
		    <input type="file" id="file" name="file" />
		    <input type="submit" value="Enviar" />
		</form> -->
		
		<form action="TestForm" method="post" enctype="multipart/form-data" data-check="true" data-confirm="true" data-fn="myFormFunction">
		    <input data-type="text" data-size="5" data-req="true" data-msj="Msj1" 
		    	id="input1" name="input1" title="input1" placeholder="text" />
		    <input data-type="number" data-size="5" data-req="true" data-msj="Msj2" 
		    	id="input2" name="input2" title="input2" placeholder="number" />
		   	<input data-type="decimal" data-size="5" data-req="true" data-msj="Msj3" 
		    	id="input3" name="input3" title="input3" placeholder="decimal" />
		    <input data-type="alpht" data-size="5" data-req="true" data-msj="Msj4" 
		    	id="input4" name="input4" title="input4" placeholder="alpht" />
		    <input data-type="alpht-no-accent" data-size="5" data-req="true" data-msj="Msj5" 
		    	id="input5" name="input5" title="input5" placeholder="alpht-no-accent" />
		    
		    <select data-size="5" data-req="true" data-msj="Msj6" data-live-search="true" class="selectpicker show-tick form-control" 
		    	id="select" name="select" title="Seleccióne una opción" >
					<option value='1' >Opción 1</option>
					<option value='2' >Opción 2</option>
					<option value='3' >Opción 3</option>
					<option value='4' >Opción 4</option>
					<option value='5' >Opción 5</option>
					<option value='6' >Opción 6</option>
					<option value='7' >Opción 7</option>
			</select>
			
			<input type="checkbox" value="1" checked
				id="checkbox1" name="checkbox1" title="Acepto" />
			<label for="checkbox1"><span></span>Acepto</label>
			<input type="checkbox" value="0"
				id="checkbox2" name="checkbox2" title="Acepto" />
			<label for="checkbox2"><span></span>Acepto</label>
			
			<input type="date" data-req="true" data-msj="Msj7" class="datepicker form-control"
				id="date1" name="date1" title="Fecha" />
		    
		    <input id="Submit" name="Submit" type="button" value="Enviar" />
		</form>
        <!-- /Content -->
    </jsp:body>
</t:template>