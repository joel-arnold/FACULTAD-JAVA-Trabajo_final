<div class="container-fluid" style="text-align:center">
   <br><br><br>
   <div class="jumbotron bg-warning" style="margin-left:20%; margin-right:20%">
   	  <% if(session.getAttribute("huboError") == null ) {%>
   	  <h1 class="display-4">No pasa nada...</h1>
	  <p class="lead">Llegaste acá por error.</p>
	  <% } else { %>
	  <h1 class="display-4">Ocurrió un error...</h1>
	  <br>
	  <h3><% out.print(session.getAttribute("mensajeError")); %></h3>
	  <br>
	  <p class="font-italic"><h5>Informale lo siguiente al administrador del sistema para que pueda ayudarte:</h5>
	  	<% out.print(session.getAttribute("causaError")); %>
	  </p>
	  <% } %>
	  <br>     
       <a href="javascript:window.history.back();">
  		<button type="button" class="btn btn-primary">
  		  <i class="fas fa-arrow-alt-circle-left"></i>&nbsp;&nbsp; Volver atrás
  		</button>
       </a>
	</div>
</div>