package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Venta;
import extras.Excepcion;

public class DatosVenta {
	
	public ArrayList<Venta> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Venta> ventas = new ArrayList<Venta>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT * FROM compra_cliente cc LEFT JOIN clientes c ON cc.cliente = c.id");
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {
				Venta venta = new Venta();
				
				venta.setId(resultado.getInt("cc.id"));
				venta.setFecha(resultado.getString("cc.fecha"));
				venta.setTotal(resultado.getDouble("cc.total"));
				venta.setId_cliente(resultado.getInt("c.id"));
				venta.setNombre_cliente(resultado.getString("c.nombre"));
				venta.setApellido_cliente(resultado.getString("c.apellido"));
				
				ventas.add(venta);
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
		return ventas;
	}

}
