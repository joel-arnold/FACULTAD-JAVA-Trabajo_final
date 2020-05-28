package entidades;

import java.util.ArrayList;
import java.util.Date;

public class CompraCliente extends Compra {

	int idCliente;

	public CompraCliente() {
		super();
	}

	public CompraCliente(int id, String fecha, double total, ArrayList<LineaDeCompra> lineasDeCompra, int idCliente) {
		super(id, fecha, total, lineasDeCompra);
		this.idCliente = idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}