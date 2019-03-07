function ReciboPublico(element) {
	var datos = element.value.split('\\');
	var path = datos[datos.length - 1];	
	document.getElementById("reciboP").value = path;
//	alert("path "+document.getElementById("reciboP").value);
}

function sendFormReciboPublico() {	
//	alert("entro a enviar");
	var form = document.getElementById("reciboPublico");
	var recibo = document.getElementById("reciboP").value;
//	alert("recibo "+document.getElementById("reciboP").value);
	if(recibo != null && recibo != ''){
//		alert("paso a cargar")
		form.submit();	
	}else{
		Alert("¡Campos Requeridos!","Por favor, cargue el soporte del recibo Publico","alert","Aceptar");
	}
}


////////////  RECIBO DE IMPUESTO PREDIAL /////////////////////////////////////////////////////////////
function ReciboImpuesto(element) {
	var datos1 = element.value.split('\\');
	var path1 = datos1[datos1.length - 1];	
	document.getElementById("reciboI").value = path1;
}

function sendFormImpuesto() {	

	var form1 = document.getElementById("Impuesto");
	var reciboI = document.getElementById("reciboI").value;
	if(reciboI != null && reciboI != ''){
		form1.submit();	
	}else{
		Alert("¡Campos Requeridos!","Por favor, cargue el soporte del Impuesto Predial","alert","Aceptar");
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////

//////////// FOSYGAL /////////////////////////////////////////////////////////////
function FoSyga(element) {
	var datos2 = element.value.split('\\');
	var path2 = datos2[datos2.length - 1];	
	document.getElementById("fosyga").value = path2;
}

function sendFormFoSyga() {	

	var form2 = document.getElementById("FormFosyga");
	var reciboF = document.getElementById("fosyga").value;
	if(reciboF != null && reciboF != ''){
		form2.submit();	
	}else{
		Alert("¡Campos Requeridos!","Por favor, cargue el soporte del Fosyga","alert","Aceptar");
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////  

//////////// REGISTRO HIJOS ////////////////////////////////////////////////////////////
function CertHijos(element) {
	var datos3 = element.value.split('\\');
	var path3 = datos3[datos3.length - 1];	
	document.getElementById("hijos").value = path3;
//	alert("hijos "+document.getElementById("RegistroH").value);
}

function sendFormCertHijos() {	

	var form3 = document.getElementById("FormCertHijos");
	var RegistroHijos = document.getElementById("hijos").value;
//	alert(RegistroHijos);
	if(RegistroHijos != null && RegistroHijos != ''){
		form3.submit();	
	}else{
		Alert("¡Campos Requeridos!","Por favor, cargue el soporte de los Hijos","alert","Aceptar");
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////  

function deleteSoporte(path,id) {
	Alert("¡Confirmar acción!","¿Esta seguro de Eliminar el Archivo?","confirm","Aceptar,Cancelar");
	var aceptar = document.getElementById('btnPrimaryAlert');
	aceptar.addEventListener('click',function(){		
		AJAX2(path, null, 'EliminarSoportesBienestar', false);
		document.getElementById(id).value = '';		
		document.getElementById("eliminar"+id).setAttribute("style", "pointer-events: none;");
		document.getElementById("ver"+id).setAttribute("style", "pointer-events: none;");
	})
}



function General2() {	
	Alert("¡Gracias por realizar el proceso de descuentos socio-economicos!","Usted ha completado los cuatro formularios, junto con la carga de los soportes necesarios para su primer proceso de Inscripción <p> Debe estar pendiente para la publicacion de los Listados de Admision, los cuales se publicaran en las fechas establecidas por el calendario academico de la Universidad de los Llanos, en la pagina web www.unillanos.edu.co. <p> Una vez admitido, se le habilitara la opción de carga de soportes Generales,los cuales son necesarios para la culminacion del proceso de matricula.","alert","Aceptar");
	var form = document.getElementById("general");
	var aceptar = document.getElementById('btnPrimaryAlert');
	aceptar.addEventListener('click',function(){
		form.submit();
	})
}