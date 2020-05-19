<%@page import="logica.ControladorProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>

<div class="row" style="padding-left:2%; padding-right:2%; padding-top:2%; padding-bottom: 2%;">

    <div class="col-lg-2">

        <h4 class="my-4">Categorías</h4>
        <div class="list-group">
            <a href="#" class="list-group-item">Perros</a>
            <a href="#" class="list-group-item">Gatos</a>
            <a href="#" class="list-group-item">Aves</a>
        </div>

    </div>
    <!-- /.col-lg-2 -->

    <div class="col-lg-6">

        <!-- AC� VAN LOS PRODUCTOS -->
        <div id="items" class="row">

            <% ArrayList<Producto> productos = new ArrayList<Producto>();
             ControladorProducto cp = new ControladorProducto();
             productos = cp.buscarTodos();
             for(Producto p: productos){ %>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100">
                    <a href="#"><img class="card-img-top" src="img/<% out.print(p.getImagen()); %>"
                            alt="Producto X"></a>
                    <div class="card-body" style="text-align:center">
                        <h6 class="card-title">
                            <a><% out.print(p.getNombre() + " x " + p.getTamano() + p.getUnidadMedida() + " - $" + p.getPrecioVenta()); %></a>
                        </h6>
                        <p class="card-text"><% out.print(p.getCategoria()); %></p>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center">
                            <button type="button" class="btn btn-info"><small>Agregar al carrito</small></button>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
            
        </div>
        <!-- /.row -->
    </div>
    <!-- /.col-lg-7 -->


    <!-- TICKET DE COMPRA -->
    <div class="col-lg-4">

        <div class="card shopping-cart">
            <div class="card-header bg-dark text-light">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                Carrito de compra
                <div class="clearfix"></div>
            </div>
            <div id="carrito" class="card-body">
                <!-- PRODUCTO -->
                <!-- <div class="row">
			    <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-4">
			        <h6 class="product-name">
			            <strong>Producto1</strong>
			        </h6>
			        <h6>
			            <small>Descripci�n1</small>
			        </h6>
			    </div>
			    <div class="col-12 col-sm-12 text-sm-center col-md-8 text-md-right row">
			        <div class="col-3 col-sm-3 col-md-4 text-md-right" style="padding-top: 5px">
			            <h6>
			                <strong>
			                    25.00 <span class="text-muted">x</span>
			                </strong>
			            </h6>
			        </div>
			        <div class="col-4 col-sm-4 col-md-6">
			            <div class="quantity">
			                <input type="button" value="-" class="minus" id="min" style="cursor:pointer;">
			                <input class="text-center" name="quantity" id="quantity" value="0" size="2" />
			                <input type="button" value="+" class="plus" id="plus" style="cursor:pointer;">
			            </div>
			        </div>
			        <div class="col-2 col-sm-2 col-md-2 text-right">
			            <button type="button" class="btn btn-outline-danger btn-xs">
			                <i class="fa fa-trash" aria-hidden="true"></i>
			            </button>
			        </div>
			    </div>
			</div>
			<hr> -->
                <!-- FIN PRODUCTO -->
            </div>
            <!-- CIERRA CARD-BODY -->
            <div class="card-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-8">
                            Total: <b id="total">0.00</b>
                        </div>
                        <div class="col-4">
                            <a href="" class="btn btn-success pull-right">Comprar</a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- /.TICKET DE COMPRA -->
    </div>
</div>
<!-- /.row -->

<!-- CARRITO NUEVO -->
<div class="container">
    <div class="row">
        <!-- Elementos generados a partir del JSON -->
        <main id="items" class="col-sm-8 row"></main>
        <!-- Carrito -->
        <aside class="col-sm-4">
            <h2>Carrito</h2>
            <!-- Elementos del carrito -->
            <ul id="carrito" class="list-group"></ul>
            <hr>
            <!-- Precio total -->
            <p class="text-right">Total: <span id="total"></span>$</p>
        </aside>
    </div>
</div>
<!-- FIN CARRITO NUEVO -->