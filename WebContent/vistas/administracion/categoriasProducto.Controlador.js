function configIdEliminar(id) {
	var inputIdEliminar = $('#campo_idEliminar');
	inputIdEliminar.val(id);
}

function configModificar(id, nombre, descripcion) {
	var inputIdModificar = $('#campo_idModificar'),
		inputNombre = $('#campo_nombre'),
		inputDescripcion = $('#campo_descripcion');

	inputIdModificar.val(id);
	inputNombre.val(nombre);
	inputDescripcion.val(descripcion);
}