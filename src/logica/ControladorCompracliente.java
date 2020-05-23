package logica;

import java.sql.SQLException;

import datos.DatosCompraCliente;
import entidades.CompraCliente;
import extras.Excepcion;

public class ControladorCompracliente {
	
	DatosCompraCliente datos = new DatosCompraCliente();
	
	public int compra(CompraCliente compraCliente) throws SQLException, Excepcion{
		return datos.compra(compraCliente);
	}
	
}
