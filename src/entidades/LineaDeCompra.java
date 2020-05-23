package entidades;

public class LineaDeCompra {
	
	private int idProducto;
	private double cantidad;
	
	public LineaDeCompra(int idProducto, double cantidad) {
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getProducto() {
		return idProducto;
	}

	public void setProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
}