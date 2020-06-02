<%@page import="logica.ControladorProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>

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

  <div id="listaProductos" class="row">
	<!-- ACA SE COMPLETAN LOS PRODUCTOS CON JS -->		
  </div>
  <!-- /.row -->
</div>
<!-- /.col-lg-9 -->