package entidades;

import java.util.ArrayList;
import java.util.Date;

public class CompraAProveedor extends Compra{
	
	private Proveedor proveedor;
	
	public CompraAProveedor(int id, String fecha, double subtotal, double impuestos, double total,
			ArrayList<LineaDeCompra> lineasDeCompra, Proveedor proveedor) {
		super(id, fecha, total, lineasDeCompra);
		this.proveedor = proveedor;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}