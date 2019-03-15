$(document).ready(function () {
    var info = document.getElementById("info").innerHTML;
    var formulario = info.substring(1, info.length - 1).split(', ');
    $('#Categoria').val(formulario[0]);
    $('#TipoDocumento').val(formulario[1]);
    $('#ExpPais').val(formulario[2]).change();
    setTimeout(function () {
        $('#ExpDepartamento').val(formulario[3]).change();
        setTimeout(function () {
            $('#ExpCiudad').val(formulario[4]);
        }, 500);
    }, 500);
    $('#ResPais').val(formulario[5]).change();
    setTimeout(function () {
        $('#ResDepartamento').val(formulario[6]).change();
        setTimeout(function () {
            $('#ResCiudad').val(formulario[7]);
        }, 500);
    }, 500);
    $('#OfiPais').val(formulario[8]).change();
    setTimeout(function () {
        $('#OfiDepartamento').val(formulario[9]).change();
        setTimeout(function () {
            $('#OfiCiudad').val(formulario[10]);
        }, 500);
    }, 500);
    $('#ano').val(formulario[11]);
    $('#mes').val(formulario[12]);
    $('#dia').val(formulario[13]);
    $('#NacPais').val(formulario[14]).change();
    setTimeout(function () {
        $('#NacDepartamento').val(formulario[15]).change();
        setTimeout(function () {
            $('#NacCiudad').val(formulario[16]);
        }, 500);
    }, 500);
    $('#Sexo').val(formulario[17]);
    $('#Estado').val(formulario[18]);
    $('#Estrato').val(formulario[19]);
    $('#TipoEmpresa').val(formulario[20]);
    $('#EmpPais').val(formulario[21]).change();
    setTimeout(function () {
        $('#EmpDepartamento').val(formulario[22]).change();
        setTimeout(function () {
            $('#EmpCiudad').val(formulario[23]);
        }, 500);
    }, 500);
    var otro = true;
    $('#Conocimiento option').each(function() {
        if ($(this).val() == formulario[24]) {
            otro = false;
        }
    });
    if (otro) {
        $('#Conocimiento').val("Otros").change()
        $('#Otrosok').val(formulario[24]);
    } else {
        $('#Conocimiento').val(formulario[24]).change();
    }
    $('#EspComprende').val(formulario[26]);
    $('#EspHabla').val(formulario[27]);
    $('#EspEscribe').val(formulario[28]);
    $('#IngComprende').val(formulario[30]);
    $('#IngHabla').val(formulario[31]);
    $('#IngEscribe').val(formulario[32]);
    $('#FranComprende').val(formulario[34]);
    $('#FranHabla').val(formulario[35]);
    $('#FranEscribe').val(formulario[36]);
    var index = 37;
    if (formulario[index] != "finIdiomas") {
        $('#otroIdioma').val(formulario[index]);
        index++;
        $('#otroComprende').val(formulario[index]);
        index++;
        $('#otroHabla').val(formulario[index]);
        index++;
        $('#otroEscribe').val(formulario[index]);
        index += 2;
    } else {
        index++;
    }
    $('#Egresado').val(formulario[index]);
});

$('#botonFormulario').on('click', function () {
    if ($('#name').val() == "") {
        $.ajax({
            type: 'POST',
            data: $('#myform').serialize(),
            url: "Formulario",
            success: function (operation) {
                if (operation != null) {
                    if (operation != 0) {
                        alert("Guardado correctamente");
                    } else {
                        alert("Faltan datos");
                    }
                } else {
                    alert("Hay valores invalidos");
                }
            }
        });
    }
});

$('#otroIdioma').on('change', function (event) {
    if ($('#otroIdioma').val() != "") {
        $('#otroComprende').prop("required", true);
        $('#otroHabla').prop("required", true);
        $('#otroEscribe').prop("required", true);
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
    AJAX($(event.target).val() != "" ? $(event.target).val() : "0", event.target.id.replace("Pais", "Departamento"), 'FormularioDept', true);
});

$('.departamento').on('change', function (event) {
    AJAX($(event.target).val() != "" ? $(event.target).val() : "0", event.target.id.replace("Departamento", "Ciudad"), 'FormularioCiudad', true);
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
