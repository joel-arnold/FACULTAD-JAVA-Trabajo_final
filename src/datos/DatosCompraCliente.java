package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.CompraCliente;
import extras.Excepcion;

public class DatosCompraCliente {

	public int compra(CompraCliente compraCliente) throws SQLException, Excepcion {
		PreparedStatement sentenciaSQL = null;
		ResultSet resultado = null;
		int nroCompra = 0;

		try {
			sentenciaSQL = Conexion.crearInstancia().abrirConexion().prepareStatement(
					"INSERT INTO compra_cliente (total, cliente) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			//sentenciaSQL.setDate(0, compraCliente.getFecha());
			sentenciaSQL.setDouble(1, compraCliente.getTotal());
			sentenciaSQL.setInt(2, compraCliente.getIdCliente());
			sentenciaSQL.executeUpdate();
			resultado = sentenciaSQL.getGeneratedKeys();
			

			if (resultado != null && resultado.next()) {
				nroCompra = resultado.getInt(1);
				
				for( int i = 0; i < compraCliente.getLineasDeCompra().size(); i++) {
					sentenciaSQL = Conexion.crearInstancia().abrirConexion()
							.prepareStatement("INSERT INTO linea_compra_cliente (idCompra, "
								+ "idProducto, cantidad) values (?,?,?)");
					
					sentenciaSQL.setInt(1, nroCompra);
					sentenciaSQL.setInt(2, compraCliente.getLineasDeCompra().get(i).getProducto());
					sentenciaSQL.setDouble(3, compraCliente.getLineasDeCompra().get(i).getCantidad());
					sentenciaSQL.executeUpdate();
				}
			}
		}
		
		// Estos 2 "Catch" son para el "Try" principal (donde estï¿½ la consulta a la base
		// de datos)
		catch (SQLException excepcion) {
			throw new SQLException("Algo salió mal intentando grabar la compra en la base de datos", excepcion);
		}

		catch (Excepcion excepcion) {
			throw new Excepcion(excepcion, "Algo salió mal intentando registrar la compra");
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
		return nroCompra;
	}

}
