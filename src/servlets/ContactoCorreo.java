package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import extras.EnviadorDeCorreo;
import extras.Excepcion;

@WebServlet("/ContactoCorreo")
public class ContactoCorreo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContactoCorreo() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String destinatario = "cesar.mecanico@gmail.com";
		String nombre = request.getParameter("nombre");
		String correoElectronico = request.getParameter("correoElectronico");
		String motivoConsulta = request.getParameter("motivoConsulta");
		String mensaje = request.getParameter("mensaje");
		String asunto = "Consulta de " + nombre + " desde el formulario de contacto";
		String cuerpo = "Motivo de la consulta: " + motivoConsulta + ".\n\n" + "Mensaje: " + mensaje + ".\n\nResponder a: " + correoElectronico;
		
		try {
			EnviadorDeCorreo edc = new EnviadorDeCorreo();
			edc.enviarCorreo(destinatario, asunto, cuerpo);
			sesion.setAttribute("huboError", null);
			response.sendRedirect("inicio.jsp");
		} catch (EmailException e) {
			sesion.setAttribute("huboError", "si");
			sesion.setAttribute("mensajeError", e.getMessage().toString());
			response.sendRedirect("error.jsp");
		}
	}

}