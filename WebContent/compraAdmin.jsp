<!doctype html>
<html lang="en">

  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>Compra</title>
  </head>
  
  <body class="bg-light">
  	<%@page import="logica.ControladorProducto"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="entidades.Producto"%>
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- ACÁ ABAJO VA EL CONTENIDO -->
    <% if(session.getAttribute("privilegio") == ("CLIENTE") ||
    	  session.getAttribute("privilegio") == ("SUPERUSUARIO")){ %>
    <jsp:include page="vistas/compra/compraContenido.jsp"></jsp:include>
    <% } else{ 
    	  session.setAttribute("huboError", "si");
    	  session.setAttribute("causaError", null);
    	  session.setAttribute("mensajeError", "Para realizar una compra debe iniciar sesión como cliente.");
    	  response.sendRedirect("error.jsp");
     } %>	
    <!-- ACÁ ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>

	<!-- LIBRERIA AXIOS: PARA TRABAJAR CON AJAX + PROMESAS -->	
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<!-- SCRIPT PRINCIPAL DE LA PAGINA -->
	<script type="text/javascript" src="vistas/compra/compra.Controlador.js"></script>
	
  </body>
  
</html>