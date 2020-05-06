<div class="container">
   <br><br>
	<h2 class="text-center">Alta de cliente</h2>
               <div class="col-md-6 mx-auto text-center">
			      <div class="header-title">
			        <h6 class="wv-heading--subtitle">
			           Usuario y contraseña
			        </h6>
			      </div>
			   </div>
   <div class="row">
      <div class="col-md-4 mx-auto">
         <div class="myform form ">
            <form action="CliRegistro" method="post" name="formularioRegistro">            
               <div class="form-group">
                  <input type="text" name="usuario"  class="form-control my-input" id="usuario" placeholder="Nombre de usuario" required="required">
               </div>
               <div class="form-group">
                  <input type="password" name="contrasena1"  class="form-control my-input" id="contrasena1" placeholder="Contraseña" required="required">
               </div>
               <div class="form-group">
                  <input type="password" name="contrasena2"  class="form-control my-input" id="contrasena2" placeholder="Reingrese su contraseña" required="required">
               </div>
               <hr>
               <div class="col-md-6 mx-auto text-center">
			      <div class="header-title">
			        <h6 class="wv-heading--subtitle">
			           Datos personales
			        </h6>
			      </div>
			   </div>
               <div class="form-group">
                  <input type="text" name="nombre"  class="form-control my-input" id="nombre" placeholder="Nombre" required="required">
               </div>
               <div class="form-group">
                  <input type="text" name="apellido"  class="form-control my-input" id="apellido" placeholder="Apellido" required="required">
               </div>
               <div class="row justify-content-center">
               	  <div class="form-group">
                 	<select class="form-control" id="tipoDoc" name="tipoDoc">
                     <option value="DNI" selected>DNI</option>
                     <option value="LE">LE</option>
                     <option value="LC">LC</option>
                     <option value="Pasaporte">Pasaporte</option>
                 	</select>
	              </div>
	              <div class="form-group">
	              	<input type="text" name="documento"  class="form-control my-input" id="documento" placeholder="Número de documento" required="required">
	              </div>
               </div>
               <div class="form-group">
                  <input type="text" name="domicilioCalle"  class="form-control my-input" id="domicilioCalle" placeholder="Calle" required="required">
               </div> 
               <div class="form-group">
                  <input type="text" name="domicilioNumero"  class="form-control my-input" id="domicilioNumero" placeholder="Número" required="required">
               </div>
               <div class="form-group">
                  <input type="text" name="domicilioPiso"  class="form-control my-input" id="domicilioPiso" placeholder="Piso">
               </div>
               <div class="form-group">
                  <input type="text" name="domicilioDepto"  class="form-control my-input" id="domicilioDepto" placeholder="Departamento">
               </div>
               <div class="form-group">
                  <input type="tel" name="telefono"  class="form-control my-input" id="telefono" placeholder="Teléfono" required="required">
               </div>
               <div class="form-group">
                  <input type="email" name="correoElectronico"  class="form-control my-input" id="correoElectronico" placeholder="Correo electrónico" required="required">
               </div>
               <div class="text-center ">
                  <button type="submit" class=" btn btn-block send-button tx-tfm bg-info">Crear cuenta</button>
               </div>
            </form>
         </div>
      </div>
   </div>   
</div>
<br><br>