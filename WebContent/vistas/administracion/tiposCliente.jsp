<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Tipos de cliente</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorTipoCliente ctc = new ControladorTipoCliente(); 
			ArrayList<TipoCliente> lista = ctc.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Descripción</th>
			    <th scope="col">Porcentaje descuento</th>
			    <th scope="col">Acción</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(TipoCliente tc : lista){; %>
			<tr>
			<td><% out.print(tc.getDescripcion()); %></td>
			<td><% out.print(tc.getPorcentajeDescuento()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-warning" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar(
                     		'<%out.print(tc.getId());%>',
                     		'<%out.print(tc.getDescripcion()); %>',
                     		'<%out.print(tc.getPorcentajeDescuento());%>'	 
                     	 )"><i class="fas fa-edit"></i>				
				</button>
				&nbsp;&nbsp;
				<button class="btn btn-danger" data-toggle="modal" data-target="#modalBaja"
					onclick="configIdEliminar('<%out.print(tc.getId());%>')"><i class="fas fa-times"></i>
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
	        <h5 class="modal-title" id="exampleModalLabel">Nuevo tipo de cliente</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="altaTC" method="post" action="TcAlta">
				  <div class="form-group">
				    <label for="descripcion">Tipo:</label>
				    <input type="text" class="form-control" id="descripcion" name="descripcion" required="true">
				  </div>
				  <div class="form-group">
				    <label for="porcentaje">Porcentaje:</label>
				    <input type="number"  min="0" class="form-control text-right" id="porcentaje" name="porcentaje" required="true">
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
	        	<form role="form" id="bajaTC" method="post" action="TcElimina">
				  <div class="form-group d-none">
				    <input type="number" class="form-control" id="campo_idEliminar" name="idEliminar">
				  </div>
				  <div class="form-group">
				    <label for="Confirmar">¿Está seguro que desea eliminar este tipo de cliente?</label>
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
	        <h5 class="modal-title" id="exampleModalLabel">Modificar tipo de cliente</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="modificaTC" method="post" action="TcModifica">
				  <div class="form-group d-none">
				    <label for="campo_idModificar">ID:</label>
				    <input type="number" class="form-control" id="campo_idModificar" name="idModificar">
				  </div>
				  <div class="form-group">
				    <label for="campo_descripcionModificar">Descripción:</label>
				    <input type="text" class="form-control" id="campo_descripcionModificar" name="descripcionModificar" required="true">
				  </div>
				  <div class="form-group">
				    <label for="campo_porcentajeModificar">Porcentaje:</label>
				    <input type="number"  min="0" class="form-control" id="campo_porcentajeModificar" name="porcentajeModificar" required="true">
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