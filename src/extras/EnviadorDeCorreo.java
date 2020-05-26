package extras;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviadorDeCorreo {
	
	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    final String remitente = "joel.arnold.ar@gmail.com";  //Para la dirección nomcuenta@gmail.com
	    final String clave = "k-n3b3P1355"; 

	    Properties props = new Properties();

		 // Nombre del host de correo, es smtp.gmail.com
		 props.setProperty("mail.smtp.host", "smtp.gmail.com");
	
		 // TLS si está disponible
		 props.setProperty("mail.smtp.starttls.enable", "true");
	
		 // Puerto de gmail para envio de correos
		 props.setProperty("mail.smtp.port","587");
	
		 // Nombre del usuario
		 props.setProperty("mail.smtp.user", "joel.arnold.ar@gmail.com");
	
		 // Si requiere o no usuario y password para conectarse.
		 props.setProperty("mail.smtp.auth", "true");
	
		 Session session = Session.getDefaultInstance(props);

	    
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, clave);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	
	/* ********************************************* */
	
//	private final Properties properties = new Properties();
//	
//	private String contrasena ="k-n3b3P1355";
// 
//	private Session session;
// 
//	private void init() {
// 
//		properties.put("mail.smtp.host", "mail.gmail.com");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.port",25);
//		properties.put("mail.smtp.mail.sender","joel.arnold.ar@gmail.com");
//		properties.put("mail.smtp.user", "joel.arnold.ar");
//		properties.put("mail.smtp.auth", "true");
// 
//		session = Session.getDefaultInstance(properties);
//	}
// 
//	public void sendEmail(){
// 
//		init();
//		try{
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress("joelarnold@hotmail.com.ar"));
//			message.setSubject("Asunto de prueba");
//			message.setText("Texto del cuerpo");
//			Transport t = session.getTransport("smtp");
//			t.connect((String)properties.get("mail.smtp.user"), contrasena);
//			t.sendMessage(message, message.getAllRecipients());
//			t.close();
//		}catch (MessagingException me){
//			System.out.println("Fallo algo");
//		}
//		
//	}
	
}