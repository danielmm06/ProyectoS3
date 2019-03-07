/**
 * funcion para que solo ingresen numeros en el imput tipo text
 */

function soloNumeros(e) {
	var key = window.Event ? e.which : e.keyCode
	return ((key >= 48 && key <= 57) || (key == 8))
}

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

 