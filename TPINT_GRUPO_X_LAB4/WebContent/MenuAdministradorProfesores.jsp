<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Profesor"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Profesores</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="ServletCurso?param=1">Menu</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletAlumnos?param=1">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="ServletProfesor?param=1">Profesores</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletReportes?param=1">Reportes</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item align-right"><a class="nav-link"
					href="Login.jsp">Cerrar Sesion</a></li>
			</ul>
		</div>
	</nav>


						<table class="table table-bordered table-hover"
							style="margin-top: 2%" id="TablaMenuAdminProfesores">

							<!-- CAMBIAR DATOS DE LA TABLA -->
							<thead class="thead-dark">

								<tr>

									<th scope="col">Legajo</th>
									<th scope="col">Nombre y apellido</th>
									<th scope="col">Dni</th>
									<th scope="col">Usuario</th>
									<th scope="col">Clave</th>
									<th scope="col"></th>
									<th scope="col"></th>

								</tr>
							</thead>
							<tbody>


								<%
									List<Profesor> LProfesor = (List<Profesor>) request.getAttribute("Tabla");
									for (Profesor prof : LProfesor) {
								%>
								<tr>
									<td><a class="nav-link" href="ServletProfesor?VerProfesor=<%=prof.getLegajo()%>"><%=prof.getLegajo()%> </a></td>
									<td><%=prof.getNombre()%></td>
									<td><%=prof.getDni() %></td>
									<td><input class="form-control" type="text" placeholder="<%=prof.getNUs().getNombre() %>"></td>
									<td><input class="form-control" type="text" placeholder="<%=prof.getNUs().getClave() %>"></td>
									<td><a href="ServletProfesor?GuardarProfesor=<%=prof.getNUs().getIdUsuario() %>" class="btn btn-primary btn-lg" role="button" >Guardar</a></td>
									<td><a href="ServletProfesor?EliminarProfesor=<%=prof.getNUs().getIdUsuario() %>" class="btn btn-danger btn-lg" role="button" >Eliminar</a></td>
								


								</tr>
								<%
									}
								%>
								
							</tbody>
						</table>
<%
    out.print(request.getAttribute("ScriptTabla"));  
%>
						
</body>
</html>