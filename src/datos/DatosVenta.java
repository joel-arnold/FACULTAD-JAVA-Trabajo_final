package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.LineaDeVenta;
import entidades.Venta;
import extras.Excepcion;

public class DatosVenta {

	public ArrayList<Venta> buscarTodos() throws SQLException, Excepcion {
		ResultSet resultado = null;
		PreparedStatement sentenciaSQL = null;
		ArrayList<Venta> ventas = new ArrayList<Venta>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion()
					.prepareStatement("SELECT * FROM compra_cliente cc LEFT JOIN clientes c ON cc.cliente = c.id ORDER BY cc.id DESC");
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
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar las ventas");

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

	public Venta buscarVentaDetallada(int idCompra) throws SQLException, Excepcion {
		ResultSet resultado = null;
		ResultSet resultado2 = null;
		PreparedStatement sentenciaSQL = null;
		Venta venta = new Venta();
		ArrayList<LineaDeVenta> lineasDeVenta = new ArrayList<LineaDeVenta>();

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"SELECT cc.id, cc.fecha, cc.total, c.id, c.nombre, c.apellido, " +
					"c.telefono, c.correoElectronico, c.domicilioCalle, c.domicilioNumero, " +
					"c.domicilioPiso, c.domicilioDepto FROM compra_cliente cc LEFT JOIN clientes " +
					"c ON cc.cliente = c.id WHERE cc.id = ?");
			sentenciaSQL.setInt(1, idCompra);
			resultado = sentenciaSQL.executeQuery();

			while (resultado.next()) {

				venta.setId(resultado.getInt("cc.id"));
				venta.setFecha(resultado.getString("cc.fecha"));
				venta.setTotal(resultado.getDouble("cc.total"));
				venta.setId_cliente(resultado.getInt("c.id"));
				venta.setNombre_cliente(resultado.getString("c.nombre"));
				venta.setApellido_cliente(resultado.getString("c.apellido"));
				venta.setTelefono(resultado.getString("c.telefono"));
				venta.setCorreoElectronico(resultado.getString("c.correoElectronico"));
				venta.setDomicilioCalle(resultado.getString("c.domicilioCalle"));
				venta.setDomicilioNumero(resultado.getString("c.domicilioNumero"));
				venta.setDomicilioPiso(resultado.getString("c.domicilioPiso"));
				venta.setDomicilioDpto(resultado.getString("c.domicilioDepto"));
				
				sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
						"SELECT lcc.idProducto, lcc.cantidad, p.nombre, p.precioVenta FROM " +
						"compra_cliente cc LEFT JOIN linea_compra_cliente lcc ON cc.id = lcc.idCompra " +
						"LEFT JOIN productos p ON lcc.idProducto = p.id WHERE cc.id = ?");
				sentenciaSQL.setInt(1, idCompra);
				resultado2 = sentenciaSQL.executeQuery();
				
				while(resultado2.next()) {
					LineaDeVenta linea = new LineaDeVenta();
					linea.setIdProducto(resultado2.getInt("lcc.idProducto"));
					linea.setNombreProducto(resultado2.getString("p.nombre"));
					linea.setCantidad(resultado2.getDouble("lcc.cantidad"));
					linea.setPrecioUnitario(resultado2.getDouble("p.precioVenta"));
					
					lineasDeVenta.add(linea);
				}
				
				venta.setLineas(lineasDeVenta);
			}
		}

		// Estos 2 "Catch" son para el "Try" principal (donde está la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando buscar en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando buscar la venta");

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
		return venta;
	}

}