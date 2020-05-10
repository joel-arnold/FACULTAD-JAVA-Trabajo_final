function configIdEliminar(id) {
	var inputIdEliminar = $('#campo_idEliminar');
	inputIdEliminar.val(id);
}

function configModificar(id, razonSocial, cuit, calle, numero, piso, depto,
		correoElec, telefono) {
	var inputIdModificar = $('#campo_idModificar'),
		inputRazonSocial = $('#campo_razonSocial'),
		inputcuit = $('#campo_cuit'),
		inputCalle = $('#campo_calle'),
		inputNumero = $('#campo_numero'),
		inputPiso = $('#campo_piso'),
		inputDepto = $('#campo_depto'),
		inputCorreoElec = $('#campo_correoElectronico'),
		inputTelefono = $('#campo_telefono');

	inputIdModificar.val(id);
	inputRazonSocial.val(razonSocial);
	inputcuit.val(cuit);
	inputCalle.val(calle);
	inputNumero.val(numero);
	inputPiso.val(piso)
	inputDepto.val(depto);
	inputCorreoElec.val(correoElec);
	inputTelefono.val(telefono);
}