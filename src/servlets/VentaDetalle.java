package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Venta;
import extras.Excepcion;
import logica.ControladorCategoriaProducto;
import logica.ControladorVenta;

@WebServlet("/VentaDetalle")
public class VentaDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VentaDetalle() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		int idCompra = Integer.parseInt(request.getParameter("idCompra"));
		
		try {
			sesion.setAttribute("idCompra", idCompra);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("ventasDetalleAdmin.jsp");
		
		} catch (Exception e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}		
		
	}

}