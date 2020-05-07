package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import datos.DatosCliente;
import entidades.*;
import extras.Excepcion;

public class ControladorCliente {

	private DatosCliente datos;

	public void alta(Cliente cliente) throws SQLException, Excepcion {
		String contrasenaEncriptada = DigestUtils.md5Hex(cliente.getContrasena());
		cliente.setContrasena(contrasenaEncriptada);
		datos = new DatosCliente();
		datos.alta(cliente);
	}

	public Cliente buscarUno(String apellido, String nombre) throws SQLException, Excepcion {
		datos = new DatosCliente();
		return datos.buscarUno(apellido, nombre);
	}

	public Cliente buscarPorIDUsuario(int id) throws SQLException, Excepcion {
		datos = new DatosCliente();
		return datos.buscarPorIDUsuario(id);
	}

	public ArrayList<Cliente> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosCliente();
		return datos.buscarTodos();
	}

}