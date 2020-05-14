package extras;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import datos.Conexion;

public class DisparadorProductoPrueba {
	
	public static void main(String[] args) throws Excepcion, SQLException {
	
	PreparedStatement sentenciaSQL = null;

	try {
		sentenciaSQL = Conexion.crearInstancia().abrirConexion()
				.prepareStatement("INSERT INTO productos (codigo, nombre, descripcion, "
						+ "tamano, unidadMedida, precioVenta, categoria, imagen)"
						+ "values (?,?,?,?,?,?,?,?)");
		sentenciaSQL.setString(1, "14");
		sentenciaSQL.setString(2, "gati");
		sentenciaSQL.setString(3, "es de gato");
		sentenciaSQL.setDouble(4, 15);
		sentenciaSQL.setString(5, "kg");
		sentenciaSQL.setDouble(6, 900);
		sentenciaSQL.setString(7, "1");
		sentenciaSQL.setString(8, null);
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
}
