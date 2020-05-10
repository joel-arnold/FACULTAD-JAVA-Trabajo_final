<nav class="navbar navbar-expand-lg navbar-light bg-success text-dark">
  <a class="navbar-brand mb-0 h1 text-white" href="inicio.jsp"><i class="fas fa-dog"></i> De Pelos Pet Shop <i class="fas fa-paw"></i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
   	<% 
	   if(session.getAttribute("privilegio") == ("CLIENTE") ||    	
		session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
		<li class="nav-item">
		 <a class="nav-link active" href="#"><i class="fas fa-shopping-cart"></i> Comprar</a>
		</li>
	<% }   	
   	   if(!(session.getAttribute("privilegio") == ("EMPLEADO")) &&    	
    	!(session.getAttribute("privilegio") == ("ADMINISTRADOR"))){ %>
    	<li class="nav-item active">
		 <a class="nav-link" href="#"><i class="fas fa-piggy-bank"></i> Promociones</a>
      	</li>
   	<% }
   	   if(!(session.getAttribute("privilegio") == ("EMPLEADO")) &&    	
   	   !(session.getAttribute("privilegio") == ("ADMINISTRADOR"))){ %>
        <li class="nav-item dropdown">
         <a class="nav-link dropdown-toggle active" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-barcode"></i> Productos
         </a>
         <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item">Perros</a>
          <a class="dropdown-item">Gatos</a>
          <a class="dropdown-item">Burros</a>
         </div>
      </li>
   	<% }
   	   if(!(session.getAttribute("privilegio") == ("EMPLEADO")) &&    	
   	   	   	!(session.getAttribute("privilegio") == ("ADMINISTRADOR"))){ %>
   	   	    <li class="nav-item active">
   	   		 <a class="nav-link" href="#"><i class="fab fa-whatsapp"></i> Contacto</a>
   	   	    </li>
    <% }
  	  	if(session.getAttribute("privilegio") == ("EMPLEADO") ||    	
  	    session.getAttribute("privilegio") == ("ADMINISTRADOR") ||
  	    session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
  	      <li class="nav-item">
  	        <a class="nav-link active" href="#"><i class="fas fa-exclamation-triangle"></i> Productos a vencer</a>
  	      </li>
 	<% }
      if(session.getAttribute("privilegio") == ("EMPLEADO") ||    	
    	session.getAttribute("privilegio") == ("ADMINISTRADOR") ||
    	session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
	    <li class="nav-item">
          
        </li>
  	<% }
      if(session.getAttribute("privilegio") == ("EMPLEADO") ||    	
    	    	session.getAttribute("privilegio") == ("ADMINISTRADOR") ||
    	    	session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
    		    <li class="nav-item dropdown">
		         <a class="nav-link dropdown-toggle active" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		           <i class="fas fa-truck-moving"></i> Pedidos
		         </a>
		         <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		           <a class="dropdown-item" href="#">A preparar</a>
		           <a class="dropdown-item" href="#">Preparados</a>
		           <a class="dropdown-item" href="#">Entregados</a>
		           <a class="dropdown-item" href="#">Cargar compra</a>
		         </div>
    	        </li>
 	<% }
	  if(session.getAttribute("privilegio") == ("ADMINISTRADOR") ||
    	session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <i class="fas fa-users-cog"></i> Panel de administración
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="privilegioAdmin.jsp"><i class="fas fa-window-restore"></i> Privilegios</a>
          <a class="dropdown-item" href="tcAdmin.jsp"><i class="fas fa-user-tag"></i> Tipos de cliente</a>
        </div>
      </li>
    <% } %>
    </ul>
    
    <!-- SECCION DE USUARIO -->
	<% if(session.getAttribute("nombre") == null){ %>
		<button type="button" class="btn btn-primary bg-dark text-white" data-toggle="modal" data-target="#modalIngreso">
		  <i class="fas fa-sign-in-alt"></i> Iniciar sesión
		</button>
		&nbsp;&nbsp;
		<a href="registroUsuario.jsp">
			<button type="button" class="btn btn-primary bg-info text-white">
				<i class="fas fa-user-plus"></i> Registrarse
			</button>
		</a>
	<% } else{ %>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle active text-white" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <i class="fas fa-user-circle"></i> <% out.print(session.getAttribute("nombre")); out.print(" "); out.print(session.getAttribute("apellido"));  %>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="perfil.jsp"><i class="fas fa-address-card"></i> Mi perfil</a>
          <form action="SesionCierre" method="post">
			<button type="submit" class="dropdown-item"><i class="fas fa-sign-out-alt"></i> Cerrar sesión</button>
		  </form>
        </div>
      </li>
    </ul>
	<% } %>
  </div>
</nav>

<!-- Ventana modal de inicio de sesión-->
<div class="modal fade" id="modalIngreso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Iniciar sesión</h5>
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