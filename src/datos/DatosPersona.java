package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Persona;
import extras.Excepcion;

public class DatosPersona {
	

	public int buscarIDUsuario(String usuario, String contrasena) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		int idUsuario = 0;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM usuarios WHERE nombreUsuario = ? AND contrasena = ?");
			sentenciaSQL.setString(1, usuario);
			sentenciaSQL.setString(2, contrasena);
			resultado = sentenciaSQL.executeQuery();
			
			if (resultado != null && resultado.next()) {
				idUsuario = resultado.getInt("id");
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar la persona");

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
		return idUsuario;
	}
	
	public String buscarPrivilegio(int idUsuario) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		String privilegio = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM usuarios WHERE id = ?");
			sentenciaSQL.setInt(1, idUsuario);
			resultado = sentenciaSQL.executeQuery();
						
			if (resultado != null && resultado.next()) {
				privilegio = resultado.getString("privilegio");
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar la persona");

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
		return privilegio;
	}
	
}