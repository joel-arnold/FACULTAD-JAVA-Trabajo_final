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
			String nombre = (String) sesion.getAttribute("nombre");
			if (nombre == null) {
				response.getWriter().print("No hay ningún usuario logueado.");
			} else {
				sesion.invalidate();
				response.sendRedirect("inicio.jsp");
			}
		} catch (Exception e) {
			System.out.println("Mensaje de error: " + e.getMessage());
			System.out.println("\nCausa de error: " + e.getLocalizedMessage());
		}
	}
	
}