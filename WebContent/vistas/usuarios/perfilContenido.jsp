<div class="container-fluid" style="text-align:center">
   <br><br>
   <div class="jumbotron bg-dark text-light" style="margin-left:20%; margin-right:20%">
   	  <h1 class="display-4">Mi perfil</h1>
	  <hr class="my-4">
	  <ul style="text-align: left">
	  	<li><% out.print("Usuario: " + session.getAttribute("nombreUsuario")); %></li>
	  	<li><% out.print("Nombre y apellido: " + session.getAttribute("nombre") + " " + session.getAttribute("apellido")); %></li>
	  	<li><% out.print("Documento: " + session.getAttribute("tipoDoc") + " " + session.getAttribute("documento")); %></li>
	  	<% if(!(session.getAttribute("privilegio") == "CLIENTE")) out.print("<li>CUIL: " + session.getAttribute("cuil") + "</li>"); %>
		<li><% out.print("Domicilio: " + session.getAttribute("domicilioCalle") + " " + session.getAttribute("domicilioNumero"));
						  if(!session.getAttribute("domicilioPiso").equals(null)) out.print(" - " + session.getAttribute("domicilioPiso"));
						  if(session.getAttribute("domicilioDepto") != null) out.print(" - " + session.getAttribute("domicilioDepto")); %></li>
		<li><% out.print("Teléfono: " + session.getAttribute("telefono")); %></li>
		<li><% out.print("Correo electrónico: " + session.getAttribute("correoElectronico")); %></li>
		<% if(session.getAttribute("privilegio") == "CLIENTE") out.print("<li>Categoría: " + session.getAttribute("tipoCliente") + "</li>"); %>
		<% if(!(session.getAttribute("privilegio") == "CLIENTE")) out.print("<li> Nivel de acceso: " + session.getAttribute("privilegio") + "</li>"); %>
	  </ul>
	</div>
</div>