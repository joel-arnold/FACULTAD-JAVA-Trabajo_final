<!doctype html>
<html lang="en">
  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>Perfil</title>
  </head>
  
  <body class="bg-light">
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- AC� ABAJO VA EL CONTENIDO -->
  	<% if(session.getAttribute("privilegio") != null){ %>
    <jsp:include page="vistas/usuarios/perfilContenido.jsp"></jsp:include>
    <% } else{ 
    	  session.setAttribute("huboError", "si");
    	  session.setAttribute("causaError", null);
    	  session.setAttribute("mensajeError", "Para ingresar a esta secci�n necesita iniciar sesi�n");
    	  response.sendRedirect("error.jsp");
     } %>
    <!-- AC� ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>
  </body>
  
</html>