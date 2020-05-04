package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.TipoCliente;
import extras.Excepcion;
import logica.ControladorTipoCliente;

@WebServlet("/TcAlta")
public class TcAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TcAlta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorTipoCliente ctc = new ControladorTipoCliente();
		String descripcion = (String)request.getParameter("descripcion");
		float porcentaje = Float.parseFloat(request.getParameter("porcentaje"));
		TipoCliente tc = new TipoCliente(descripcion, porcentaje);
		try {
			ctc.alta(tc);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("tcAdmin.jsp");
		} catch (SQLException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}
		
	}

}
