package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.CategoriaProducto;
import extras.Excepcion;
import logica.ControladorCategoriaProducto;
import logica.ControladorProducto;

@WebServlet("/CategoriaProductoAlta")
public class CategoriaProductoAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoriaProductoAlta() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorCategoriaProducto ccp = new ControladorCategoriaProducto();
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		
		CategoriaProducto categoriproducto = new CategoriaProducto(nombre, descripcion);
		try {
			ccp.alta(categoriproducto);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("categoriasProductoAdmin.jsp");
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
