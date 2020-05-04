package entidades;

public class Empleado extends Persona {

	private String privilegio;
	private String cuil;
	
	public Empleado() {
		
	}
	
	public Empleado(String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico, String tipoDocumento, String documento, String apellido,
			String nombre, String nombreUsuario, String contrasena, String privilegio, String cuil) {
		super(domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepartamento, telefono, correoElectronico, tipoDocumento, documento,
				apellido, nombre, nombreUsuario, contrasena);
		this.privilegio = privilegio;
		this.cuil = cuil;
	}
	
	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	
}