<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Curso"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Profesor</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="ServletCurso?VerCursosProfesor=<%=session.getAttribute("Nombre") %>">Cursos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletPerfil?VerPerfilProfesor=<%=session.getAttribute("Nombre") %>"><%=session.getAttribute("Nombre")%></a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item align-right"><a class="nav-link"
					href="Login.jsp">Cerrar Sesion</a></li>
			</ul>
		</div>
	</nav>
	<div class="Container" style="margin-top: 2%">


		<h2 style="text-align: center">Tecnico Universitario en
			Programación</h2>
		<hr>

		<table id="TablaMenuProfesor" class="table table-bordered table-hover"
			style="margin-top: 2%">
			<thead class="thead-dark">
				<tr>
					<th>Materia</th>
					<th>Cuatrimestre</th>
					<th>Año</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
					List<Curso> list = (List<Curso>) request.getAttribute("Tabla");
				for (Curso curso : list) {
				%>
				<tr>
					<td><%=curso.getNMateria().getNombre()%></td>
					<td><%=curso.getCuatrimestre()%></td>
					<td><%=curso.getAño()%></td>
					<td><a
						href="ServletCurso?VerCurso= <%=curso.getIdNumCurso()%>"
						class="btn btn-primary btn-lg" role="button">Ver Curso</a>
					</td>


				</tr>

				<%
					}
				%>
			</tbody>

		</table>



	</div>
	<%
		out.print(request.getAttribute("ScriptTabla"));
	%>
	<%
	if(request.getAttribute("Script") != null)
		out.print(request.getAttribute("Script"));
	%>
	
</body>
</html>