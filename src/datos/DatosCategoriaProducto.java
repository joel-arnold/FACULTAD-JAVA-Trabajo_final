package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.CategoriaProducto;
import entidades.Producto;
import extras.Excepcion;

public class DatosCategoriaProducto {

	public ArrayList<CategoriaProducto> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<CategoriaProducto> categorias = new ArrayList<CategoriaProducto>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM categoria_producto");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				CategoriaProducto categoria = new CategoriaProducto();
				
				categoria.setIdCategoria(resultado.getInt("id"));
				categoria.setNombre(resultado.getString("nombre"));
				categoria.setDescripcion(resultado.getString("descripcion"));
				
				categorias.add(categoria);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar las categorias");

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
		return categorias;
	}
	
	public void alta(CategoriaProducto categoria) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("INSERT INTO categoria_producto (nombre, descripcion) values (?,?)");
			sentenciaSQL.setString(1, categoria.getNombre());
			sentenciaSQL.setString(2, categoria.getDescripcion());
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando grabar la categoria en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando dar de alta la categoria");
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
					.prepareStatement("DELETE FROM categoria_producto WHERE id = ?");
			sentenciaSQL.setInt(1, id);
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("No se pudo borrar la categoria de la base de datos", excepcion);
		}
		
		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando borrar la categoria");
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
	
	public void modificacion(CategoriaProducto categoria) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("UPDATE categoria_producto SET nombre = ?, descripcion = ? WHERE id = ?");
			sentenciaSQL.setString(1, categoria.getNombre());
			sentenciaSQL.setString(2, categoria.getDescripcion());
			sentenciaSQL.setInt(3, categoria.getIdCategoria());
			sentenciaSQL.executeUpdate();
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando modificar la categoria en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando modificar la categoria");
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
