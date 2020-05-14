function configIdEliminar(id) {
	var inputIdEliminar = $('#campo_idEliminar');
	inputIdEliminar.val(id);
}

function configModificar(id, codigo, nombre, descripcion, tamano, umedida, precioventa,
		categoria, imagen) {
	var inputIdModificar = $('#campo_idModificar'),
		inputCodigo = $('#campo_codigo'),
		inputNombre = $('#campo_nombre'),
		inputDescripcion = $('#campo_descripcion'),
		inputTamano = $('#campo_tamano'),
		inputUmedida = $('#campo_umedida'),
		inputPrecioventa = $('#campo_precioventa'),
		inputCategoria = $('#campo_categoria'),
		inputImagen = $('#campo_imagen');

	inputIdModificar.val(id);
	inputCodigo.val(codigo);
	inputNombre.val(nombre);
	inputDescripcion.val(descripcion);
	inputTamano.val(tamano);
	inputUmedida.val(umedida);
	inputPrecioventa.val(precioventa)
	inputCategoria.val(categoria);
	inputImagen.val(imagen);
}