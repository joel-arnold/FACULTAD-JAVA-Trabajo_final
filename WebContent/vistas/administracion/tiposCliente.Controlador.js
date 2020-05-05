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