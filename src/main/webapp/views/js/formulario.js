$(document).ready(function () {
    $('#name').hide();
});

$('#botonFormulario').on('click', function () {
    if ($('#name').val() == "") {
        $.ajax({
            type: 'POST',
            data: $('#myform').serialize(),
            url: "Formulario",
            success: function (data) {
                if (data != null) {
                    if (data) {
                        alert("Guardado correctamente");
                    } else {
                        alert("Faltan datos");
                    }
                } else {
                    alert("Hay valores invalidos");
                }
            }
        });
    } else {
        alert("Alerta de bots, peticion rechazada");
    }
});

$('#otroIdioma').on('change', function (event) {
    if ($('#otroIdioma').val() != "") {
        $('#otroComprende').attr("required", "required");
        $('#otroHabla').attr("required", "required");
        $('#otroEscribe').attr("required", "required");
    } else {
        $('#otroComprende').removeAttr("required");
        $('#otroHabla').removeAttr("required");
        $('#otroEscribe').removeAttr("required");
    }
});

$('.tabla').on('change', function (event) {
    if ($(event.target).val() != "") {
        for (var i = 2; i <= 4; i++) {
            $('#' + event.target.id.slice(0, -1) + i).attr("required", "required");
        }
    } else {
        for (var i = 2; i <= 4; i++) {
            $('#' + event.target.id.slice(0, -1) + i).removeAttr("required");
        }
    }
});

$('.numeros').on('keypress', function (event) { //Solo numeros
    var regExp = /[0-9]/;
    if (!regExp.test(String.fromCharCode(event.keyCode))) {
        event.preventDefault();
    }
});

$('.letras').on('keypress', function (event) { //Solo letras con espacio
    var regExp = /[a-zA-Z\s]/;
    if (!regExp.test(String.fromCharCode(event.keyCode))) {
        event.preventDefault();
    }
});

$('.lenum').on('keypress', function (event) { //Para direcciones
    var regExp = /[a-zA-Z0-9\s#\-]/;
    if (!regExp.test(String.fromCharCode(event.keyCode))) {
        event.preventDefault();
    }
});

$('.fechas').on('keypress', function (event) { //Para fechas
    var regExp = /[0-9\-]/;
    if (!regExp.test(String.fromCharCode(event.keyCode))) {
        event.preventDefault();
    }
});

$('.fechas').on('change', function (event) { //Validar formato de fechas
    if ($(event.target).val() != "") {
        var regExp = /^[0-9]{4}\-[0-9]{1,2}\-[0-9]{1,2}$/;
        if (!regExp.test($(event.target).val())) {
            alert("La fecha debe tener el formato YYYY-MM-DD");
            $(event.target).val("");
            $(event.target).focus();
        }
    }
});

$('.correo').on('change', function (event) { //Validar formato de fechas
    if ($(event.target).val() != "") {
        var regExp = /^[a-z\.]*\@[a-z]*\.[a-z\.]*$/;
        if (!regExp.test($(event.target).val())) {
            alert("El correo debe tener el formato micorreo@unejemplo.es o mi.correo@un.ejemplo.es");
            $(event.target).val("");
            $(event.target).focus();
        }
    }
});

$('#Conocimiento').on('change', function (event) {
    if ($('#Conocimiento').val() == "Otros") {
        $('#Otrosok').show();
    } else {
        $('#Otrosok').hide();
    }
});

$('.pais').on('change', function (event) {
    AJAX($(event.target).val()!=""?$(event.target).val():"0", event.target.id.replace("Pais", "Departamento"), 'FormularioDept', true);
});

$('.departamento').on('change', function (event) {
    AJAX($(event.target).val()!=""?$(event.target).val():"0", event.target.id.replace("Departamento", "Ciudad"), 'FormularioCiudad', true);
});
//var pais = document.getElementById("ExpPais");
//alert(pais.value);
//pais.addEventListener("change", function() {
//	AJAX($pais.val(), 'ExpDepartamento', 'FormularioDept', true);
//});
//
//var departamento = document.getElementById("ExpDepartamento");
//departamento.addEventListener("change", function() {
//	AJAX(this.form, 'ciudad', 'DatosBasicosCiudad', true);
//});
