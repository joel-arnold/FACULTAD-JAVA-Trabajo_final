package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

import entidades.CompraCliente;
import entidades.LineaDeCompra;
import extras.EnviadorDeCorreo;
import extras.Excepcion;
import logica.ControladorCompracliente;

@WebServlet("/CompraCliente")
public class CompraDelCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompraDelCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String correoElectronico = (String) sesion.getAttribute("correoElectronico");
		int idCliente = (int) sesion.getAttribute("idPersona");
		double total = Double.parseDouble(request.getParameter("inputTotal"));
		ArrayList<LineaDeCompra> lineasCompra = new ArrayList<LineaDeCompra>();
		CompraCliente cc = new CompraCliente();
		ControladorCompracliente ccc = new ControladorCompracliente();
		int i = 0;
		
		Date objetoFecha = new Date(); 
        SimpleDateFormat objetoFormatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = objetoFormatoFecha.format(objetoFecha);
        
		while ((request.getParameter(String.valueOf(i)) != null)) {

			int idProducto = Integer.parseInt(request.getParameter("id" + String.valueOf(i)));
			double cantidad = Double.parseDouble(request.getParameter("cantidad" + String.valueOf(i)));
			LineaDeCompra lineaCompra = new LineaDeCompra(idProducto, cantidad);
			lineasCompra.add(lineaCompra);
			i++;
		}

		cc.setTotal(total);
		cc.setIdCliente(idCliente);
		cc.setFecha(fecha);
		cc.setLineasDeCompra(lineasCompra);

		try {
			int nroCompra = ccc.compra(cc);
			sesion.setAttribute("huboError", null);
			sesion.setAttribute("nroCompra", nroCompra);
			String cuerpo = ("El número de su compra es: " + nroCompra
					+ ".\nEl total es: $" + total
					+ ".\nCuando el pedido esté listo, nos comunicaremos para coordinar la entrega."
					+ "\n\n¡Saludos!\nDe Pelos Mascotas");
			EnviadorDeCorreo edc = new EnviadorDeCorreo();
			try {
				edc.enviarCorreo(correoElectronico, "DE PELOS MASCOTAS: confirmación de compra", cuerpo);
			} catch (EmailException e) {
				sesion.setAttribute("huboError", "si");
				sesion.setAttribute("mensajeError", e.getMessage().toString());
				response.sendRedirect("error.jsp");
			}
			response.sendRedirect("compraConfirmacion.jsp");
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
