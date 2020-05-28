<%@page import="logica.ControladorProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>

  <!-- Page Content -->
  

      <div class="col-lg" style="padding-top:5%; padding-left:10%; padding-right:10%; padding-bottom:5%;">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid w-100" src="img/portada_perro.jpg" alt="Primer diapositiva">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/portada_gato.jpg" alt="Segunda diapositiva">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/portada_ave.jpeg" alt="Tercer diapositiva">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/portada_pipeta.jpg" alt="Cuarta diapositiva">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
			
		<% ArrayList<Producto> productos = new ArrayList<Producto>();
		ControladorProducto cp = new ControladorProducto();
		productos = cp.buscarTodos();
		for(Producto p: productos){ %>
          <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/<% out.print(p.getImagen()); %>" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"><% out.print(p.getNombre()); %></a>
                </h4>
                <h5>$<% out.print((int)p.getPrecioVenta()); %></h5>
                <p class="card-text"><% out.print(p.getDescripcion()); %></p>
              </div>
              <div class="card-footer">
              	<% int aleatorio = (int)(Math.random()*5); %>
                <small class="text-muted">
                	<% for(int i = 0; i<aleatorio; i++){
                	out.print("&#9733;");
                	}for(int i = 0; i<(5-aleatorio); i++){
                	out.print("&#9734;");
                	} %>
                </small>
              </div>
            </div>
          </div>
		<% } %>
		
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->


  
  <!-- /.container -->