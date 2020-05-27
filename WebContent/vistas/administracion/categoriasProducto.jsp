<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Categorias de Producto</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorCategoriaProducto ccp = new ControladorCategoriaProducto(); 
			ArrayList<CategoriaProducto> lista = ccp.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Nombre</th>
			    <th scope="col">Descripcion</th>
			    <th>Acción</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(CategoriaProducto cp : lista){; %>
			<tr>
			<td><% out.print(cp.getNombre()); %></td>
			<td><% out.print(cp.getDescripcion()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-warning" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar(
                     		'<%out.print(cp.getIdCategoria());%>',
                     		'<%out.print(cp.getNombre()); %>',
                     		'<%out.print(cp.getDescripcion());%>',
                     	 )"><i class="fas fa-edit"></i>				
				</button>
				&nbsp;&nbsp;
				<button class="btn btn-danger" data-toggle="modal" data-target="#modalBaja"
					onclick="configIdEliminar('<%out.print(cp.getIdCategoria());%>')"><i class="fas fa-times"></i>
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
	        <h5 class="modal-title" id="exampleModalLabel">Nueva categoria</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="altaCategoriaProducto" method="post" action="CategoriaProductoAlta">
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="nombre" name="nombre" placeholder="Nombre" required="true">
				  </div>
				  <div class="form-group">
				    <input type="text" style="width:365px; height:100px;" class="form-control text-left" id="descripcion" name="descripcion" placeholder="Descripcion" required="true">
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
	        	<form role="form" id="eliminaCategoriaProducto" method="post" action="CategoriaProductoElimina">
				  <div class="form-group d-none">
				    <input type="number" class="form-control" id="campo_idEliminar" name="idEliminar">
				  </div>
				  <div class="form-group">
				    <label for="Confirmar">¿Está seguro que desea eliminar esta categoría?</label>
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
	        <h5 class="modal-title" id="exampleModalLabel">Modificar datos de la categoría</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="modificaCategoriaProducto" method="post" action="CategoriaProductoModifica">
				  <div class="form-group d-none">
				    <label for="campo_idModificar">ID:</label>
				    <input type="number" class="form-control" id="campo_idModificar" name="idModificar">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="campo_nombre" name="nombre" placeholder="Nombre" required="true">
				  </div>
				  <div class="form-group">
				    <input type="text" style="width:365px; height:100px;" class="form-control text-left" id="campo_descripcion" name="descripcion" placeholder="Descrpcion" required="true">
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