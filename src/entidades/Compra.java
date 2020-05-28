package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
	
	private int id;
	private String fecha;
	private double total;
	private ArrayList<LineaDeCompra> lineasDeCompra;

	public Compra() {
	}
	
	public Compra(int id, String fecha, double total,
			ArrayList<LineaDeCompra> lineasDeCompra) {
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.lineasDeCompra = lineasDeCompra;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
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