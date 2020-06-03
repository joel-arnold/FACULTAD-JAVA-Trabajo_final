axios({
    method: 'GET',
    url: 'ProductoBuscaTodos'
}).then(res => {
	const listaProductos = document.getElementById('listaProductos')
    for (const producto of res.data) {
    	const aleatorio = (Math.random()*5)
    	let estrellas_oscuras = ""
            let estrellas_claras = ""
    	for(let i = 0; i<aleatorio; i++){
        	estrellas_oscuras += "&#9733;"
        	}
    	for(let i = 0; i<(5-aleatorio); i++){
    		estrellas_claras += "&#9734;"
        	}
    	listaProductos.innerHTML += `
			<div class="col-lg-3 col-md-6 mb-4">
			    <div class="card h-100">
			      <a href="#"><img class="card-img-top" src="img/${producto.imagen}" alt=""></a>
			      <div class="card-body">
			        <h4 class="card-title">
			          <a href="#">${producto.nombre}</a>
			        </h4>
			        <h5>$${producto.precioVenta}</h5>
			        <p class="card-text">${producto.descripcion}</p>
			      </div>
			      <div class="card-footer">
			        <small id="estrellas" class="text-muted">
			        	 ${estrellas_oscuras}${estrellas_claras}
			        </small>
			      </div>
				</div>
			</div>
    	`
    }
}).catch(err => console.log(`Hubo un error --> ${err}`))