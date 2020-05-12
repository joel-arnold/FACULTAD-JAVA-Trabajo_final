<!doctype html>
<html lang="en">
  <head>
	<jsp:include page="vistas/general/referenciasEncabezado.jsp"></jsp:include>
    <title>Compra</title>
    <script type="text/javascript" src="vistas/compra/compra.Controlador.js"></script>
  </head>
  
  <body class="bg-light">
  	<% session.setAttribute("huboError", null); %>
  	<jsp:include page="vistas/general/barraNavegacion.jsp"></jsp:include>
    
    <!-- ACÁ ABAJO VA EL CONTENIDO -->
    <jsp:include page="vistas/compra/compraContenido.jsp"></jsp:include>
    <!-- ACÁ ARRIBA VA EL CONTENIDO -->
    
	<jsp:include page="vistas/general/referenciasPie.jsp"></jsp:include>
	
	<script type="text/javascript" src="estilo/jquery.js"></script>
	
	<!-- PARA CARRITO DE COMPRA -->
	<script type="text/javascript">
		$(document).ready(function(){
			$('#min').click(function(){
				if ($('#quantity').val() != 0)
					$('#quantity').val(parseInt($('#quantity').val()) - 1);
			});
			
			$('#plus').click(function(){
				$('#quantity').val(parseInt($('#quantity').val()) + 1);
			});
			
			$('#enviar').click(function(){
				
				//$('#content').html('<div class="loading"><img src="images/loading.gif" width="70px" height="70px"/></div>');
		
				var quantity = $('#quantity').val();		
				var dataString = 'quantity='+quantity;
				
				$.ajax({
		            type: "POST",
		            url: "quantity.php",
		            data: dataString,
		            success: function(data) {
						$('#result').fadeIn(1000).html(data);
		            }
		        });
		    });    
		});
	</script>
	
  </body>
  
</html>