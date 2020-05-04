<div class="container-fluid" style="text-align:center">
   <br><br><br>
   <div class="jumbotron" style="margin-left:20%; margin-right:20%">
   	  <h1 class="display-4">INICIO</h1>
	  <p class="lead">Acá va el contenido principal de la página de inicio.</p>
	  <hr class="my-4">
	  <p><span>USUARIO LOGUEADO: </span><% out.print(session.getAttribute("nombre")); %></p>
	</div>
</div>