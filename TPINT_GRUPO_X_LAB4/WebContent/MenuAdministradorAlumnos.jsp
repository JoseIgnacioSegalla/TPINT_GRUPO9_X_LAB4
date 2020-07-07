<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="entidad.Alumno"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Alumnos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="ServletCurso?Cursos=1">Menu</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="ServletAlumnos?Alumnos=1">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletProfesor?Profesores=1">Profesores</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletReportes?Reportes=1">Reportes</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item align-right"><a class="nav-link"
					href="Login.jsp">Cerrar Sesion</a></li>
			</ul>
		</div>
	</nav>


	<table id="TablaMenuAdminAlumnos"
		class="table table-bordered table-hover" style="margin-top: 2%">

		<!-- CAMBIAR DATOS DE LA TABLA -->
		<thead class="thead-dark">

			<tr>

				<th scope="col">Legajo</th>
				<th scope="col">Nombre y apellido</th>
				<th scope="col">Dni</th>
				<th scope="col"></th>

			</tr>
		</thead>
		<tbody>
			<%
			List<Alumno> LAlumnos= (List<Alumno>) request.getAttribute("Tabla");
			for (Alumno Nal : LAlumnos) {
			%>

			<tr>
				<td><a class="nav-link"
					href="ServletPerfil?VerAlumno=<%=Nal.getIdAlumno()%>"><%=Nal.getLegajo()%></a></td>
				<td><%=Nal.getNombre()%></td>
				<td><%=Nal.getDni()%></td>
				<td><a class="btn btn-primary"
					href="ServletAlumnos?EliminarAlumno=<%=Nal.getIdAlumno()%>"
					role="button">Eliminar</a></td>


				<%
					}
				%>
			
		</tbody>
	
	</table>
		<%
			out.print(request.getAttribute("ScriptTabla"));
		%>
		
<%
if(request.getAttribute("GuardadoConExito") != null){
	
	
	
	out.print(request.getAttribute("GuardadoConExito"));  
}

%>


</body>
</html>