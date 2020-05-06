<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Administración de privilegios de usuarios</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorEmpleado ce = new ControladorEmpleado(); 
			ArrayList<Empleado> lista = ce.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Empleado</th>
			    <th scope="col">Privilegio</th>
			    <th>Editar</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(Empleado emp : lista){; %>
			<tr>
			<td><% out.print(emp.getApellido().toUpperCase() + ", " + emp.getNombre()); %></td>
			<td><% out.print(emp.getPrivilegio()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-warning" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar('<%out.print(emp.getNombreUsuario());%>')"><i class="fas fa-edit"></i>				
				</button>
			</td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</div>
	
	<!-- Modal para la modificación -->
	<div class="modal fade" id="modalModificacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Elija el nuevo privilegio</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	        </div>
	        <div class="modal-body text-left" style="margin-left:10%; margin-right:10%">
	        	<form role="form" id="modificaPrivilegio" method="post" action="PrivilegioModifica">
				  <div class="form-group d-none">
				    <label for="campo_usuarioModificar">Usuario:</label>
				    <input type="text" class="form-control" id="campo_usuarioModificar" name="usuarioModificar">
				  </div>
				  <div class="form-group">
				    <label for="campo_privilegioModificar">Privilegio:</label>
				    <br>
				    <select id="listaPrivilegios" name="listaPrivilegios">
  						<option value="EMPLEADO">Empleado</option>
  						<option value="ADMINISTRADOR">Administrador</option>
  						<option value="SUPERUSUARIO">Superusuario</option>						
  					</select>
				    <!-- <input type="text" class="form-control" id="campo_privilegioModificar" name="privilegioModificar"> -->
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