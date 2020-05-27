package extras;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviadorDeCorreo {

	public void enviarCorreo(String destinatario, String asunto, String cuerpo) throws EmailException {
		String remitente = "ar.joelarnold@yahoo.com.ar";
		String usuario = "ar.joelarnold@yahoo.com.ar";
		String contrasena = "upcsnhowluipmqhl";

		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.mail.yahoo.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(usuario, contrasena));
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);
			email.setFrom(remitente);
			email.setSubject(asunto);
			email.setMsg(cuerpo);
			email.addTo(destinatario);
			email.send();
		} catch (EmailException e) {
			throw new EmailException();
		}

	}
}