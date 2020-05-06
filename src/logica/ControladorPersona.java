package logica;

import java.sql.SQLException;

import datos.*;
import entidades.Cliente;
import entidades.Persona;
import extras.Excepcion;

public class ControladorPersona {

	public boolean existeUsuario(String usuario) throws SQLException, Excepcion {
		DatosPersona dp = new DatosPersona();
		return dp.existeUsuario(usuario);
	}	
	
	public int buscarIDUsuario(String usuario, String contrasena) throws SQLException, Excepcion {
		DatosPersona dp = new DatosPersona();
		return dp.buscarIDUsuario(usuario, contrasena);
	}
	
	public String buscarPrivilegio(int idUsuario) throws SQLException, Excepcion {
		DatosPersona dp = new DatosPersona();
		return dp.buscarPrivilegio(idUsuario);
	}
	
}