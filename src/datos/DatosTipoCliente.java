package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.*;
import extras.Excepcion;

public class DatosTipoCliente {

	public void alta(TipoCliente tipoCliente) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"INSERT INTO tipo_cliente (descripcion, porcentajeDescuento) VALUES (?, ?)");
			sentenciaSQL.setString(1, tipoCliente.getDescripcion());
			sentenciaSQL.setDouble(2, tipoCliente.getPorcentajeDescuento());
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se pudo grabar el tipo de cliente en la base de datos.", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando dar de alta el tipo de cliente.");
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

	public void baja(int id) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("DELETE FROM tipo_cliente WHERE id = ?");
			sentenciaSQL.setInt(1, id);
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se pudo borrar el tipo de cliente de la base de datos.", excepcion);
			
		}
		
		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando borrar el tipo de cliente.");
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

	public void modificacion(TipoCliente tipoCliente) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"UPDATE tipo_cliente SET descripcion = ?, porcentajeDescuento = ? WHERE id = ?");
			sentenciaSQL.setString(1, tipoCliente.getDescripcion());
			sentenciaSQL.setDouble(2, tipoCliente.getPorcentajeDescuento());
			sentenciaSQL.setInt(3, tipoCliente.getId());
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

	public ArrayList<TipoCliente> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<TipoCliente> tiposCliente = new ArrayList<TipoCliente>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement("SELECT * FROM tipo_cliente");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				TipoCliente tipoCliente = new TipoCliente();
				tipoCliente.setId(resultado.getInt("id"));
				tipoCliente.setDescripcion(resultado.getString("descripcion"));
				tipoCliente.setPorcentajeDescuento(resultado.getFloat("porcentajeDescuento"));
				tiposCliente.add(tipoCliente);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se puedieron encontrar los tipos de cliente de la base de datos.", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar los clientes.");

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
		return tiposCliente;
	}

}