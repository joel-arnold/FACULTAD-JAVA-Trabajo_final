package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	
	private int id;
	private Date fecha;
	private double subtotal;
	private double impuestos;
	private double total;
	private ArrayList<LineaDeCompra> lineasDeCompra;
	
	public Compra(int id, Date fecha, double subtotal, double impuestos, double total,
			ArrayList<LineaDeCompra> lineasDeCompra) {
		this.id = id;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.impuestos = impuestos;
		this.total = total;
		this.lineasDeCompra = lineasDeCompra;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double getImpuestos() {
		return impuestos;
	}
	
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<LineaDeCompra> getLineasDeCompra() {
		return lineasDeCompra;
	}

	public void setLineasDeCompra(ArrayList<LineaDeCompra> lineasDeCompra) {
		this.lineasDeCompra = lineasDeCompra;
	}
	
}