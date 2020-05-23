package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.CompraCliente;
import entidades.LineaDeCompra;
import extras.Excepcion;
import logica.ControladorCompracliente;

@WebServlet("/CompraCliente")
public class CompraDelCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompraDelCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		int idCliente = (int) sesion.getAttribute("idPersona");
		double total = Double.parseDouble(request.getParameter("inputTotal"));
		ArrayList<LineaDeCompra> lineasCompra = new ArrayList<LineaDeCompra>();
		CompraCliente cc = new CompraCliente();
		ControladorCompracliente ccc = new ControladorCompracliente();
		int i = 0;

		while((request.getParameter(String.valueOf(i)) != null)) {
			
			int idProducto = Integer.parseInt(request.getParameter("id" + String.valueOf(i)));
			double cantidad = Double.parseDouble(request.getParameter("cantidad" + String.valueOf(i)));
			LineaDeCompra lineaCompra = new LineaDeCompra(idProducto, cantidad);
			lineasCompra.add(lineaCompra);		
			i++;
		}
		
		cc.setTotal(total);
		cc.setIdCliente(idCliente);
		cc.setLineasDeCompra(lineasCompra);

		try {
			ccc.compra(cc);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("inicio.jsp");
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
