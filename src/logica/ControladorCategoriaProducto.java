package logica;

import java.sql.SQLException;
import java.util.ArrayList;

import datos.DatosCategoriaProducto;
import entidades.CategoriaProducto;
import extras.Excepcion;

public class ControladorCategoriaProducto {
	
	DatosCategoriaProducto datos = new DatosCategoriaProducto();
	
	public ArrayList<CategoriaProducto> buscarTodos() throws SQLException, Excepcion {
		datos = new DatosCategoriaProducto();
		return datos.buscarTodos();
	}
	
	public void alta(CategoriaProducto categoriaproducto) throws SQLException, Excepcion{
		datos.alta(categoriaproducto);
	}
	
	public void modificacion(CategoriaProducto categoriaproducto) throws SQLException, Excepcion{
		datos.modificacion(categoriaproducto);
	}
	
	public void baja(int id) throws SQLException, Excepcion{
		datos.baja(id);
	}
	
}