//$(document).ready(function(){
//
//	$("#ExpPais").click(function() {
//            var codPais = $('codPais').val();
//            $.ajax({
//                type:'POST',
//                data:{codPais: codPais},
//                url:'Ajax',
//                success: function(result){
//                }
//            });
//		
//    });
//	
//});


$('#ExpPais').on('change', function() {
	AJAX($('#ExpPais').val(), 'ExpDepartamento', 'FormularioDept', true);
});

$('#ExpDepartamento').on('change', function() {
	AJAX($('#ExpDepartamento').val(), 'ExpCiudad', 'FormularioCiudad', true);
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
