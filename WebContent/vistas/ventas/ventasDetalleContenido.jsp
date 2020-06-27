<div class="container" style="text-align:center; padding-top: 2%; padding-bottom: 2%">
	  <div class="row">
	    <div class="col-lg">
            <div class="jumbotron bg-info text-dark">
		   	  <h6 class="display-4">Detalle de la venta</h6>
		   	  <hr class="my-4 bg-light">
			  <ul style="text-align: left">
			  	<li><% out.print("Usuario: " + session.getAttribute("nombreUsuario")); %></li>
			  </ul>
			</div>
	    </div>
	    <div class="col-lg">
      		<table class="table table-hover table-bordered table-light text-center">
			  <thead class="bg-info">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Producto</th>
			      <th scope="col">Cantidad</th>
			      <th scope="col">Monto</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">i</th>
			      <td>nombreProd</td>
			      <td>cant</td>
			      <td>precioUnit x cant</td>
			    </tr>
			    <tr>
			    <td colspan="3" class="text-center"><b>Monto total</b></td>
			    <td class="text-center"><b> $TOTAL</b></td>
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