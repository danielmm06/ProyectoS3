/**
 * funcion para que solo ingresen numeros en el imput tipo text
 */

function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode
    return ((key >= 48 && key <= 57) || (key == 8))
}

$(document).ready(function() {
   $('#name').hide(); 
});

$('#botonRegistrar').on('click', function () {
    if ($('#name').val()=="") {
        $.ajax({
            type: 'POST',
            data: $('#Registroform').serialize(),
            url: "Registro",
            success: function (data) {
                if (data != null) {
                    if (data) {
                        alert("Registrado correctamente");
                        window.location.replace("Login");
                    } else {
                        alert("La contraseña no coincide");
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
//$('#Usuario').focusout(function() {
// var user = $(this).val();
//// alert(user);
//
// // Recomiendo usar la consola en lugar de alerts
//// console.log(x);
//});
//
//$('#Contrasena').focusout(function() {
// var pass = $(this).val();
//// alert(pass);

// Recomiendo usar la consola en lugar de alerts
// console.log(x);
//});

 