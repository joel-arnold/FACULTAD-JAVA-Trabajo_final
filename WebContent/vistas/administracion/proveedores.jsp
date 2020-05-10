<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Proveedores</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorProveedor cp = new ControladorProveedor(); 
			ArrayList<Proveedor> lista = cp.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Razón social</th>
			    <th scope="col">CUIT</th>
			    <th scope="col">Domicilio</th>
			    <th scope="col">Teléfono</th>
			    <th scope="col">Correo electrónico</th>
			    <th>Acción</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(Proveedor p : lista){; %>
			<tr>
			<td><% out.print(p.getRazonSocial()); %></td>
			<td><% out.print(p.getCuit()); %></td>
			<td><% out.print(p.getDomicilioCalle() + " " + p.getDomicilioNumero()); %></td>
			<td><% out.print(p.getCorreoElectronico()); %></td>
			<td><% out.print(p.getTelefono()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-warning" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar(
                     		'<%out.print(p.getId());%>',
                     		'<%out.print(p.getRazonSocial());%>',
                     		'<%out.print(p.getCuit()); %>',
                     		'<%out.print(p.getDomicilioCalle());%>',
                     		'<%out.print(p.getDomicilioNumero());%>',
                     		'<%out.print(p.getDomicilioPiso());%>',
                     		'<%out.print(p.getDomicilioDepartamento());%>',
                     		'<%out.print(p.getCorreoElectronico());%>',
                     		'<%out.print(p.getTelefono());%>'	 
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
	        <h5 class="modal-title" id="exampleModalLabel">Nuevo proveedor</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="altaProveedor" method="post" action="ProveedorAlta">
				  <div class="form-group">
				    <input type="text" class="form-control" id="razonSocial" name="razonSocial" placeholder="Razón social">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="cuit" name="cuit" placeholder="CUIT">
				  </div>
				  <div class="form-group">
				    <div class="row">
					    <input type="text" class="form-control text-left w-75" id="calle" name="calle" placeholder="Calle">
					    <input type="text" class="form-control text-left w-25" id="numero" name="numero" placeholder="Nro.">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="row">
					    <input type="text" class="form-control text-left w-50" id="piso" name="piso" placeholder="Piso">
					    <input type="text" class="form-control text-left w-50" id="departamento" name="departamento" placeholder="Depto.">
				    </div>
				  </div>
				  <div class="form-group">
				    <input type="tel" class="form-control text-left" id="telefono" name="telefono" placeholder="Teléfono">
				  </div>
				  <div class="form-group">
				    <input type="email" class="form-control text-left" id="correoElectronico" name="correoElectronico" placeholder="Correo electrónico">
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
	        	<form role="form" id="eliminaProveedor" method="post" action="ProveedorElimina">
				  <div class="form-group d-none">
				    <input type="number" class="form-control" id="campo_idEliminar" name="idEliminar">
				  </div>
				  <div class="form-group">
				    <label for="Confirmar">¿Está seguro que desea eliminar este proveedor?</label>
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
	        <h5 class="modal-title" id="exampleModalLabel">Modificar datos del proveedor</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="modificaProveedor" method="post" action="ProveedorModifica">
				  <div class="form-group d-none">
				    <label for="campo_idModificar">ID:</label>
				    <input type="number" class="form-control" id="campo_idModificar" name="idModificar">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control" id="campo_razonSocial" name="razonSocial" placeholder="Razón social">
				  </div>
				  <div class="form-group">
				    <input type="text" class="form-control text-left" id="campo_cuit" name="cuit" placeholder="CUIT">
				  </div>
				  <div class="form-group">
				    <div class="row">
					    <input type="text" class="form-control text-left w-75" id="campo_calle" name="calle" placeholder="Calle">
					    <input type="text" class="form-control text-left w-25" id="campo_numero" name="numero" placeholder="Nro.">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="row">
					    <input type="text" class="form-control text-left w-50" id="campo_piso" name="piso" placeholder="Piso">
					    <input type="text" class="form-control text-left w-50" id="campo_depto" name="departamento" placeholder="Depto.">
				    </div>
				  </div>
				  <div class="form-group">
				    <input type="tel" class="form-control text-left" id="campo_telefono" name="telefono" placeholder="Teléfono">
				  </div>
				  <div class="form-group">
				    <input type="email" class="form-control text-left" id="campo_correoElectronico" name="correoElectronico" placeholder="Correo electrónico">
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