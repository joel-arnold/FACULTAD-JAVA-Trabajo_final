package entidades;

public class Proveedor extends EntidadMadre {

	private String razonSocial;
	private String cuit;
	private String direccionWeb;
	
	public Proveedor(int id, String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico, String razonSocial, String cuit, String direccionWeb) {
		super(domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepartamento, telefono, correoElectronico);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.direccionWeb = direccionWeb;
	}
	
	public Proveedor(int id, String domicilioCalle, String domicilioNumero, String domicilioPiso,
			String domicilioDepartamento, String telefono, String correoElectronico, String razonSocial, String cuit) {
		super(domicilioCalle, domicilioNumero, domicilioPiso, domicilioDepartamento, telefono, correoElectronico);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccionWeb() {
		return direccionWeb;
	}

	public void setDireccionWeb(String direccionWeb) {
		this.direccionWeb = direccionWeb;
	}

}