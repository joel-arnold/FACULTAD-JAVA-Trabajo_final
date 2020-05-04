<nav class="navbar navbar-expand-lg navbar-light bg-success text-dark">
  <a class="navbar-brand mb-0 h1 text-white" href="inicio.jsp"><i class="fas fa-dog"></i> De Pelos Pet Shop <i class="fas fa-paw"></i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"><i class="fas fa-piggy-bank"></i> Promociones</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#"><i class="fas fa-shopping-cart"></i> Comprar</a>
      </li>
	  <li class="nav-item">
        <a class="nav-link active" href="#"><i class="fas fa-truck-moving"></i> Pedidos a preparar</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="#"><i class="fas fa-exclamation-triangle"></i> Productos pr�ximos a vencer</a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <i class="fas fa-users-cog"></i> Panel de administraci�n
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#"><i class="fas fa-window-restore"></i> Privilegios</a>
          <a class="dropdown-item" href="tcAdmin.jsp"><i class="fas fa-user-tag"></i> Tipos de cliente</a>
        </div>
      </li>
    </ul>
    <!-- Button trigger modal -->
    <% if(session.getAttribute("nombre") == null){ %>
		<button type="button" class="btn btn-primary bg-dark text-white" data-toggle="modal" data-target="#modalIngreso">
		  Iniciar sesi�n
		</button>
	<% } else{ %>
		<form action="SesionCierre" method="post">
			<button type="submit" class="btn btn-primary bg-dark text-white">Cerrar sesi�n</button>
		</form>
	<% } %>
  </div>
</nav>

<!-- Ventana modal de inicio de sesi�n-->
<div class="modal fade" id="modalIngreso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Iniciar sesi�n</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form role="form" id="login" method="post" action="SesionInicio">
		  <div class="form-group">
		    <label for="usuario">Usuario:</label>
		    <input type="text" class="form-control" id="usuario" name="usuario">
		  </div>
		  <div class="form-group">
		    <label for="contrasena">Contrase&ntilde;a:</label>
		    <input type="password" class="form-control" id="contrasena" name="contrasena">
		  </div>
		  <button type="submit" class="btn btn-primary">Iniciar sesi&oacute;n</button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>