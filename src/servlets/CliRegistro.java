package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cliente;
import extras.Excepcion;
import logica.ControladorCliente;
import logica.ControladorPersona;

@WebServlet("/CliRegistro")
public class CliRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CliRegistro() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorCliente cc = new ControladorCliente();
		ControladorPersona cp = new ControladorPersona();
		String usuarioElegido = request.getParameter("usuario");
		String contrasena1 = request.getParameter("contrasena1");
		String contrasena2 = request.getParameter("contrasena2");
		String apellido = request.getParameter("apellido");
		String nombre = request.getParameter("nombre");
		String tipoDoc = request.getParameter("tipoDoc");
		String nroDocumento = request.getParameter("documento");
		String calle = request.getParameter("domicilioCalle");
		String numeroCalle = request.getParameter("domicilioNumero");
		String piso = request.getParameter("domicilioPiso");
		String departamento = request.getParameter("domicilioDepto");
		String telefono = request.getParameter("telefono");
		String correoElectronico = request.getParameter("correoElectronico");

		try {
			if (!cp.existeUsuario(usuarioElegido)) {
				Cliente cliente = new Cliente(calle, numeroCalle, piso, departamento, telefono, correoElectronico,
						tipoDoc, nroDocumento, apellido, nombre, usuarioElegido, contrasena1, "Común");
				cc.alta(cliente);
				response.sendRedirect("inicio.jsp");
			} else {
				sesion.setAttribute("mensajeError", "El nombre de usuario elegido ya existe");
				sesion.setAttribute("huboError", "si");
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
