package extras;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import datos.Conexion;

public class DisparadorProductoPrueba {
	
	public static void main(String[] args) throws Excepcion, SQLException {
	
	PreparedStatement sentenciaSQL = null;

	try {
		sentenciaSQL = Conexion.crearInstancia().abrirConexion()
				.prepareStatement("INSERT INTO categoria_producto (nombre, descripcion) values (?,?)");
		sentenciaSQL.setString(1, "unaa");
		sentenciaSQL.setString(2, "pba");
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
