<div class="container-fluid" style="text-align:center">
   <br><br><br>
   <div class="jumbotron bg-success" style="margin-left:20%; margin-right:20%">  	  
   	  <h3 class="text-center">¡Gracias por comprar en De Pelos Mascotas!</h3>
   	  <h5 class="text-center">Su número de compra es: <% out.print(session.getAttribute("nroCompra")); %></h5>
   	  <h6 class="text-center">Enviamos un correo a <% out.print(session.getAttribute("correoElectronico")); %> con los datos de su compra.</h6>
   	  <p class="font-italic">
   	  	En breve nos pondremos en contacto para coordinar el envío.
   	  </p>
	  <br>    
       <a href="inicio.jsp">
  		<button type="button" class="btn btn-light">
  		  <i class="fas fa-home"></i>&nbsp;&nbsp; Ir al inicio
  		</button>
       </a>   	  
	</div>
</div>