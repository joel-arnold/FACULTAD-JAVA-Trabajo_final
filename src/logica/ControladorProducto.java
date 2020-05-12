package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosProducto;
import entidades.Producto;
import extras.Excepcion;

public class ControladorProducto {
	
	DatosProducto datos = new DatosProducto();
	
	public ArrayList<Producto> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosProducto();
		return datos.buscarTodos();
	}
	
}
