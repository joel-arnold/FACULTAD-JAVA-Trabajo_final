package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import extras.Excepcion;
import logica.ControladorProveedor;

@WebServlet("/ProveedorElimina")
public class ProveedorElimina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProveedorElimina() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		ControladorProveedor cp = new ControladorProveedor();
		int id = Integer.parseInt(request.getParameter("idEliminar"));
		
		try {
			cp.baja(id);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("proveedoresAdmin.jsp");
		} catch (SQLException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			sesion.setAttribute("causaError", e.getCause().toString());
			response.sendRedirect("error.jsp");
		} catch (Excepcion e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMensajeDeError());
			sesion.setAttribute("causaError", e.getErrorOficialPila().toString());
			response.sendRedirect("error.jsp");
		}
	}

}
