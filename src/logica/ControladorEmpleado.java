package logica;

import java.sql.SQLException;

import datos.DatosEmpleado;
import entidades.Empleado;
import extras.Excepcion;

public class ControladorEmpleado {

	public Empleado buscarPorIDUsuario(int id) throws SQLException, Excepcion {
		DatosEmpleado datos = new DatosEmpleado();
		return datos.buscarPorIDUsuario(id);
	}

}
