package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import entidades.*;
import extras.Excepcion;
import logica.*;

@WebServlet("/ClienteBuscaUno")
public class CliBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CliBuscar() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);
		ControladorCliente cc = new ControladorCliente();
		Cliente cliente = new Cliente();
		String clientico = request.getParameter("cliente");

		try {
			cliente = cc.buscarUno(clientico, (String)request.getParameter("nombre"));

			System.out.println(clientico);
			sesion.setAttribute("nombre", cliente.getNombre());
			sesion.setAttribute("apellido", cliente.getApellido());
			sesion.setAttribute("telefono", cliente.getTelefono());
			sesion.setAttribute("mensaje", null);
			System.out.println(sesion.getAttribute("telefono"));
			response.sendRedirect("vistas/encontrado.jsp");

		} catch (SQLException e) {
			sesion.setAttribute("mensaje", e.getMessage());
		} catch (Excepcion e) {
			sesion.setAttribute("mensaje", e.getErrorOficial());
		}
	}

}