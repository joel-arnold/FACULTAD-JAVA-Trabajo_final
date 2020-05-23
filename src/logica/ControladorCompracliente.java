package logica;

import java.sql.SQLException;

import datos.DatosCompraCliente;
import entidades.CompraCliente;
import extras.Excepcion;

public class ControladorCompracliente {
	
	DatosCompraCliente datos = new DatosCompraCliente();
	
	public void compra(CompraCliente compraCliente) throws SQLException, Excepcion{
		datos.compra(compraCliente);
	}
	
}
