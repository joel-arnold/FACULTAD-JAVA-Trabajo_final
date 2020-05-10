package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosProveedor;
import entidades.Proveedor;
import extras.Excepcion;

public class ControladorProveedor {
	
	DatosProveedor datos = new DatosProveedor();
	
	public ArrayList<Proveedor> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosProveedor();
		return datos.buscarTodos();
	}
	
	public void alta(Proveedor proveedor) throws SQLException, Excepcion{
		datos.alta(proveedor);
	}
	
	public void baja(int id) throws SQLException, Excepcion{
		datos.baja(id);
	}
	
}