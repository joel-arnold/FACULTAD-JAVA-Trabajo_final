<%@page import="entidades.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.*"%>
<div class="container-fluid" style="text-align:center">
	<br><br>
		<h1>Ventas</h1>
		<div class="form-group" style="margin-top: 40px; background-color: #FFF; margin-bottom: 10px; margin-left:10%; margin-right:10%">
			<% 	ControladorVenta cv = new ControladorVenta(); 
			ArrayList<Venta> lista = cv.buscarTodos(); %>
		   	<table class="table table-bordered table-hover table-responsive-sm">
			<thead class="thead-dark">
			  <tr>
			    <th scope="col">Id Venta</th>
			    <th scope="col">Fecha</th>
			    <th scope="col">Total</th>
			    <th scope="col">Cliente</th>
			    <th>Detalle</th>
			  </tr>
			</thead>
			<tbody>
			   	
			<%for(Venta v : lista){; %>
			<tr>
			<td><% out.print(v.getId()); %></td>
			<td><% out.print(v.getFecha()); %></td>
			<td><% out.print("$" + v.getTotal()); %></td>
			<td><% out.print(v.getNombre_cliente() + " " + v.getApellido_cliente()); %></td>
			<td scope="row">
				<button type="submit" class="btn btn-outline-info" data-toggle="modal" data-target="#modalModificacion"
					onclick="configModificar(
                     	 )">Ver mas				
				</button>
				&nbsp;&nbsp;
			</td>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</div>
</div>