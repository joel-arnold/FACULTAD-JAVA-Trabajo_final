package entidades;

public class TipoCliente {
	
	private int id;
	private String descripcion;
	private float porcentajeDescuento;
	
	public TipoCliente() {
		
	}
	
	public TipoCliente(int id, String descripcion, float porcentajeDescuento) {
		this.id = id;
		this.descripcion = descripcion;
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public TipoCliente(String descripcion, float porcentajeDescuento) {
		this.descripcion = descripcion;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
}