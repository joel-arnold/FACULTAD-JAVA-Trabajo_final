<div class="row" style="padding-left:2%; padding-right:2%; padding-top:2%; padding-bottom: 2%;">	

	<!-- SECCION DE CATEGORIAS -->
    <div class="col-lg-2">
        <h4 class="my-4">Categorías</h4>
        <div class="list-group">
            <a href="#" class="list-group-item">Perros</a>
            <a href="#" class="list-group-item">Gatos</a>
            <a href="#" class="list-group-item">Aves</a>
        </div>
    </div>

	<!-- SECCION DE PRODUCTOS -->
    <div class="col-lg-6">
        <div id="items" class="row">
        	<!-- Acá se completa todo automáticamente con JS -->
        </div>
    </div>
    
    <!-- SECCION TICKET DE COMPRA -->
    <div class="col-lg-4">
        <div class="card shopping-cart">
            <div class="card-header bg-dark text-light">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                Carrito de compra
                <div class="clearfix"></div>
            </div>
            
            <form action="CompraCliente" id="ticketCompra" name="ticketCompra" method="POST">
            	<div id="carrito" class="card-body">
	            	<!-- Acá se genera todo automáticamente con JS -->
	            </div>
	            <div class="card-footer">
	                <div class="container">
	                    <div class="row">
	                        <div class="col-8">
	                            Total: <b>$</b><b id="total">0.00</b>
	                        </div>
	                        <div class="col-4">
	                        	<button type="submit" id="botonComprar" class="btn btn-success pull-right">Comprar</button>
	                        </div>
	                    </div>
	                </div>
	            </div>
            </form>
            
        </div>
    </div>
</div>