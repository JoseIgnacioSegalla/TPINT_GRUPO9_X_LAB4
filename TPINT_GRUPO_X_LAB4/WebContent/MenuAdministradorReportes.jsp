<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Reportes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="ServletCurso?Cursos=1">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletAlumnos?Alumnos=1">Alumnos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletProfesor?Profesores=1">Profesores</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="ServletReportes?Reportes=1">Reportes</a>
      </li>
    </ul>
    <ul class="navbar-nav">
     <li class="nav-item align-right">
        <a class="nav-link" href="Login.jsp">Cerrar Sesion</a>
      </li>
    </ul>
  </div>
</nav>
<div class="container" style="margin:2%">
<div class="row">
<div class="col-12">
<form>
  <div class="row">
    <div class="col-6">
      <select class="custom-select custom-select-lg mb-3">
  <option value="1">Filtrar por...</option>
  <option value="2">Alumnos</option>
  <option value="3">Profesores</option>
  <option value="4">Cursos</option>
  <option value="5">Materia</option>
  
</select>
 </div>
    <div class="col-6">
  <select class="custom-select custom-select-lg mb-3">
  <option value="1">Mostrar por....</option>
  <option value="2">(%) estado de alumno</option>
  <option value="3">(%) prom. de notas</option>
</select>
  </div>
  </div>
</form>
</div>
</div>
<div class="row">
<div class="col-12">
<form>
  <div class="row">
   <div class="col-2">
     <input type="number" class="form-control" min="2000" max="2020" placeholder="Ingrese Año...">
 </div>
    <div class="col-6">
 	   <select class="custom-select custom-select-lg mb-3">
  <option value="1">Elegir Cuatrimestre...</option>
  <option value="2">Primer Cuatrimestre</option>
  <option value="3">Segundo Cuatrimetre</option>
  <option value="4">Tercer Cuatrimestre</option>
  
</select>
  </div>
  <div class="col-2">
  <input type="submit" class="btn btn-primary" value="Mostrar Tabla">
  </div>
  <div class="col-2">
  <a class="btn btn-primary" href="Reportes.jsp" role="button">Ver Grafico</a>
  </div>
  </div>
</form>

</div>

</div>
<div class="row">
<div class="col-12">
<table class="table table-bordered table-hover"
					style="margin-top: 2%">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th scope="col">Materia</th>
							<th scope="col">Cuatrimestre</th>
							<th scope="col">Año</th>
							<th scope="col">Estado Porcentual de regularidad</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Laboratorio de Computacion IV</td>
							<td>Tercer</td>
							<td>2019</td>
							<td>75%</td>
						</tr>
						<tr>
							<td>Programacion I</td>
							<td>Tercer</td>
							<td>2019</td>
							<td>80%</td>
						
						</tr>
						<tr>
							<td>Programacion III</td>
							<td>Tercer</td>
							<td>2019</td>
							<td>90%</td>
							
						</tr>
					</tbody>
				</table>

</div>

</div>
</div>
</body>
</html>