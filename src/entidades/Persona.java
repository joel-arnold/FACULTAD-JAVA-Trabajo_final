package entidades;

public class Persona extends EntidadMadre {

	private String tipoDocumento;
	private String documento;
	private String apellido;
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	
	public Persona() {
		super();
	}
	
	public Persona(String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico, String tipoDocumento, String documento, String apellido,
			String nombre, String nombreUsuario, String contrasena) {
		super(domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepartamento, telefono, correoElectronico);
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String dni) {
		this.documento = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
		
}