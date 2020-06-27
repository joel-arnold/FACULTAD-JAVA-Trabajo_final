package entidades;

import java.util.ArrayList;

public class Venta {

	private int id;
	private String fecha;
	private Double total;
	private int id_cliente;
	private String nombre_cliente;
	private String apellido_cliente;
	private ArrayList<LineaDeVenta> lineas;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public ArrayList<LineaDeVenta> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<LineaDeVenta> lineas) {
		this.lineas = lineas;
	}

}
