<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Profesor</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="MenuProfesor.jsp">Cursos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Perfil.jsp">Perfil</a>
      </li>
    </ul>
    <ul class="navbar-nav">
     <li class="nav-item align-right">
        <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
      </li>
    </ul>
  </div>
</nav>
<div class="Container" style="margin-top:2%">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h2 style="text-align: center">
				Tecnico Universitario en Programación
				</h2>
				<hr>
				<div class="row">
						<div class="col-4">
						<select class="form-control form-control-lg">
							<option>Ordenar por..</option>
							<option>Materia</option>
							<option>Cuatrimestre</option>
							<option>Año</option>
						</select>
					</div>
					<div class="col-4">
						<select class="form-control form-control-lg">
							<option>De forma..</option>
							<option>Ascendente</option>
							<option>Descendente</option>	
						</select>
					</div>
					<div class="col-2">
						<button type="submit" class=" btn btn-primary btn-lg">Ordenar</button>
					</div>
				</div>
				<table class="table table-bordered table-hover"
					style="margin-top: 2%">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th scope="col">Materia</th>
							<th scope="col">Cuatrimestre</th>
							<th scope="col">Año</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Laboratorio de Computacion IV</td>
							<td>Tercer</td>
							<td>2019</td>
							<td><a class="btn btn-primary" href="MenuProfesorAlumnosXCurso.jsp" role="button">Ver
									Curso</a></td>
						</tr>
						<tr>
							<td>Programacion I</td>
							<td>Segundo</td>
							<td>2019</td>
							<td><a class="btn btn-primary" href="#" role="button">Ver
									Curso</a></td>
						</tr>
						<tr>
							<td>Programacion III</td>
							<td>Primer</td>
							<td>2020</td>
							<td><a class="btn btn-primary" href="#" role="button">Ver
									Curso</a></td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="col-3"></div>
		</div>
	</div>

</body>
</html>