package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Proveedor;
import extras.Excepcion;
import logica.ControladorProveedor;

@WebServlet("/ProveedorModifica")
public class ProveedorModifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProveedorModifica() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorProveedor cp = new ControladorProveedor();
		int id = Integer.parseInt(request.getParameter("idModificar"));
		String razonSocial = request.getParameter("razonSocial");
		String cuit = request.getParameter("cuit");
		String calle = request.getParameter("calle");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String departamento = request.getParameter("departamento");
		String telefono = request.getParameter("telefono");
		String correoElectronico = request.getParameter("correoElectronico");
		Proveedor proveedor = new Proveedor(calle, numero, piso, departamento, telefono, correoElectronico,
				razonSocial, cuit);
		proveedor.setId(id);
		try {
			cp.modificacion(proveedor);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("proveedoresAdmin.jsp");
		} catch (SQLException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			sesion.setAttribute("causaError", e.getCause());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}
	}

}
