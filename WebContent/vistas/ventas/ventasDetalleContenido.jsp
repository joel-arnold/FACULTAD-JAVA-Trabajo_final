<%@page import="servlets.VentaDetalle"%>
<%@page import="entidades.LineaDeVenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Venta"%>
<%@page import="logica.ControladorVenta"%>

<%  ControladorVenta cv = new ControladorVenta();
	Venta ventaDetalle = new Venta();
	int idCompra = (int)(session.getAttribute("idCompra"));
	ventaDetalle = cv.buscarVentaDetallada(idCompra);
%>

<div class="container" style="text-align:center; padding-top: 2%; padding-bottom: 2%">
	  <div class="row">
	    <div class="col-lg">
            <div class="jumbotron bg-warning text-dark">
		   	  <h6 class="display-4">Detalle de la venta</h6>
		   	  <hr class="my-4 bg-light">
			  <ul style="text-align: left">
			  	<li><% out.print("ID de compra: " + ventaDetalle.getId()); %></li>
			  	<li><% out.print("Fecha: " + ventaDetalle.getFecha()); %></li>
			  	<li><% out.print("Cliente: " + ventaDetalle.getId_cliente() + " - " + ventaDetalle.getApellido_cliente().toUpperCase() + ", " + ventaDetalle.getNombre_cliente()); %></li>
			  	<li><% out.print("Teléfono: " + ventaDetalle.getTelefono()); %></li>
			  	<li><% out.print("Correo electrónico: " + ventaDetalle.getCorreoElectronico()); %></li>
			  	<li><% out.print("Domicilio: " + ventaDetalle.getDomicilioCalle() + " " + ventaDetalle.getDomicilioNumero()); 
			  						if(!ventaDetalle.getDomicilioPiso().equals("")) {
			  							out.print(" - Piso " + ventaDetalle.getDomicilioPiso());
			  						}
			  						
			  						if(!ventaDetalle.getDomicilioDpto().equals("")) {
			  							out.print(" - Depto. " + ventaDetalle.getDomicilioDpto());
			  						}
			  						%>
			  	</li>
			  </ul>
			</div>
	    </div>
	    <div class="col-lg">
      		<table class="table table-hover table-bordered table-light text-center">
			  <thead class="bg-primary">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Producto</th>
			      <th scope="col">Cantidad</th>
			      <th scope="col">Monto</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<%
			  		ArrayList<LineaDeVenta> lineas = ventaDetalle.getLineas();
			  		for(int i = 0; i < lineas.size(); i++){
				  		%>			  		
					    <tr>
					      <th scope="row"><% out.print(i+1);%></th>
					      <td><% out.print(lineas.get(i).getNombreProducto()); %></td>
					      <td><% out.print(Math.round(lineas.get(i).getCantidad())); %></td>
					      <td><% out.print("$ " + String.format("%.2f", (double)(lineas.get(i).getCantidad())*(double)(lineas.get(i).getPrecioUnitario()))); %></td>
					    </tr>
				  	<% } %>
			    <tr>
			    <td colspan="3" class="text-center"><b>Monto total</b></td>
			    <td class="text-center"><b> $ <% out.print(String.format("%.2f",ventaDetalle.getTotal())); %></b></td>
			    </tr>
			  </tbody>
			</table>
	    </div>
	  </div>
</div>

<div class="container text-center">
	<a href="javascript:window.history.back();">
		<button type="button" class="btn btn-primary">
			<i class="fas fa-arrow-alt-circle-left"></i>&nbsp;&nbsp; Volver al listado de ventas
		</button>
	</a>
</div>