package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SesionCierre")
public class SesionCierre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SesionCierre() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		try {
			if (sesion.getAttribute("nombreUsuario") != null) {
				sesion.invalidate();
				response.sendRedirect("inicio.jsp");
			} else {
				sesion.setAttribute("huboError", "si");
				sesion.setAttribute("mensajeError", "No hay ningún usuario logueado");
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage());
			sesion.setAttribute("causaError", e.getCause().toString());
			response.sendRedirect("error.jsp");
		}
	}

}