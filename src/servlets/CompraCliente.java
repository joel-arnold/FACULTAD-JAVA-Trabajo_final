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
		String item0 = (String) request.getParameter("0").toString();
		String item1 = (String) request.getParameter("1").toString();
		
		System.out.println(item0);
		System.out.println(item1);
		

	}

}
