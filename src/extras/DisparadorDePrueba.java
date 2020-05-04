package extras;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosPersona;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Persona;
import entidades.TipoCliente;
import logica.ControladorCliente;
import logica.ControladorPersona;

public class DisparadorDePrueba {

	public static void main(String[] args) throws Excepcion, SQLException {

		Persona persona = new Persona();
		ControladorPersona cp = new ControladorPersona();
		int idUsuario;
		
		try {
			String usuario = "u99";
			String contrasena = "1";
			System.out.println("EL USUARIO: " + usuario);
			System.out.println("LA CONTRASEÑA: " + contrasena);
			
			idUsuario = cp.buscarIDUsuario(usuario, contrasena);
			
			System.out.println("ID ENCONTRADO: "+ idUsuario);
			
			
		
			if (persona instanceof Cliente) {
				
				
			} else if (persona instanceof Empleado) {
				
				
			}
			
			
		} catch (SQLException excepcion) {
			System.out.println("Mensaje personalizado: " + excepcion.getMessage());
			System.out.println("\nMensaje oficial: " + excepcion.getCause().toString());
		} catch (Excepcion e) {
			System.out.println("Mensaje propio: " + e.getMensajeDeError());
			System.out.println("\nMensaje de error oficial: " + e.getErrorOficial());
			System.out.println("\nPila del error: " + e.getErrorOficialPila());
		}
	}
}
