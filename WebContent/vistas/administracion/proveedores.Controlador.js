function configIdEliminar(id) { 
	var inputIdEliminar = $('#campo_idEliminar');
	inputIdEliminar.val(id);
}

function configModificar(id, razonSocial, cuit, calle, numero, piso, depto, correo, telefono){ 
	var inputIdModificar = $('#campo_idModificar'),
		inputDescripcion = $('#campo_razonSocialModif');
	
	inputDescripcion.val(razonSocial);
	inputPorcentaje.val(porcentaje);
}