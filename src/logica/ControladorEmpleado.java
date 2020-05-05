package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosEmpleado;
import entidades.Empleado;
import extras.Excepcion;

public class ControladorEmpleado {

	public ArrayList<Empleado> buscarTodos() throws SQLException, Excepcion {
		DatosEmpleado datos = new DatosEmpleado();
		return datos.buscarTodos();
	}
	
	public Empleado buscarPorIDUsuario(int id) throws SQLException, Excepcion {
		DatosEmpleado datos = new DatosEmpleado();
		return datos.buscarPorIDUsuario(id);
	}
	
	public void modificarPrivilegio(String usuario, String privilegio) throws SQLException, Excepcion {
		DatosEmpleado datos = new DatosEmpleado();
		datos.modificarPrivilegio(usuario, privilegio);
	}
	
}
