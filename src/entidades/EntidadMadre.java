package entidades;

public class EntidadMadre {

	private int id;
	private String domicilioCalle;
	private String domicilioNumero;
	private String domicilioPiso;
	private String domicilioDepartamento;
	private String telefono;
	private String correoElectronico;
	
	public EntidadMadre() {
		
	}
	
	public EntidadMadre(String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico) {
		this.domicilioCalle = domicilioCalle;
		this.domicilioNumero = domicilioNumero;
		this.domicilioPiso = domicilioPiso;
		this.domicilioDepartamento = domicilioDepartamento;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDomicilioCalle() {
		return domicilioCalle;
	}
	public void setDomicilioCalle(String domicilioCalle) {
		this.domicilioCalle = domicilioCalle;
	}
	public String getDomicilioNumero() {
		return domicilioNumero;
	}
	public void setDomicilioNumero(String domicilioNumero) {
		this.domicilioNumero = domicilioNumero;
	}
	public String getDomicilioPiso() {
		return domicilioPiso;
	}
	public void setDomicilioPiso(String domicilioPiso) {
		this.domicilioPiso = domicilioPiso;
	}
	public String getDomicilioDepartamento() {
		return domicilioDepartamento;
	}
	public void setDomicilioDepartamento(String domicilioDepartamento) {
		this.domicilioDepartamento = domicilioDepartamento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
		
}