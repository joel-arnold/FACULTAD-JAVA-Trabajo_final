package extras;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosPersona;
import entidades.Cliente;
import entidades.Empleado;
import entidades.Persona;
import entidades.TipoCliente;
import logica.ControladorCliente;
import logica.ControladorEmpleado;
import logica.ControladorPersona;

public class DisparadorDePrueba {

	public static void main(String[] args) throws Excepcion, SQLException {

		ControladorEmpleado ce = new ControladorEmpleado();
		ArrayList<Empleado> ae = new ArrayList<Empleado>();
		
		
		try {
			ae = ce.buscarTodos();	
			for(int i=0;i<ae.size();i++) {
				System.out.println("\nId: " + ae.get(i).getId());
				System.out.println("Nombre: " + ae.get(i).getNombre() + " " + ae.get(i).getApellido());;
				System.out.println("Documento: " + ae.get(i).getTipoDocumento() + " " + ae.get(i).getDocumento());
				System.out.println("Cuil: " + ae.get(i).getCuil());
				System.out.println("Domicilio: " + ae.get(i).getDomicilioCalle() + " " + ae.get(i).getDomicilioNumero() + " - " + ae.get(i).getDomicilioPiso() + " - " + ae.get(i).getDomicilioDepartamento());
				System.out.println("Correo electrónico: " + ae.get(i).getCorreoElectronico());
				System.out.println("Telefono: " + ae.get(i).getTelefono());
				System.out.println("Nombre de usuario: " + ae.get(i).getNombreUsuario());
				System.out.println("Contraseña: " + ae.get(i).getContrasena());
				System.out.println("Privilegio de acceso: " + ae.get(i).getPrivilegio());
				System.out.println("\n   *********** ");
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
