<!doctype html>
<html lang="en">
  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>�Bienvenido!</title>
  </head>
  
  <body>
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- AC� ABAJO VA EL CONTENIDO -->
    <jsp:include page="vistas/inicio/contenidoPrincipal.jsp"></jsp:include>
    <!-- AC� ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>
  </body>
  
</html>