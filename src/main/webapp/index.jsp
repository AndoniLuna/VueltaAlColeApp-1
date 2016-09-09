<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/index.css">



<div id="fullscreen_bg" class="fullscreen_bg"/>

<%
	//Gestion de mensajes
	if(null != request.getAttribute("mensaje")){
		out.print("<p style=\"color:white;font-size:25px;\">");
		out.print(request.getAttribute("mensaje"));
		out.print("</p>");
	}
%>
	<div class="container">	
		<form class="form-signin" method="post" action="login">
			<h1 class="form-signin-heading text-muted">INICIO SESIÓN</h1>
			<input type="text" name="usuario" class="form-control" placeholder="User" required="" autofocus="">
			<input type="password" name="pass" class="form-control" placeholder="Password" required="">
			<button class="btn btn-lg btn-primary btn-block" type="submit">
				CONECTARSE
			</button>
		</form>
	
	</div>
		<button class="btn btn-lg btn-primary btn-block reg"><a href="formulario_inscripcion.jsp">REGISTRARSE</a></button>
</div>




	<!-- Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<!-- Boostrap Latest compiled and minified JavaScript -->
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>