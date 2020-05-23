package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompraCliente")
public class CompraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompraCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		System.out.println("El cliente es: " + sesion.getAttribute("nombreUsuario"));
		
		int i = 0;
				
		while((request.getParameter(String.valueOf(i)) != null)) {
			String item = request.getParameter(String.valueOf(i));
			int idProducto = Integer.parseInt(request.getParameter("id" + String.valueOf(i)));
			int cantidad = Integer.parseInt(request.getParameter("cantidad" + String.valueOf(i)));
			i++;
			System.out.println("**********");
			System.out.println("Item Nº: " + item);
			System.out.println("ID de producto: " + idProducto);
			System.out.println("Cantidad: " + cantidad);
			System.out.println("************");
		}
		
		if((request.getParameter("inputTotal")) != null){
			Double total = Double.parseDouble(request.getParameter("inputTotal"));
			System.out.println("El total es: " + total);
		}
		
		
	}
}
