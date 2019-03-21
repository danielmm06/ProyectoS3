$(document).ready(function () {
    var info = document.getElementById("info").innerHTML;
    var formulario = info.substring(1, info.length - 1).split(', ');
    info = "<tr>";
    for (var i = 0; i < formulario.length; i++) {
        info += "<td>" + formulario[i] + "</td>";
        if ((i + 1) % 4 == 0) {
            info += "<td><div class='btn btn-success' id='enviar' onclick='sendFormReciboPublico(" + formulario[i - 3] + ")'>&nbsp;Evaluar&nbsp;</div></td>";
            info += "</tr><tr>";
        }
    }
    info = info.substring(0, info.length - 4);
    $('#cuerpo').empty();
    $('#cuerpo').append(info);
});

function sendFormReciboPublico(aspirante) {
    $('#doc').val(aspirante);
    $('#myform').submit();
}