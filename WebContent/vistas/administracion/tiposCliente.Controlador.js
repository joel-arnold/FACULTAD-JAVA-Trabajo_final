function configIdEliminar(id) { 
	var inputIdEliminar = $('#campo_idEliminar');
	inputIdEliminar.val(id);
}

function configModificar(id, descripcion, porcentaje) { 
	var inputIdModificar = $('#campo_idModificar'),
		inputDescripcion = $('#campo_descripcionModificar'),
		inputPorcentaje = $('#campo_porcentajeModificar');
	inputIdModificar.val(id);
	inputDescripcion.val(descripcion);
	inputPorcentaje.val(porcentaje);
}

//Al cargar la página, asignar evento al botón de notificaciones para mostrarlas.
$('.toast').toast({ delay: 2000 });
$('#btn-notif').on('click', function() {
    $('.toast').toast('show');
});