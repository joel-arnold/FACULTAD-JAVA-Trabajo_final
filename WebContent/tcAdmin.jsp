<!doctype html>
<html lang="en">
  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>Tipos de cliente</title>
    <script type="text/javascript" src="vistas/administracion/tiposCliente.Controlador.js"></script>
  </head>
  
  <body>
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- ACÁ ABAJO VA EL CONTENIDO -->
  	<% if(session.getAttribute("privilegio") == ("ADMINISTRADOR") ||
    	  session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
    <jsp:include page="vistas/administracion/tiposCliente.jsp"></jsp:include>
    <% } else{ 
    	  session.setAttribute("huboError", "si");
    	  session.setAttribute("causaError", null);
    	  session.setAttribute("mensajeError", "Usted no cuenta con los privilegios de acceso necesarios para esta sección");
    	  response.sendRedirect("error.jsp");
     } %>
    <!-- ACÁ ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>
  </body>
  
</html>