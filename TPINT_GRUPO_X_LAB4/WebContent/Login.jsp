<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >

</head>
<body>
	<div class="container" style="margin-top:5%">
	
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<form method="post" action="ServletUsuario">

					<label>Usuario:</label> <input type="text" name="Txt_NomUs" class="form-control">
					<label>Clave:</label> <input type="Password" name="Txt_ClvUs" class="form-control">
					<hr>
					
					<input type="submit" value="Ingresar" class="btn btn-primary btn-block">
				</form>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
</body>

<%
	if(request.getAttribute("Script") != null){
		out.print(request.getAttribute("Script"));
	}
		
	%>
</html>