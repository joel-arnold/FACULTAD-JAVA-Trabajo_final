package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Empleado;
import entidades.TipoCliente;
import extras.Excepcion;

public class DatosEmpleado {
	
	public ArrayList<Empleado> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Empleado> listado = new ArrayList<Empleado>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM empleados e LEFT JOIN usuarios u ON e.usuario = u.id");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(resultado.getInt("e.id"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellido(resultado.getString("apellido"));
				empleado.setTipoDocumento(resultado.getString("tipoDocumento"));
				empleado.setDocumento(resultado.getString("documento"));
				empleado.setDomicilioCalle(resultado.getString("domicilioCalle"));
				empleado.setDomicilioNumero(resultado.getString("domicilioNumero"));
				empleado.setDomicilioPiso(resultado.getString("domicilioPiso"));
				empleado.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				empleado.setTelefono(resultado.getString("telefono"));
				empleado.setCorreoElectronico(resultado.getString("correoElectronico"));
				empleado.setNombreUsuario(resultado.getString("nombreUsuario"));
				empleado.setContrasena(resultado.getString("contrasena"));
				empleado.setCuil(resultado.getString("cuil"));
				empleado.setPrivilegio(resultado.getString("privilegio"));
				listado.add(empleado);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar los privilegios");

		}
		// Este "Try-Catch" es para cerrar la conexión y sus resultados.
		try {
			if (resultado != null)
				resultado.close();
			if (sentenciaSQL != null)
				sentenciaSQL.close();
			Conexion.crearInstancia().cerrarConexion();
		}

		catch (SQLException excepcion) {
			throw new SQLException("Error intentando cerrar la conexion a la base de datos", excepcion);
		}
		return listado;
	}	

	public Empleado buscarPorIDUsuario(int id) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		Empleado empleado = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM empleados e LEFT JOIN usuarios u ON e.usuario = u.id " +
					"WHERE u.id = ?");
			sentenciaSQL.setInt(1, id);
			resultado = sentenciaSQL.executeQuery();

			if (resultado != null && resultado.next()) {
				empleado = new Empleado();
				empleado.setId(resultado.getInt("id"));
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellido(resultado.getString("apellido"));
				empleado.setTipoDocumento(resultado.getString("tipoDoc"));
				empleado.setDocumento(resultado.getString("documento"));
				empleado.setDomicilioCalle(resultado.getString("domicilioCalle"));
				empleado.setDomicilioNumero(resultado.getString("domicilioNumero"));
				empleado.setDomicilioPiso(resultado.getString("domicilioPiso"));
				empleado.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				empleado.setTelefono(resultado.getString("telefono"));
				empleado.setCorreoElectronico(resultado.getString("correoElectronico"));
				empleado.setCuil(resultado.getString("cuil"));
				empleado.setNombreUsuario(resultado.getString("nombreUsuario"));
				empleado.setContrasena(resultado.getString("contrasena"));
				empleado.setPrivilegio(resultado.getString("privilegio"));
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar los clientes");

		}
		// Este "Try-Catch" es para cerrar la conexión y sus resultados.
		try {
			if (resultado != null)
				resultado.close();
			if (sentenciaSQL != null)
				sentenciaSQL.close();
			Conexion.crearInstancia().cerrarConexion();
		}

		catch (SQLException excepcion) {
			throw new SQLException("Error intentando cerrar la conexion a la base de datos", excepcion);
		}
		return empleado;
	}
	
	public void modificarPrivilegio(String nombreUsuario, String privilegio) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"UPDATE usuarios SET privilegio = ? WHERE nombreUsuario = ?");
			sentenciaSQL.setString(1, privilegio);
			sentenciaSQL.setString(2, nombreUsuario);
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se pudo modificar el tipo de cliente en la base de datos.", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando modificar el tipo de cliente.");
		}

		// Este Try-Catch es para cerrar la conexión y sus resultados.
		try {
			if (sentenciaSQL != null)
				sentenciaSQL.close();
			Conexion.crearInstancia().cerrarConexion();
		}

		catch (SQLException excepcion) {
			throw new SQLException("Error intentando cerrar la conexion a la base de datos", excepcion);
		}
	}

}