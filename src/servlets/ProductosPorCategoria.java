package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import extras.Excepcion;
import logica.ControladorProducto;

@WebServlet("/ProductosPorCategoria")
public class ProductosPorCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductosPorCategoria() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String categoria = request.getParameter("categoria");
		ControladorProducto cp = new ControladorProducto();
		final Gson gson = new Gson();
		
		try {
			String representacionJSON;
			if(categoria == "") {
				representacionJSON = gson.toJson(cp.buscarTodos());
			} else {
				representacionJSON = gson.toJson(cp.buscarPorCategoria(categoria));
			}
			PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(representacionJSON);
	        out.flush();   
		} catch (SQLException excepcion) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", excepcion.getMessage().toString());
			sesion.setAttribute("causaError", excepcion.getCause().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMensajeDeError());
			sesion.setAttribute("causaError", e.getCause().toString());
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}