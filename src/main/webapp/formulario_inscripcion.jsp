<h1>Formulario Inscripcion</h1>

<form action="registro" method="post">

	<input type="text" name="nombre" required placeholder="Tu Nombre" />
	<br>
	<input id="inputEmail" type="email" name="email" required placeholder="Tu Email" />
	<br>
	<input type="password" name="pass" required placeholder="Contraseña" />
	<br>
	<input type="password" name="repass" required placeholder="Repite Contraseña" />

	<br>
	<input type="submit" value="Crear">

</form>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
<script>

	//Nuestro JavaScript para realizar llamada Ajax
	$(function() {
	    console.log( "ready!" );
	    
	    //detectar click en input email
	    $( "#inputEmail" ).keyup(function( event ) {
	    	//console.log( "tecla pulsada" );
	    	//obtener valor del input
	    	var email = $(this).val();
	    	console.debug(email);
	    	
	    });
	    
	    
	    
	});
	
	
	
</script>








