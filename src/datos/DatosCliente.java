package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;
import extras.Excepcion;

public class DatosCliente {

	public void alta(Cliente cliente) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		int idTipoCliente, idUsuario;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM forrajeria.tipo_cliente WHERE descripcion = ?");
			sentenciaSQL.setString(1, cliente.getTipo());
			resultado = sentenciaSQL.executeQuery();
			
			if (resultado != null && resultado.next()) {
				sentenciaSQL = Conexion.crearInstancia().abrirConexion()
						.prepareStatement("INSERT INTO usuarios (nombreUsuario, contrasena, privilegio)"
								+ "values (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				sentenciaSQL.setString(1, cliente.getNombreUsuario());
				sentenciaSQL.setString(2, cliente.getContrasena());
				sentenciaSQL.setString(3, "CLIENTE");
				sentenciaSQL.executeUpdate();
				resultado = sentenciaSQL.getGeneratedKeys();
				if(resultado!=null && resultado.next()){
					idUsuario = resultado.getInt(1);
				}
				
				// SEGUIR VIENDO ACÁ
			}

			if (resultado != null && resultado.next()) {
				idTipoCliente = resultado.getInt(1);

				sentenciaSQL = Conexion.crearInstancia().abrirConexion()
						.prepareStatement("INSERT INTO clientes (nombre, apellido, tipoDoc, documento, "
								+ "domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepto, "
								+ "telefono, correoElectronico, tipo_cliente, usuario)\r\n"
								+ "values (?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				sentenciaSQL.setString(1, cliente.getNombre());
				sentenciaSQL.setString(2, cliente.getApellido());
				sentenciaSQL.setString(3, cliente.getTipoDocumento());
				sentenciaSQL.setString(4, cliente.getDocumento());
				sentenciaSQL.setString(5, cliente.getDomicilioCalle());
				sentenciaSQL.setString(6, cliente.getDomicilioNumero());
				sentenciaSQL.setString(7, cliente.getDomicilioPiso());
				sentenciaSQL.setString(8, cliente.getDomicilioDepartamento());
				sentenciaSQL.setString(9, cliente.getTelefono());
				sentenciaSQL.setString(10, cliente.getCorreoElectronico());
				sentenciaSQL.setString(11, cliente.getTipo());
				sentenciaSQL.setInt(12, 1);
				sentenciaSQL.executeUpdate();

			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando grabar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando dar de alta el cliente");
		}

		// Este Try-Catch es para cerrar la conexión y sus resultados.
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
	}

	public Cliente buscarUno(String apellido, String nombre) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		Cliente cliente = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM clientes c LEFT JOIN usuarios u ON c.usuario = u.id "
					+ "LEFT JOIN tipo_cliente tc ON c.tipo_cliente = tc.id WHERE apellido = ? "
					+ "AND nombre = ?");
			sentenciaSQL.setString(1, apellido);
			sentenciaSQL.setString(2, nombre);
			resultado = sentenciaSQL.executeQuery();

			if (resultado != null && resultado.next()) {
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTipoDocumento(resultado.getString("tipoDoc"));
				cliente.setDocumento(resultado.getString("documento"));
				cliente.setDomicilioCalle(resultado.getString("domicilioCalle"));
				cliente.setDomicilioNumero(resultado.getString("domicilioNumero"));
				cliente.setDomicilioPiso(resultado.getString("domicilioPiso"));
				cliente.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setCorreoElectronico(resultado.getString("correoElectronico"));
				cliente.setTipo(resultado.getString("descripcion"));
				cliente.setNombreUsuario(resultado.getString("nombreUsuario"));
				cliente.setContrasena(resultado.getString("contrasena"));
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
		return cliente;
	}
	
	public Cliente buscarPorIDUsuario(int id) throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		Cliente cliente = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM clientes c LEFT JOIN usuarios u ON c.usuario = u.id "
					+ "LEFT JOIN tipo_cliente tc ON c.tipo_cliente = tc.id WHERE u.id = ?");
			sentenciaSQL.setInt(1, id);
			resultado = sentenciaSQL.executeQuery();

			if (resultado != null && resultado.next()) {
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTipoDocumento(resultado.getString("tipoDoc"));
				cliente.setDocumento(resultado.getString("documento"));
				cliente.setDomicilioCalle(resultado.getString("domicilioCalle"));
				cliente.setDomicilioNumero(resultado.getString("domicilioNumero"));
				cliente.setDomicilioPiso(resultado.getString("domicilioPiso"));
				cliente.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setCorreoElectronico(resultado.getString("correoElectronico"));
				cliente.setTipo(resultado.getString("descripcion"));
				cliente.setNombreUsuario(resultado.getString("nombreUsuario"));
				cliente.setContrasena(resultado.getString("contrasena"));
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
		return cliente;
	}

	public ArrayList<Cliente> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM clientes c LEFT JOIN usuarios u ON c.usuario = u.id "
					+ "LEFT JOIN tipo_cliente tc ON c.tipo_cliente = tc.id");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setApellido(resultado.getString("apellido"));
				cliente.setTipoDocumento(resultado.getString("tipoDoc"));
				cliente.setDocumento(resultado.getString("documento"));
				cliente.setDomicilioCalle(resultado.getString("domicilioCalle"));
				cliente.setDomicilioNumero(resultado.getString("domicilioNumero"));
				cliente.setDomicilioPiso(resultado.getString("domicilioPiso"));
				cliente.setDomicilioDepartamento(resultado.getString("domicilioDepto"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setCorreoElectronico(resultado.getString("correoElectronico"));
				cliente.setTipo(resultado.getString("descripcion"));
				cliente.setNombreUsuario(resultado.getString("nombreUsuario"));
				cliente.setContrasena(resultado.getString("contrasena"));
				clientes.add(cliente);
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
		return clientes;
	}
}