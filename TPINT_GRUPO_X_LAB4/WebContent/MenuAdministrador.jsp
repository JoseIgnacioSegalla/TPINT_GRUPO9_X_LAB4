<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Administrador</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link active" href="MenuAdministrador.jsp">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MenuAdministradorAlumnos.jsp">Alumnos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletProfesor?Param=1">Profesores</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MenuAdministradorReportes.jsp">Reportes</a>
      </li>
    </ul>
    <ul class="navbar-nav">
     <li class="nav-item align-right">
        <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
      </li>
    </ul>
  </div>
</nav>
<form method="get" action="ServletCurso">
<div class="Container" style="margin:2%">
		<div class="row">
			<div class="col-12">
				<h2 style="text-align: center">
				Tecnico Universitario en Programaci�n
				</h2>
				<hr>
				<div class="row">
						<div class="col-3">
						<select class="form-control form-control-lg">
							<option>Ordenar por..</option>
							<option>Materia</option>
							<option>Cuatrimestre</option>
							<option>A�o</option>
							<option>Nombre de Profesor</option>
							<option>Legajo</option>
						</select>
					</div>
					<div class="col-3">
						<select class="form-control form-control-lg">
							<option>De forma..</option>
							<option>Ascendente</option>
							<option>Descendente</option>	
						</select>
					</div>
					<div class="col-3">
						<button type="submit" class=" btn btn-primary btn-lg ">Ordenar</button>
					</div>
					<div class="col-3">
						<input type="submit" class="btn btn-success btn-lg btn-block" value="Crear Curso" name="BtnCrearCurso"/>
					</div>
				</div>
				<table class="table table-bordered table-hover"
					style="margin-top: 2%">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th scope="col">Materia</th>
							<th scope="col">Cuatrimestre</th>
							<th scope="col">A�o</th>
							<th scope="col">Nombre del Profesor</th>
							<th scope="col">Legajo</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Laboratorio de Computacion IV</td>
							<td>Tercer</td>
							<td>2019</td>
							<td>Carlos Moirea</td>
							<td>18859</td>
							<td><input type="submit" class="btn btn-primary" value="Ver Curso" name="BtnVerCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Modificar Curso" name="BtnModificarCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Eliminar Curso" name="BtnEliminarCurso"></td>
					
						</tr>
						<tr>
							<td>Programacion I</td>
							<td>Segundo</td>
							<td>2019</td>
							<td>Pepe Rosamonte</td>
							<td>15629</td>
							<td><input type="submit" class="btn btn-primary" value="Ver Curso"  name="BtnVerCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Modificar Curso"  name="BtnVerCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Eliminar Curso"  name="BtnVerCurso"></td>
						</tr>
						<tr>
							<td>Programacion III</td>
							<td>Primer</td>
							<td>2020</td>
							<td>Maria Guadalupe</td>
							<td>13419</td>
							<td><input type="submit" class="btn btn-primary" value="Ver Curso"  name="BtnVerCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Modificar Curso"  name="BtnVerCurso"></td>
							<td><input type="submit" class="btn btn-primary" value="Eliminar Curso"  name="BtnVerCurso"></td>
							
						</tr>
					</tbody>
				</table>

			</div>
	</div>
</div>
</form>

</body>
</html>