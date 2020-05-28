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
	
	<!-- PARA CARRITO DE COMPRA -->
	<!-- Este primer script, lamentablemente es un injerto horrible
		 que permite armar un arreglo JS para leerlo en el siguiente
		 script que hace todo. Tuve que hacerlo así porque sino no
		 podía traer los productos con JAVA y tenía que traer un JSON
		 que con las JSP no lo pude hacer funcionar -->
	<script type="text/javascript">
		/* Arreglo con toda la informacion de los productos */
	    let baseDeDatos = [
	    	<% 	ArrayList<Producto> productos = new ArrayList<Producto>();
	    		ControladorProducto cp = new ControladorProducto();
	    		productos = cp.buscarTodos();
	    		for(int i = 0; i < productos.size(); i++){ %>
	                {
		                id: <%out.print(productos.get(i).getId());%>,
		                nombre: '<%out.print(productos.get(i).getNombre());%>',
		                categoria: '<%out.print(productos.get(i).getCategoria());%>',
		                descripcion: '<%out.print(productos.get(i).getDescripcion());%>',
		                precio: <%out.print(productos.get(i).getPrecioVenta());%>,
		                imagen: 'img/<% out.print(productos.get(i).getImagen());%>'
	            	}<% if((i+1) < (productos.size())) out.print(","); %> 
			<% } %>
	  	]
	</script>
	<!-- Este segundo script es el que va. Hace todo en la página -->
	<script type="text/javascript" src="vistas/compra/compra.Controlador.js"></script>
	
  </body>
  
</html>