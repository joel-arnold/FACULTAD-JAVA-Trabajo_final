package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import extras.Excepcion;
import logica.ControladorEmpleado;

@WebServlet("/PrivilegioModifica")
public class PrivilegioModifica extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrivilegioModifica() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorEmpleado ce = new ControladorEmpleado();
		String usuario = request.getParameter("usuarioModificar");
		String privilegio = request.getParameter("listaPrivilegios");
		
		try {
			ce.modificarPrivilegio(usuario, privilegio);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("privilegioAdmin.jsp");
		} catch (SQLException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			sesion.setAttribute("causaError", e.getCause().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getErrorOficialPila().toString());
			response.sendRedirect("error.jsp");
		}
	}

}
