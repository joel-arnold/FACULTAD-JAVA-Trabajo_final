package entidades;

import java.util.Date;

public class Producto {
	
	private int id;
	private String nombre;
	private String descripcion;
	private Date fechaVencimiento;
	private double precio;
	private float existencia;
	private CategoriaProducto categoria;
	
	public Producto(int id, String nombre, String descripcion, Date fechaVencimiento, double precio, float existencia,
			CategoriaProducto categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.existencia = existencia;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public float getExistencia() {
		return existencia;
	}

	public void setExistencia(float existencia) {
		this.existencia = existencia;
	}

	public CategoriaProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
	
}