/**
 * funcion para que solo ingresen numeros en el imput tipo text
 */

function soloNumeros(e){var a=window.Event?e.which:e.keyCode;return a>=48&&a<=57||8==a}$(document).ready(function(){$("#name").hide()}),$("#botonRegistrar").on("click",function(){""==$("#name").val()?$.ajax({type:"POST",data:$("#Registroform").serialize(),url:"Registro",success:function(e){null!=e?e?(alert("Registrado correctamente"),window.location.replace("Login")):alert("La contraseña no coincide"):alert("Hay valores invalidos")}}):alert("Alerta de bots, peticion rechazada")});

 