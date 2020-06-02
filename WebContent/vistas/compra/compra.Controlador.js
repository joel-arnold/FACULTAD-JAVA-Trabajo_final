window.onload = function () {

    /* Creación de variables */
    let $items = document.querySelector('#items')
    let carrito = [];
    let baseDeDatos
    let categoriaElegida = ""
    let total = 0
    let $carrito = document.querySelector('#carrito')
    let $total = document.querySelector('#total')
    
    // Funciones
    const renderizarProductos = () => {
        for (let info of baseDeDatos) {
        	/* Por cada producto en la BD controlo si corresponde a la categoria elegida*/
        	if((info['categoria'] === categoriaElegida) || categoriaElegida === ""){
        		// Estructura
            	let elItem = document.createElement('div');
            	elItem.classList.add('col-lg-4', 'col-md-6', 'mb-4');
            	
                /* Tarjeta (div para estilo) */
            	let tarjetaItem = document.createElement('div');
                tarjetaItem.classList.add('card', 'h-100');
            	
                /* Creo la imagen */
                let enlaceImagen = document.createElement('a');
                let imagenProducto = document.createElement('img');
                imagenProducto.classList.add('card-img-top');
                imagenProducto.src = `img/${info.imagen}`;
                enlaceImagen.appendChild(imagenProducto);
                
                /* Creo el cuerpo de la tarjeta */
                let cuerpoItem = document.createElement('div');
                cuerpoItem.classList.add('card-body', 'text-center');
                
                /* Nombre, tamaño y precio */
                let nombreProducto = document.createElement('h5');
                nombreProducto.classList.add('card-title');
                nombreProducto.textContent = `${info.nombre}`;
                let descripcionProducto = document.createElement('p');
                descripcionProducto.classList.add('card-text');
                descripcionProducto.textContent = `${info.descripcion}`;
                let elPrecio = document.createElement('h6');
                elPrecio.classList.add('card-subtitle');
                let precioProducto = document.createElement('a');
                precioProducto.textContent = `$${info.precioVenta}`;
                elPrecio.appendChild(precioProducto);
                
                /* Agrego al cuerpo del item el titulo y descripcion */
                cuerpoItem.appendChild(nombreProducto);
                cuerpoItem.appendChild(descripcionProducto);
                cuerpoItem.appendChild(elPrecio);
                
                /* Pie del producto (Boton de agregar al carrito)*/
                let pieProducto = document.createElement('div');
                pieProducto.classList.add('card-footer');
                let contenidoPieProducto = document.createElement('div');
                contenidoPieProducto.classList.add('d-flex', 'justify-content-center');
                let botonPieProducto = document.createElement('button');
                botonPieProducto.classList.add('btn', 'btn-dark', 'text-light', 'w-75');
                botonPieProducto.setAttribute('marcador', info.id);
                botonPieProducto.addEventListener('click', anyadirCarrito);
                botonPieProducto.textContent = 'Agregar';
                contenidoPieProducto.appendChild(botonPieProducto);
                pieProducto.appendChild(contenidoPieProducto);
                
                /* Uno las partes */
                tarjetaItem.appendChild(enlaceImagen);
                tarjetaItem.appendChild(cuerpoItem);
                tarjetaItem.appendChild(pieProducto);
                elItem.appendChild(tarjetaItem);
               	$items.appendChild(elItem);
        	}            
        }
    }

    function anyadirCarrito() {
        // Añadimos el Nodo a nuestro carrito
        carrito.push(this.getAttribute('marcador'))
        // Calculo el total
        calcularTotal();
        // Renderizamos el carrito
        renderizarCarrito();
    }

    function borrarItemCarrito() {
        // Obtenemos el producto ID que hay en el boton pulsado
        let id = this.getAttribute('item');
        // Borramos todos los productos
        carrito = carrito.filter(function (carritoId) {
            return carritoId !== id;
        });
        // volvemos a renderizar
        renderizarCarrito();
        /* Pongo parrafo de vacio cuando ya no quedan items */
        if($carrito.textContent == ''){
        	$carrito.innerHTML = `<p class="text-center" id="carroVacio">A\u00FAn no agreg\u00F3 productos al carrito</p>`;
        }
        // Calculamos de nuevo el precio
        calcularTotal();
    }

    function renderizarCarrito() {
        // Vaciamos todo el html
        $carrito.textContent = '';
        
        // Quitamos los duplicados
        let carritoSinDuplicados = [...new Set(carrito)];
        
        // Generamos los Nodos a partir de carrito
        carritoSinDuplicados.forEach(function (item, indice) {
            
        	// Obtenemos el item que necesitamos de la variable base de datos
            let miItem = baseDeDatos.filter(function (itemBaseDatos) {
                return itemBaseDatos['id'] == item;
            });
            
            // Cuenta el número de veces que se repite el producto
            let numeroUnidadesItem = carrito.reduce(function (total, itemId) {
                return itemId === item ? total += 1 : total;
            }, 0);
            
            /* Acá empieza la creación de la estructura */
            /* Primero creé el "Nodo", que es un DIV con clase ROW para meter cada item */
            let miNodo = document.createElement('div');
            miNodo.classList.add('row');
            let linea = document.createElement('hr');
            
            /* Este es el pedazo 1 (un DIV) con la primer parte del código de cada item del carrito */
            let pedazo1 = document.createElement('div');
            pedazo1.classList.add('col-12', 'text-sm-center', 'col-sm-12', 'text-md-left', 'col-md-4');
            let h6_1 = document.createElement('h6');
            h6_1.classList.add('product-name');
            h6_1.innerHTML = `<b>${miItem[0]['nombre']}</b>`;
            let h6_2 = document.createElement('h6');
            h6_2.innerHTML = `<small>${miItem[0]['descripcion']}</small>`;
            pedazo1.appendChild(h6_1);
            pedazo1.appendChild(h6_2);
            
            /* Este es el pedazo 2 (un DIV) con la segunda parte del código de cada item del carrito */
            let pedazo2 = document.createElement('div');
            pedazo2.classList.add('col-12', 'col-sm-12', 'text-sm-center', 'col-md-8', 'text-md-right', 'row');
            
            /* Sub-parte del pedazo 2 */
            let div1 = document.createElement('div');
            div1.classList.add('col-3', 'col-sm-3', 'col-md-4', 'text-md-right');
            div1.style.paddingTop = "5px";
            let h6_3 = document.createElement('h6');
            h6_3.innerHTML = `<h6><strong>$ ${miItem[0]['precioVenta']} <span class="text-muted"> x</span></strong></h6>`;
            div1.appendChild(h6_3);
            
            /* Otra sub-parte del pedazo 2 */
            let div2 = document.createElement('div');
            div2.classList.add('col-4', 'col-sm-4', 'col-md-6');
            let div2_2 = document.createElement('div');
            div2_2.classList.add('quantity');
            let inputRestar = document.createElement('input');
            inputRestar.classList.add('minus');
            inputRestar.type = "button";
            inputRestar.value = "-";
            inputRestar.id = "min";
            inputRestar.style.cursor = "pointer";
            let inputSumar = document.createElement('input');
            inputSumar.classList.add('plus');
            inputSumar.type = "button";
            inputSumar.value = "+";
            inputSumar.id = "plus";
            inputSumar.style.cursor = "pointer";
            let inputCantidad = document.createElement('input');
            inputCantidad.classList.add('text-center');
            inputCantidad.name = `cantidad${indice}`;
            inputCantidad.type = "text";
            inputCantidad.value = `${numeroUnidadesItem}`;
            inputCantidad.id = "cantidad";
            inputCantidad.size = 2;
            inputCantidad.readOnly = true;

            /* En estos input "fantasma" meto los datos que interesan de cada producto
             * para poder hacerlos viajar por POST */
            let inputFantasmaIndice = document.createElement('input');
            inputFantasmaIndice.classList.add('d-none');
            inputFantasmaIndice.type = "text";
            inputFantasmaIndice.name = `${indice}`;
            inputFantasmaIndice.value = `${indice}`;
            let inputFantasmaId = document.createElement('input');
            inputFantasmaId.classList.add('d-none');
            inputFantasmaId.type = "text";
            inputFantasmaId.name = `id${indice}`;
            inputFantasmaId.value = `${miItem[0]['id']}`;
            
            /* Junto lo del DIV2_2*/
            div2_2.appendChild(inputRestar);
            div2_2.appendChild(inputCantidad);
            div2_2.appendChild(inputSumar);
            div2_2.appendChild(inputFantasmaId);
            div2_2.appendChild(inputFantasmaIndice);
            div2.appendChild(div2_2);
            
            /* Otra sub-parte más del pedazo 2 */
            let div3 = document.createElement('div');
            div3.classList.add('col-2', 'col-sm-2', 'col-md-2', 'text-right');
            
            /* Botón de borrar */
            let miBoton = document.createElement('button');
            miBoton.classList.add('btn', 'btn-outline-danger', 'btn-xs');
            miBoton.innerHTML = '<i class="fa fa-trash" aria-hidden="true"></i>';
            miBoton.style.marginLeft = '1rem';
            miBoton.setAttribute('item', item);
            miBoton.addEventListener('click', borrarItemCarrito);
            
            /* Armo el pedazo2 */
            div3.appendChild(miBoton);
            pedazo2.appendChild(div1);
            pedazo2.appendChild(div2);
            pedazo2.appendChild(div3);
            
            /* Funciones para que sumen y resten los botones + y - */
            let id = miItem[0]['id'];
            inputRestar.addEventListener('click', () => {
            	if((parseInt(inputCantidad.value)) != 1){
            		let itemcito = carrito.indexOf(id.toString());
            		carrito.splice(itemcito,1);
            		inputCantidad.value = (parseInt(inputCantidad.value) - 1);
            		calcularTotal();
            	}            	
            });
            inputSumar.addEventListener('click', () => {
            	carrito.push(id.toString());
            	inputCantidad.value = (parseInt(inputCantidad.value) + 1);
            	calcularTotal();
            });
            
            /* Acá junto todas las partes */
            miNodo.appendChild(pedazo1);
            miNodo.appendChild(pedazo2);
            $carrito.appendChild(miNodo);
            
            /* Lo que sigue es para agregar linea seaparatoria de items si no es el último item */ 
            let carritoSinDuplica2 = [...new Set(carrito)];
            if((indice+1) != carritoSinDuplica2.length) $carrito.appendChild(linea);            
        })
    }

    function calcularTotal() {
        // Limpiamos precio anterior
        total = 0;
        // Recorremos el array del carrito
        for (let item of carrito) {
            // De cada elemento obtenemos su precio
            let miItem = baseDeDatos.filter(function (itemBaseDatos) {
                return itemBaseDatos['id'] == item;
            });
            total = total + miItem[0]['precioVenta'];
        }
        // Formateamos el total para que solo tenga dos decimales
        let totalDosDecimales = total.toFixed(2);
        // Renderizamos el precio en el HTML
        $total.textContent = totalDosDecimales;
        document.getElementById('inputTotal').value = totalDosDecimales;
    }
    
    /* Con esto evito que haga efecto el clic en el boton "comprar" cuando el carro esta vacío*/
	document.getElementById('botonComprar').addEventListener('click', (e) =>{
		if(document.getElementById('carroVacio') != null) e.preventDefault();
	});
	
	
	/* Filtrado de productos por categoría */
	document.getElementById('catTodas').addEventListener('click', () => {
		categoriaElegida = ""
		document.querySelector('#items').innerHTML = "";
		renderizarProductos();
	});    
	
	document.getElementById('catGatos').addEventListener('click', () => {
		categoriaElegida = "Alimento para gatos";
		document.querySelector('#items').innerHTML = "";
		renderizarProductos();
	});

	document.getElementById('catPerros').addEventListener('click', () => {
		categoriaElegida = "Alimento para perros";
		document.querySelector('#items').innerHTML = "";
		renderizarProductos();
	});    
	
	document.getElementById('catAves').addEventListener('click', () => {
		categoriaElegida = "Alimento para aves";
		document.querySelector('#items').innerHTML = "";
		renderizarProductos();
	});    
	
	document.getElementById('catPipetas').addEventListener('click', () => {
		categoriaElegida = "Pipetas";
		document.querySelector('#items').innerHTML = "";
		renderizarProductos();
	});
    
	/* Función que arma la base de datos de productos al cargar la pagina
	 * y, además, dibuja los productos en la misma */
	const inicializarProductos = () => {
			let xhr
		    if (window.XMLHttpRequest) xhr = new XMLHttpRequest()
		    else xhr = new ActiveXObject("Microsoft.XMLHTTP")
		    xhr.open('GET', `ProductosPorCategoria?categoria=${categoriaElegida}`)
		    xhr.addEventListener('load', (data) => {
		    	baseDeDatos = JSON.parse(data.target.response)
		    	renderizarProductos()
		    })
		    xhr.send()
	}
    
	// Llamo a la función de carga de productos
	inicializarProductos()	
}