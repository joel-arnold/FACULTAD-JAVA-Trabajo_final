package entidades;

public class Cliente extends Persona {

	private String tipo;
	private static final Privilegio privilegio = Privilegio.CLIENTE;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico, String tipoDocumento, String documento, String apellido,
			String nombre, String nombreUsuario, String contrasena, String tipo) {
		super(domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepartamento, telefono, correoElectronico, tipoDocumento, documento,
				apellido, nombre, nombreUsuario, contrasena);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Privilegio getPrivilegio() {
		return privilegio;
	}

}