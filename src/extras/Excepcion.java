package extras;

@SuppressWarnings("serial")
public class Excepcion extends Exception{

	private String mensajeDeError;
	private String errorOficial;
	private String errorOficialPila;

	public Excepcion(String mensajeDeError) {
		// Manejo solo el mensaje personalizado
		this.mensajeDeError = mensajeDeError;
	}
	
	public Excepcion(Throwable excepcion) {
		// Tomo el mensaje original de la excepcion
		this.errorOficial = excepcion.getMessage();
		this.errorOficialPila = excepcion.getStackTrace().toString();
	}
	
	public Excepcion(Throwable excepcion, String mensajeDeError) {
		// Recupero ambos mensajes: el de la excepcion y el personalizado + la pila de errores
		this.mensajeDeError = mensajeDeError;
		this.errorOficial = excepcion.getMessage();
		this.errorOficialPila = excepcion.getStackTrace().toString();
	}

	public String getMensajeDeError() {
		return mensajeDeError;
	}

	public void setMensajeDeError(String mensajeDeError) {
		this.mensajeDeError = mensajeDeError;
	}

	public String getErrorOficial() {
		return errorOficial;
	}

	public void setErrorOficial(String errorOficial) {
		this.errorOficial = errorOficial;
	}

	public String getErrorOficialPila() {
		return errorOficialPila;
	}

	public void setErrorOficialPila(String errorOficialPila) {
		this.errorOficialPila = errorOficialPila;
	}
	
}