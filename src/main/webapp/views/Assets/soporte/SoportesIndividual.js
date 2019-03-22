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
    if (recibo != null && recibo != '') {
//		alert("paso a cargar")
        form.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Comprobante pago de inscripción", "alert", "Aceptar");
    }
}


////////////  RECIBO DE IMPUESTO PREDIAL /////////////////////////////////////////////////////////////
function ReciboImpuesto(element) {
    var datos1 = element.value.split('\\');
    var path1 = datos1[datos1.length - 1];
    document.getElementById("reciboI").value = path1;
}

function sendFormImpuesto() {

    var form1 = document.getElementById("reciboImpuesto");
    var reciboI = document.getElementById("reciboI").value;
    alert("recibo " + document.getElementById("reciboI").value);
    if (reciboI != null && reciboI != '') {
        alert("paso a cargar")
        form1.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Acta de grado de Pregrado ", "alert", "Aceptar");
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
    if (reciboF != null && reciboF != '') {
        form2.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue la Foto ", "alert", "Aceptar");
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
    if (RegistroHijos != null && RegistroHijos != '') {
        form3.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Diploma de Pregrado", "alert", "Aceptar");
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////  

function ReciboImpuesto1(element) {
    var datos1 = element.value.split('\\');
    var path4 = datos1[datos1.length - 1];
    document.getElementById("reciboI1").value = path4;
}

function sendFormImpuesto1() {

    var form4 = document.getElementById("reciboImpuesto1");
    var reciboI1 = document.getElementById("reciboI1").value;
    alert("recibo " + document.getElementById("reciboI1").value);
    if (reciboI1 != null && reciboI1 != '') {
        alert("paso a cargar")
        form4.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte de la Resolución - Servicio social obligatorio ", "alert", "Aceptar");
    }
}

function ReciboImpuesto2(element) {
    var datos5 = element.value.split('\\');
    var path5 = datos5[datos5.length - 1];
    document.getElementById("reciboI2").value = path5;
}

function sendFormImpuesto2() {

    var form5 = document.getElementById("reciboImpuesto2");
    alert("form " + document.getElementById("reciboImpuesto2").value);
    var reciboI2 = document.getElementById("reciboI2").value;
    alert("recibo " + document.getElementById("reciboI2").value);
    if (reciboI2 != null && reciboI2 != '') {
        alert("paso a cargar")
        form5.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte de la Fotocopia de cédula ampliada al 150% ", "alert", "Aceptar");
    }
}

function ReciboImpuesto3(element) {
    var datos6 = element.value.split('\\');
    var path6 = datos6[datos6.length - 1];
    document.getElementById("reciboI3").value = path6;
}

function sendFormImpuesto3() {

    var form6 = document.getElementById("reciboImpuesto3");
    var reciboI3 = document.getElementById("reciboI3").value;
    alert("recibo " + document.getElementById("reciboI3").value);
    if (reciboI3 != null && reciboI3 != '') {
        alert("paso a cargar")
        form6.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Certificado de la EPS ", "alert", "Aceptar");
    }
}

function ReciboImpuesto4(element) {
    var datos7 = element.value.split('\\');
    var path7 = datos7[datos7.length - 1];
    document.getElementById("reciboI4").value = path7;
    alert("path "+document.getElementById("reciboI4").value);
}

function sendFormImpuesto4() {

    var form7 = document.getElementById("reciboImpuesto4");
    var reciboI4 = document.getElementById("reciboI4").value;
    alert("recibo " + document.getElementById("reciboI4").value);
    if (reciboI4 != null && reciboI4 != '') {
        alert("paso a cargar")
        form7.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Carné de Egresado ", "alert", "Aceptar");
    }
}


function ReciboImpuesto5(element) {
    var datos8 = element.value.split('\\');
    var path7 = datos8[datos8.length - 1];
    document.getElementById("reciboI5").value = path7;
}

function sendFormImpuesto5() {

    var form8 = document.getElementById("reciboImpuesto5");
    var reciboI5 = document.getElementById("reciboI5").value;
    alert("recibo " + document.getElementById("reciboI5").value);
    if (reciboI5 != null && reciboI5 != '') {
        alert("paso a cargar")
        form8.submit();
    } else {
        Alert("¡Campos Requeridos!", "Por favor, cargue el soporte del Certificado de votación ", "alert", "Aceptar");
    }
}

function deleteSoporte(path, id) {
    Alert("¡Confirmar acción!", "¿Esta seguro de Eliminar el Archivo?", "confirm", "Aceptar,Cancelar");
    var aceptar = document.getElementById('btnPrimaryAlert');
    aceptar.addEventListener('click', function () {
        AJAX(path, null, 'EliminarSoportes', false);
        document.getElementById(id).value = '';
        document.getElementById("eliminar" + id).setAttribute('style', 'display: none;');
        document.getElementById("ver" + id).setAttribute('style', 'display: none;');
    })
}

function General2() {
    Alert("¡Incripcion finalizada!", "¡Gracias por realizar el proceso de Inscripción!", "alert", "Aceptar");
    
    var aceptar = document.getElementById('btnPrimaryAlert');
    aceptar.addEventListener('click', function () {
        $('#general').submit();
    });
}