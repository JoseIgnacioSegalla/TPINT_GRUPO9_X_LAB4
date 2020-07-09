<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Curso"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Reportes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="ServletCurso?param=1">Menu</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletAlumnos?param=1">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletProfesor?param=1">Profesores</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="ServletReportes?Reportes=1">Reportes</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item align-right"><a class="nav-link"
					href="Login.jsp">Cerrar Sesion</a></li>
			</ul>
		</div>
	</nav>
	<div class="container" style="margin: 2%">
		<form action="ServletReportes" method="get">
			<div class="row">
				<div class="col-12">
					<div class="row">
						<div class="col-6">
							<select class="custom-select custom-select-lg mb-3" name="Filtro">
								<option value="0" disabled>Filtrar por...</option>
								<option value="1">Alumnos</option>
								<option value="2">Profesores</option>
								<option value="3">Cursos</option>
								<option value="4">Materias</option>

							</select>
						</div>
						<div class="col-6">
							<select class="custom-select custom-select-lg mb-3" name="tipo">
								<option value="0" disabled>Mostrar por....</option>
								<option value="1">(%) estado de alumno</option>
								<option value="2">(%) prom. de notas</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">

					<div class="row">
						<div class="col-2">
							<input type="number" class="form-control" min="2000" max="2020"
								name="Año" placeholder="Ingrese Año..." required>
						</div>
						<div class="col-8">
							<select name="Cuatrimestre"
								class="custom-select custom-select-lg mb-3">
								<option value="0">Elegir Cuatrimestre...</option>
								<option value="1">Primer Cuatrimestre</option>
								<option value="2">Segundo Cuatrimetre</option>
								<option value="3">Tercer Cuatrimestre</option>
							</select>
						</div>
						<div class="col-2">
							<input type="submit" class="form-control btn btn-primary btn-lg"
								name="" value="Mostrar Tabla">
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover" id="TablaReportes"
					style="margin-top: 2%">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th>Materia</th>
							<th>Cuatrimestre</th>
							<th>Año</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Curso> LCurso = (List<Curso>) request.getAttribute("Tabla");
						if (LCurso != null) {
							for (Curso Cur : LCurso) {
						%>

						<tr>
							<td><%=Cur.getNMateria().getNombre()%></td>
							<td><%=Cur.getCuatrimestre()%></td>
							<td><%=Cur.getAño()%></td>
							<td>80%</td>

						</tr>


						<%
							}
						}
						%>

					</tbody>
				</table>

			</div>

		</div>
	</div>
</body>
</html>