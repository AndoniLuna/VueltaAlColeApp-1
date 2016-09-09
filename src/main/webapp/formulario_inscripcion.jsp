<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/index.css">

<div id="fullscreen_bg" class="fullscreen_bg"/>

	<div class="container">
	
		<form class="form-signin" method="post" action="registrar">
			<h1 class="form-signin-heading text-muted">CREAR NUEVA CUENTA</h1>
			<input type="text" name="nombre" class="form-control" placeholder="User" required="" autofocus="">
			<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email" required="">
			<input type="password" name="pass" class="form-control" placeholder="Password" required="">
			<input type="password" name="repass" class="form-control" placeholder="Password Confirm" required="">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				REGISTRARSE
			</button>
		</form>
	
	</div>
</div>



	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Boostrap Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	
<script type="text/javascript">
	
	//Nuestro JavaScript para realizar llamada Ajax
	$(function() {
	    console.log( "ready!" );
	    
	    //detectar click en input email
	    $( "#inputEmail" ).keyup(function( event ) {
	    	//console.log( "tecla pulsada" );
	    	//obtener valor del input
	    	var emailValue = $(this).val();
	    	console.debug(emailValue);
	    	
	    	//lamada Ajax al servidor
	    	// CUIDADO llamada asincrona
	    	$.ajax({	    		
	    		  method: "GET",
	    		  url: "checkemail",
	    		  data: { email: emailValue }
	    	
	    		}).done(function( data ) {
	    			if ( data.encontrado ){
	    		    	console.debug("Existe email");
	    		    	$("#inputEmail").css('color','green');
	    			}else{
	    				console.debug("NO Existe email");
	    				$("#inputEmail").css('color','red');
	    			}	
	    		});
	    	
	    	//Las siguientes lineas se procesan seguidas
	    	
	    });
	    
	    
	    
	});

</script>
