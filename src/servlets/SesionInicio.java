package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

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
		ControladorPersona cp = new ControladorPersona();
		int idUsuario;
		String privilegio = null;

		try {
			String usuario = request.getParameter("usuario");
			String contrasenaEncriptada = DigestUtils.md5Hex(request.getParameter("contrasena"));

			idUsuario = cp.buscarIDUsuario(usuario, contrasenaEncriptada);
			privilegio = cp.buscarPrivilegio(idUsuario);

			if (privilegio != null) {
				if (privilegio.equalsIgnoreCase("CLIENTE")) {
					ControladorCliente cc = new ControladorCliente();
					Cliente cliente = new Cliente();
					cliente = cc.buscarPorIDUsuario(idUsuario);
					sesion.setAttribute("idPersona", cliente.getId());
					sesion.setAttribute("nombreUsuario", cliente.getNombreUsuario());
					sesion.setAttribute("nombre", cliente.getNombre());
					sesion.setAttribute("apellido", cliente.getApellido());
					sesion.setAttribute("tipoDoc", cliente.getTipoDocumento());
					sesion.setAttribute("documento", cliente.getDocumento());
					sesion.setAttribute("domicilioCalle", cliente.getDomicilioCalle());
					sesion.setAttribute("domicilioNumero", cliente.getDomicilioNumero());
					sesion.setAttribute("domicilioPiso", cliente.getDomicilioPiso());
					sesion.setAttribute("domicilioDepto", cliente.getDomicilioDepartamento());
					sesion.setAttribute("telefono", cliente.getTelefono());
					sesion.setAttribute("correoElectronico", cliente.getCorreoElectronico());
					sesion.setAttribute("tipoCliente", cliente.getTipo());
					sesion.setAttribute("privilegio", "CLIENTE");
					response.sendRedirect("inicio.jsp");
				} else if (privilegio.equalsIgnoreCase("EMPLEADO") || privilegio.equalsIgnoreCase("SUPERUSUARIO")
						|| privilegio.equalsIgnoreCase("ADMINISTRADOR")) {
					ControladorEmpleado ce = new ControladorEmpleado();
					Empleado empleado = new Empleado();
					empleado = ce.buscarPorIDUsuario(idUsuario);
					sesion.setAttribute("idPersona", empleado.getId());
					sesion.setAttribute("nombreUsuario", empleado.getNombreUsuario());
					sesion.setAttribute("nombre", empleado.getNombre());
					sesion.setAttribute("apellido", empleado.getApellido());
					sesion.setAttribute("tipoDoc", empleado.getTipoDocumento());
					sesion.setAttribute("documento", empleado.getDocumento());
					sesion.setAttribute("cuil", empleado.getCuil());
					sesion.setAttribute("domicilioCalle", empleado.getDomicilioCalle());
					sesion.setAttribute("domicilioNumero", empleado.getDomicilioNumero());
					sesion.setAttribute("domicilioPiso", empleado.getDomicilioPiso());
					sesion.setAttribute("domicilioDepto", empleado.getDomicilioDepartamento());
					sesion.setAttribute("telefono", empleado.getTelefono());
					sesion.setAttribute("correoElectronico", empleado.getCorreoElectronico());
					if (privilegio.equalsIgnoreCase("EMPLEADO")) {
						sesion.setAttribute("privilegio", "EMPLEADO");
					} else if (privilegio.equalsIgnoreCase("ADMINISTRADOR")) {
						sesion.setAttribute("privilegio", "ADMINISTRADOR");
					} else if (privilegio.equalsIgnoreCase("SUPERUSUARIO")) {
						sesion.setAttribute("privilegio", "SUPERUSUARIO");
					}					
					response.sendRedirect("inicio.jsp");
				}
			} else {
				sesion.setAttribute("huboError", "si");
				sesion.setAttribute("mensajeError", "Usuario inexistente o contraseña incorrecta.");
				sesion.setAttribute("causaError", null);
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