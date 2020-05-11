<!doctype html>
<html lang="en">
  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>Compra</title>
  </head>
  
  <body class="bg-light">
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- ACÁ ABAJO VA EL CONTENIDO -->
    <jsp:include page="vistas/compra/compraContenido.jsp"></jsp:include>
    <!-- ACÁ ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>
  </body>
  
</html>