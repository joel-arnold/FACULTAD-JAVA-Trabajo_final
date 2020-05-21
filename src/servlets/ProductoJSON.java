package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import extras.Excepcion;
import logica.ControladorProducto;

@WebServlet("/ProductoJSON")
public class ProductoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductoJSON() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		JSONArray productosJSON = new JSONArray();
    	ControladorProducto cp = new ControladorProducto();
    	
    	// TODAVIA PROBANDO SOBRE ESTO... NO ESTA TERMINADO

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
