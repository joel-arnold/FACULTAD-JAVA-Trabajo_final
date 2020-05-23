package entidades;

import java.util.ArrayList;
import java.util.Date;

public class CompraCliente extends Compra{
	
	int idCliente;

	public CompraCliente() {
		super();
	}
	
	public CompraCliente(int id, Date fecha, double subtotal, double impuestos, double total,
			ArrayList<LineaDeCompra> lineasDeCompra, int idCliente) {
		super(id, fecha, subtotal, impuestos, total, lineasDeCompra);
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}