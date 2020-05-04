package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import extras.Excepcion;

public class Conexion {

	private String controladorBD = "com.mysql.cj.jdbc.Driver";
	private String anfitrion = "localhost";
	private String puerto = "3306";
	private String usuario = "root";
	private String contrasena = "root";
	private String tipoBD = "mysql";
	private String bd = "forrajeria";

	private static Conexion instanciaDeConexion;
	private Connection conexion;
	private int cantidadDeConexiones;

	private Conexion() throws Excepcion {
		try {
			Class.forName(controladorBD);
		} catch (ClassNotFoundException excepcion) {
			throw new Excepcion(excepcion, "Error con el Driver JDBC");
		}
	}

	public static Conexion crearInstancia() throws Excepcion {
		if (instanciaDeConexion == null) {
			instanciaDeConexion = new Conexion();
		}
		return instanciaDeConexion;
	}

	public Connection abrirConexion() throws SQLException, Excepcion {
		try {
			if (conexion == null || conexion.isClosed()) {
				conexion = DriverManager.getConnection("jdbc:" + tipoBD + "://" + anfitrion + ":" + puerto + "/" + bd
						+ "?user=" + usuario + "&password=" + contrasena);

				cantidadDeConexiones++;
			}
		} catch (SQLException excepcion) {
			throw new Excepcion(excepcion, "Error al conectar a la base de datos");

		}
		return conexion;
	}

	public void cerrarConexion() throws Excepcion {
		try {
			cantidadDeConexiones--;
			if (cantidadDeConexiones == 0) {
				conexion.close();
			}
		} catch (SQLException excepcion) {
			throw new Excepcion(excepcion, "Error al cerrar conexión");
		}
	}

}