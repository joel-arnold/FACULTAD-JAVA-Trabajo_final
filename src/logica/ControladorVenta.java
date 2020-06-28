package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosVenta;
import entidades.Venta;
import extras.Excepcion;

public class ControladorVenta {
	
DatosVenta datos = new DatosVenta();
	
	public ArrayList<Venta> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosVenta();
		return datos.buscarTodos();
	}

	public Venta buscarVentaDetallada(int idCompra)throws SQLException, Excepcion {
		datos = new DatosVenta();
		return datos.buscarVentaDetallada(idCompra);
	}
	
}
