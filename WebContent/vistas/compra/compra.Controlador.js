window.onload = function () {
    
	/* Archivo JSON con toda la informacion de los productos */
    let baseDeDatos = [
        {
            id: 1,
            nombre: 'Patata',
            precio: 1,
            imagen: 'img/burro.jpg'
        },
        {
            id: 2,
            nombre: 'Cebolla',
            precio: 1.2,
            imagen: 'img/bolsa_gato.jpg'
        },
        {
            id: 3,
            nombre: 'Calabacin',
            precio: 2.1,
            imagen: 'img/bolsa_perros.png'
        },
        {
            id: 4,
            nombre: 'Fresas',
            precio: 0.6,
            imagen: 'img/bolsa_perros.png'
        }

    ]
    
    /* Creación de variables */
    let $items = document.querySelector('#items');
    let carrito = [];
    let total = 0;
    let $carrito = document.querySelector('#carrito');
    let $total = document.querySelector('#total');
    
    // Funciones
    function renderItems() {
        for (let info of baseDeDatos) {
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
            imagenProducto.src = info['imagen'];
            enlaceImagen.appendChild(imagenProducto);
            /* Creo el cuerpo de la tarjeta */
            let cuerpoItem = document.createElement('div');
            cuerpoItem.classList.add('card-body', 'text-center');
            /* Nombre, tamaño y precio */
            let nombreProducto = document.createElement('h5');
            nombreProducto.classList.add('card-title');
            nombreProducto.textContent = `${info['nombre']}`;
            let descripcionProducto = document.createElement('p');
            descripcionProducto.classList.add('card-text');
            descripcionProducto.textContent = `Descripcion de ${info['nombre']}`;
            let elPrecio = document.createElement('h6');
            elPrecio.classList.add('card-subtitle');
            let precioProducto = document.createElement('a');
            precioProducto.textContent = `$${info['precio']}`;
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
            botonPieProducto.setAttribute('marcador', info['id']);
            botonPieProducto.addEventListener('click', anyadirCarrito);
            console.log('El Producto es: ' + info['nombre']);
            console.log('El infoID es: ' + info['id']);
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

    function anyadirCarrito() {
        // Anyadimos el Nodo a nuestro carrito
        carrito.push(this.getAttribute('marcador'))
        // Calculo el total
        calcularTotal();
        // Renderizamos el carrito
        renderizarCarrito();
    }

    function borrarItemCarrito() {
        console.log()
        // Obtenemos el producto ID que hay en el boton pulsado
        let id = this.getAttribute('item');
        // Borramos todos los productos
        carrito = carrito.filter(function (carritoId) {
            return carritoId !== id;
        });
        // volvemos a renderizar
        renderizarCarrito();
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
            /* Armo una variable para guardar inputs y poder manejarlos  con el + y el -*/
            let itemInputId = `#item${item}`;
            // Creamos el nodo del item del carrito
            /* PRIMERO CREÉ EL "NODO", QUE ES UN DIV CON ROW PARA METER CADA ITEM */
            let miNodo = document.createElement('div');
            miNodo.classList.add('row');
            let linea = document.createElement('hr');
            /* ESTE ES EL PEDAZO 1 (UN DIV) CON LA PRIMER PARTE DEL CODIGO DE CADA ITEM DEL CARRITO */
            let pedazo1 = document.createElement('div');
            pedazo1.classList.add('col-12', 'text-sm-center', 'col-sm-12', 'text-md-left', 'col-md-4');
            let h6_1 = document.createElement('h6');
            h6_1.classList.add('product-name');
            h6_1.innerHTML = `<strong>${miItem[0]['nombre']}</strong>`;
            let h6_2 = document.createElement('h6');
            h6_2.innerHTML = `<small>Descripcion</small>`;
            pedazo1.appendChild(h6_1);
            pedazo1.appendChild(h6_2);
            /* ESTE ES EL PEDAZO 2 (UN DIV) CON LA SEGUNDA PARTE DEL CODIGO DE CADA ITEM DEL CARRITO */
            let pedazo2 = document.createElement('div');
            pedazo2.classList.add('col-12', 'col-sm-12', 'text-sm-center', 'col-md-8', 'text-md-right', 'row');
            /* Sub-parte del pedazo 2 */
            let div1 = document.createElement('div');
            div1.classList.add('col-3', 'col-sm-3', 'col-md-4', 'text-md-right');
            div1.style.paddingTop = "5px";
            let h6_3 = document.createElement('h6');
            h6_3.innerHTML = `<h6><strong>$ ${miItem[0]['precio']} <span class="text-muted"> x</span></strong></h6>`;
            div1.appendChild(h6_3);
            /* Otra sub-parte del pedazo 2 */
            let div2 = document.createElement('div');
            div2.classList.add('col-4', 'col-sm-4', 'col-md-6');
            let div2_2 = document.createElement('div');
            div2_2.classList.add('quantity');
            let input1 = document.createElement('input');
            let input2 = document.createElement('input');
            let input3 = document.createElement('input');
            input1.classList.add('minus');
            input2.classList.add('text-center');
            input3.classList.add('plus');
            input1.type = "button";
            input2.name = "item";
            input3.type = "button";
            input1.value = "-";
            input2.value = `${numeroUnidadesItem}`;
            input3.value = "+";
            input1.id = "min";
            input2.id = `item${item}`;
            input3.id = "plus";
            input1.style.cursor = "pointer";
            input2.size = 2;
            input2.disabled = true;
            input3.style.cursor = "pointer";
            div2_2.appendChild(input1);
            div2_2.appendChild(input2);
            div2_2.appendChild(input3);
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
            input1.addEventListener('click', () => {
            	if((parseInt(input2.value)) != 0){
            		input2.value = (parseInt(input2.value) - 1);
            	}            	
            });
            input3.addEventListener('click', () => {
            	input2.value = (parseInt(input2.value) + 1);
            });
            /* ACÁ JUNTO LAS PARTES */
            miNodo.appendChild(pedazo1);
            miNodo.appendChild(pedazo2);
            $carrito.appendChild(miNodo);
            $carrito.appendChild(linea);
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
            total = total + miItem[0]['precio'];
        }
        // Formateamos el total para que solo tenga dos decimales
        let totalDosDecimales = total.toFixed(2);
        // Renderizamos el precio en el HTML
        $total.textContent = totalDosDecimales;
    }

    // Inicio
    renderItems();
}