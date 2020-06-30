<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Cursos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="history.back()">Volver</a></li>
			</ul>
		</div>
	</nav>

	<form method="get" action="ServletCurso" style="margin:2%">
		<div class="form-row">
			<div class="col-3">
				<label>Materia:</label>
				<select class="form-control">
					<option>Seleccione una Materia...</option>
					<option>Laboratorio de Computacion I</option>
					<option>Laboratorio de Computacion II</option>
					<option>Laboratorio de Computacion III</option>
					<option>Laboratorio de Computacion IV</option>
					<option>Programacion I</option>
					<option>Programacion II</option>
					<option>Programacion III</option>

				</select>
			</div>
			<div class="col-3">
			<label>Cuatrimestre:</label>
				<select class="form-control">
					<option>Seleccione un cuatrimestre...</option>
					<option>Primer Cuatrimestre</option>
					<option>Segundo Cuatrimestre</option>
					<option>Tercer Cuatrimestre</option>
				</select>
			</div>
			<div class="col-1">
			<label>Año:</label>
				<input type="number" min="2020" max="2100" class="form-control">
			</div>
			<div class="col-5">
			<label>Profesor:</label>
				<select class="form-control">
					<option>Seleccione un Profesor...</option>
					<option>Matias Loker / 18593 / 489993251</option>
					<option>Lucas Butermann / 18991 / 38999152</option>
					<option>Cecilia Stone / 15429 / 337419</option>
				</select>
			</div>
		</div>
	</form>


	<div class="container">
		<div class="row">
			<div class="col-5">
			<select class="custom-select" size="9">
  
  <option value="1">Alumno1</option>
  <option value="2">Alumno2</option>
  <option value="3">Alumno3</option>
  <option value="4">Alumno4</option>
  <option value="5">Alumno5</option>
  <option value="6">Alumno6</option>
  <option value="7">Alumno7</option>
  <option value="8">Alumno8</option>
  <option value="9">Alumno9</option>
  <option value="10">Alumno10</option>
  <option value="11">Alumno11</option>
  <option value="12">Alumno12</option>
  <option value="13">Alumno13</option>
  <option value="14">Alumno14</option>
  <option value="15">Alumno15</option>
</select>
			</div>
			<div class="col-2" style="text-align:center">
			<input type="submit" class="btn btn-primary" value="inscribir"/>
			<br>
			<br>
			<br>
			<input type="submit" class="btn btn-danger" value="Desinscribir"/>
			<br>
			<br>
			<br>
			<input type="submit" class="btn btn-success" value="Guardar"/>
			</div>
			<div class="col-5">
			
			<select class="custom-select" size="9">
  <option value="1">Alumno16</option>
  <option value="2">Alumno17</option>
  <option value="3">Alumno18</option>
  <option value="4">Alumno19</option>
  <option value="5">Alumno20</option>
  <option value="6">Alumno21</option>
  <option value="7">Alumno22</option>
  <option value="8">Alumno23</option>
  <option value="9">Alumno24</option>
  <option value="10">Alumno25</option>
  <option value="11">Alumno26</option>
  <option value="12">Alumno27</option>
  <option value="13">Alumno28</option>
  <option value="14">Alumno29</option>
  <option value="15">Alumno30</option>
</select>
			</div>
		</div>

	</div>
</body>
</html>