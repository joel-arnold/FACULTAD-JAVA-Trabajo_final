package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Producto;
import extras.Excepcion;

public class DatosProducto {

	public ArrayList<Producto> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Producto> productos = new ArrayList<Producto>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM productos p LEFT JOIN categoria_producto cp ON p.categoria = cp.id");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				Producto producto = new Producto();
				
				producto.setId(resultado.getInt("id"));
				producto.setCodigo(resultado.getString("codigo"));
				producto.setNombre(resultado.getString("p.nombre"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setTamaño(resultado.getDouble("tamano"));
				producto.setUnidadMedida(resultado.getString("unidadMedida"));
				producto.setPrecioVenta(resultado.getDouble("precioVenta"));
				producto.setCategoria(resultado.getString("cp.nombre"));
				producto.setImagen(resultado.getString("imagen"));
				
				productos.add(producto);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar los productos");

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
		return productos;
	}

}
