package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Empleado;
import extras.Excepcion;

public class DatosEmpleado {

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

}
