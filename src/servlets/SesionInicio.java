package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logica.*;
import entidades.*;
import extras.Excepcion;

@WebServlet("/SesionInicio")
public class SesionInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SesionInicio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		//Persona persona = new Persona();
		ControladorPersona cp = new ControladorPersona();
		int idUsuario;
		String privilegio = null;

		try {
			String usuario = request.getParameter("usuario");
			String contrasena = request.getParameter("contrasena");
			// PROBANDO: System.out.println("EL USUARIO s: " + usuario);
			// PROBANDO: System.out.println("LA CONTRASEÑA s: " + contrasena);

			idUsuario = cp.buscarIDUsuario(usuario, contrasena);
			privilegio = cp.buscarPrivilegio(idUsuario);
			// PROBANDO: System.out.println("Id usuario: " + idUsuario);
			// PROBANDO: System.out.println("Privilegio: " + privilegio);
			
			if(privilegio.equalsIgnoreCase("cliente")) {
				ControladorCliente cc = new ControladorCliente();
				Cliente cliente = new Cliente();
				cliente = cc.buscarPorIDUsuario(idUsuario);
				sesion.setAttribute("nombre", cliente.getNombre());
				sesion.setAttribute("apellido", cliente.getApellido());
				sesion.setAttribute("telefono", cliente.getTelefono());
				response.sendRedirect("inicio.jsp");
			} else {
				sesion.setAttribute("huboError", "si");
				sesion.setAttribute("mensajeError", "Existe algún problema con sus privilegios de acceso.");
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException excepcion) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", excepcion.getMessage().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}
	}
	
}