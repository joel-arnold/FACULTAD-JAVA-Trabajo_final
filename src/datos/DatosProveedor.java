package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Proveedor;
import extras.Excepcion;

public class DatosProveedor {

	public ArrayList<Proveedor> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Proveedor> listado = new ArrayList<Proveedor>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement("SELECT * FROM proveedores");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				Proveedor proveedor = new Proveedor();
				proveedor.setId(resultado.getInt("id"));
				proveedor.setRazonSocial(resultado.getString("razonSocial"));
				proveedor.setCuit(resultado.getString("cuit"));
				proveedor.setDomicilioCalle(resultado.getString("domicilioCalle"));
				proveedor.setDomicilioNumero(resultado.getString("domicilioNumero"));
				proveedor.setDomicilioPiso(resultado.getString("domicilioPiso"));
				proveedor.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				proveedor.setCorreoElectronico(resultado.getString("correoElectronico"));
				proveedor.setTelefono(resultado.getString("telefono"));
				listado.add(proveedor);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar los proveedores en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar los proveedores");

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

	public void alta(Proveedor proveedor) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("INSERT INTO proveedores (razonSocial, cuit, domicilioCalle, "
							+ "domicilioNumero, domicilioPiso, domicilioDepto, telefono, correoElectronico)"
							+ "values (?,?,?,?,?,?,?,?)");
			sentenciaSQL.setString(1, proveedor.getRazonSocial());
			sentenciaSQL.setString(2, proveedor.getCuit());
			sentenciaSQL.setString(3, proveedor.getDomicilioCalle());
			sentenciaSQL.setString(4, proveedor.getDomicilioNumero());
			sentenciaSQL.setString(5, proveedor.getDomicilioPiso());
			sentenciaSQL.setString(6, proveedor.getDomicilioDepartamento());
			sentenciaSQL.setString(7, proveedor.getTelefono());
			sentenciaSQL.setString(8, proveedor.getCorreoElectronico());
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando grabar el proveedor en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando dar de alta el proveedor");
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
					.prepareStatement("DELETE FROM proveedores WHERE id = ?");
			sentenciaSQL.setInt(1, id);
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se pudo borrar el proveedor de la base de datos", excepcion);
		}
		
		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando borrar el proveedor");
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
	
	public void modificacion(Proveedor proveedor) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("UPDATE proveedores SET razonSocial = ?, cuit = ?, domicilioCalle = ?, "
							+ "domicilioNumero = ?, domicilioPiso = ?, domicilioDepto = ?, telefono = ?, "
							+ "correoElectronico = ? WHERE id = ? ");
			sentenciaSQL.setString(1, proveedor.getRazonSocial());
			sentenciaSQL.setString(2, proveedor.getCuit());
			sentenciaSQL.setString(3, proveedor.getDomicilioCalle());
			sentenciaSQL.setString(4, proveedor.getDomicilioNumero());
			sentenciaSQL.setString(5, proveedor.getDomicilioPiso());
			sentenciaSQL.setString(6, proveedor.getDomicilioDepartamento());
			sentenciaSQL.setString(7, proveedor.getTelefono());
			sentenciaSQL.setString(8, proveedor.getCorreoElectronico());
			sentenciaSQL.setInt(9, proveedor.getId());
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando modificar el proveedor en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando modificar el proveedor");
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