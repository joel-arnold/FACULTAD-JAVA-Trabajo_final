package entidades;

public class CategoriaProducto {
	
	private String idCategoria;
	private String descripcionCategoria;

	public CategoriaProducto(String idCategoria, String descripcionCategoria) {
		this.idCategoria = idCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}
	
	public String getIdCategoria() {
		return idCategoria;
	}

	/* Este no es necesario ya que el ID debería
	   generarse automáticamente en la BD */
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
		
}