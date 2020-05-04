package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosTipoCliente;
import entidades.*;
import extras.Excepcion;

public class ControladorTipoCliente {

	private DatosTipoCliente datos;
	
	public void alta(TipoCliente tipoCliente) throws SQLException, Excepcion {
		DatosTipoCliente datos = new DatosTipoCliente();
		datos.alta(tipoCliente);
	}
	
	public void baja(int id) throws SQLException, Excepcion {
		DatosTipoCliente datos = new DatosTipoCliente();
		datos.baja(id);
	}
	
	public void modificacion(TipoCliente tipoCliente) throws SQLException, Excepcion {
		DatosTipoCliente datos = new DatosTipoCliente();
		datos.modificacion(tipoCliente);
	}	
	
	public ArrayList<TipoCliente> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosTipoCliente();
		return datos.buscarTodos();
	}

}
