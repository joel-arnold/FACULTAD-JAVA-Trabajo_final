package entidades;

import java.util.ArrayList;
import java.util.Date;

public class CompraCliente extends Compra{

	private Cliente cliente;
	
	public CompraCliente(int id, Date fecha, double subtotal, double impuestos, double total,
			ArrayList<LineaDeCompra> lineasDeCompra, Cliente cliente) {
		super(id, fecha, subtotal, impuestos, total, lineasDeCompra);
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}