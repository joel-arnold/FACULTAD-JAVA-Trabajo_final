<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Productos</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorProducto cp = new ControladorProducto(); 
			ArrayList<Producto> lista = cp.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Codigo</th>
			    <th scope="col">Marca</th>
			    <th scope="col">Descripcion</th>
			    <th scope="col">Tamaño</th>
			    <th scope="col">Precio</th>
			    <th scope="col">Categoria</th>
			    <th>Acción</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(Producto p : lista){; %>
			<tr>
			<td><% out.print(p.getCodigo()); %></td>
			<td><% out.print(p.getNombre()); %></td>
			<td><% out.print(p.getDescripcion()); %></td>
			<td><% out.print(p.getTamano() + " " + p.getUnidadMedida()); %></td>
			<td><% out.print(p.getPrecioVenta()); %></td>
			<td><% out.print(p.getCategoria()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-warning" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar(
                     		'<%out.print(p.getId());%>',
                     		'<%out.print(p.getCodigo());%>',
                     		'<%out.print(p.getNombre()); %>',
                     		'<%out.print(p.getDescripcion());%>',
                     		'<%out.print(p.getTamano());%>',
                     		'<%out.print(p.getUnidadMedida());%>',
                     		'<%out.print(p.getPrecioVenta());%>',
                     		'<%out.print(1);%>'
                     	 )"><i class="fas fa-edit"></i>				
				</button>
				&nbsp;&nbsp;
				<button class="btn btn-danger" data-toggle="modal" data-target="#modalBaja"
					onclick="configIdEliminar('<%out.print(p.getId());%>')"><i class="fas fa-times"></i>
				</button>
			</td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAlta"><i class="fas fa-user-plus"></i> Agregar</button>
	</div>
	
	<!-- Modal para el alta -->
	<div class="modal fade" id="modalAlta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Nuevo producto</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="altaProducto" method="post" action="ProductoAlta">
				  <div class="form-group">
				    <input type="text" class="form-control" id="codigo" name="codigo" placeholder="Codigo" required>
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="nombre" name="nombre" placeholder="Marca" required>
				  </div>
				  <div class="form-group">
				    <input type="text" style="width:365px; height:100px;" class="form-control text-left" id="descripcion" name="descripcion" placeholder="Descripcion" required>
				  </div>
				  <div class="form-group">
				    <div class="row">
					    <input type="number" min="0" class="form-control text-left w-50" id="tamano" name="tamano" placeholder="Tamaño" required>
					    <input type="text" class="form-control text-left w-50" id="umedida" name="umedida" placeholder="U. Medida" required>
				    </div>
				  </div>
				  <div class="form-group">
				    <input type="number" min="0" class="form-control text-left" id="precioventa" name="precioventa" placeholder="Precio Venta $" required>
				  </div>
				  <div class="form-group">
				    <label for="cat">Categoria:</label>
				    <select name="categoria" id="categoria">
		    			<% ControladorCategoriaProducto ctrla = new ControladorCategoriaProducto(); %>
    					<% for (CategoriaProducto p : ctrla.buscarTodos()) {%>
       					<option value="<% out.print(p.getIdCategoria());%>">
       						<% out.print(p.getNombre());%>
       					</option> 
       					<%};%>
					</select>
				  </div>
				  <div class="text-right">
				  	<br>
	  		        <button type="submit" class="btn btn-primary">Guardar</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
		    	  </div>
				</form>
	        </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal para la baja -->
	<div class="modal fade" id="modalBaja" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmar eliminación</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="eliminaProducto" method="post" action="ProductoElimina">
				  <div class="form-group d-none">
				    <input type="number" class="form-control" id="campo_idEliminar" name="idEliminar">
				  </div>
				  <div class="form-group">
				    <label for="Confirmar">¿Está seguro que desea eliminar este producto?</label>
				  </div>
				  <div class="text-right">
				  	<br>
	  		        <button type="submit" class="btn btn-danger">Confirmar</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
		    	  </div>
				</form>
	        </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal para la modificación -->
	<div class="modal fade" id="modalModificacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modificar datos del producto</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="modificaProducto" method="post" action="ProductoModifica">
				  <div class="form-group d-none">
				    <label for="campo_idModificar">ID:</label>
				    <input type="number" class="form-control" id="campo_idModificar" name="idModificar">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="campo_codigo" name="codigo" placeholder="Codigo" required>
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="campo_nombre" name="nombre" placeholder="Marca" required>
				  </div>
				  <div class="form-group">
				    <input type="text" style="width:365px; height:100px;" class="form-control text-left" id="campo_descripcion" name="descripcion" placeholder="Descrpcion" required>
				  </div>
				  <div class="form-group">
				    <div class="row">
				    	<input type="number" min="0" class="form-control text-left w-50" id="campo_tamano" name="tamano" placeholder="Tamaño" required>
					    <input type="text" class="form-control text-left w-50" id="campo_umedida" name="umedida" placeholder="U. Medida" required>
				    </div>
				  </div>
				  <div class="form-group">
				    <input type="number" min="0" class="form-control text-left" id="campo_precioventa" name="precioventa" placeholder="Precio Venta $" required>
				  </div>
				  <div class="form-group">
				     <label for="cat">Categoria:</label>
				    <select name="categoria" id="campo_categoria">
		    			<% ControladorCategoriaProducto ctrlm = new ControladorCategoriaProducto(); %>
    					<% for (CategoriaProducto p : ctrlm.buscarTodos()) {%>
       					<option selected value="<% out.print(p.getIdCategoria());%>">
       						<% out.print(p.getNombre());%>
       					</option> 
       					<%};%>
					</select>
				  </div>
				  <div class="text-right">
				  	<br>
	  		        <button type="submit" class="btn btn-primary">Guardar</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
		    	  </div>
				</form>
	        </div>
	    </div>
	  </div>
	</div>
</div>