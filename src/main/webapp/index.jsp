Hola Esto funciona

<%@page import="java.util.Date"%>
<%
	Date fecha = new Date();
	out.print( fecha );
%>

<a href="login">Login</a>

<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<!-- juego de caracteres -->
<title>Vuelta al Cole | Login </title>
<!-- titulo de la pagina-pestaña -->

<base href="http://localhost:8080/VueltaAlColeApp/">
<meta name="description" content="App Web con JEE">
<meta name="author" content="Ipartek Formacion SL">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


    
</head>

<body>

<div class="container">

	<div class="row">

		<div class="wrap">
			<p class="form-title">Necesitas logearte</p>
		
			<form method="post" action="login">
			
				
				Usuario: <input type="text" name="usuario" required placeholder="Tu nombre">
				<br>
				<br>	
				Password: <input type="password" name="pass" required>
			
				<br><br>
				
				
				
				
				
				<input type="submit" class="btn btn-success btn-sm"  value="Login" />
			
			</form>
		</div>	
		
	</div> <!-- row -->
</div> <!-- container -->

	<!-- Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Boostrap Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</body>
</html>