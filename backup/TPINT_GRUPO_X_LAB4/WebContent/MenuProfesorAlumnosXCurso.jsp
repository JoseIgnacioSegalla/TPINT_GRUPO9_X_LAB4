<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AlumnosXCurso</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.0/css/bootstrap4-toggle.min.css" rel="stylesheet">  
<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.0/js/bootstrap4-toggle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
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

<div class="Container" style="margin:2%">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<h2>
				Curso: Materia | Cuatrimestre | Año
				</h2>
				<hr>
				<div class="row">
						<div class="col-4">
						<select class="form-control form-control-lg">
							<option>Ordenar por..</option>
							<option>Nombre</option>
							<option>Apellido</option>
							<option>Dni</option>
							<option>Legajo</option>
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
				<div class="row">
				<table class="table table-bordered table-hover"
					style="margin-top: 2%">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th colspan="4">Carga Masiva de Notas:</th>
							<th scope="col">  <input type="text" class="form-control" name="1erParcial"></th>
							<th scope="col">  <input type="text" class="form-control" name="2doParcial"></th>
							<th scope="col">  <input type="text" class="form-control" name="1erRecuperatorio"></th>
							<th scope="col">  <input type="text" class="form-control" name="2doRecuperatorio"></th>
						</tr>
						<tr>
							
							<th scope="col">Legajo</th>
							<th scope="col">Nombre y apellido</th>
							<th scope="col">Dni</th>
							<th scope="col">Estado</th>
							<th scope="col">1er Parcial</th>
							<th scope="col">1er Recup.</th>
							<th scope="col">2do Parcial</th>
							<th scope="col">2do Recup.</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="MenuProfesorAlumnos.jsp">18888</a></td>
							<td>Nicolas Barraza</td>
							<td>48888888</td>
							<td>
								<div class="custom-control custom-switch">
									<input type="checkbox" class="custom-control-input"
										id="customSwitch1"> <label
										class="custom-control-label" for="customSwitch1"></label>
								</div>
							</td>
							<td><input type="text" class="form-control" name="1erParcial"></td>
							<td><input type="text" class="form-control" name="2doParcial"></td>
							<td><input type="text" class="form-control" name="1erRecuperatorio"></td>
							<td><input type="text" class="form-control" name="2doRecuperatorio"></td>
						</tr>
						<tr>
							<td><a href="MenuProfesorAlumnos.jsp">14849</a></td>
							<td>Maria Laura</td>
							<td>27777777</td>
							<td><div class="custom-control custom-switch">
									<input type="checkbox" class="custom-control-input"
										id="customSwitch2"> <label
										class="custom-control-label" for="customSwitch2"></label>
								</div></td>
							<td><input type="text" class="form-control" name="1erParcial"></td>
							<td><input type="text" class="form-control" name="2doParcial"></td>
							<td><input type="text" class="form-control" name="1erRecuperatorio"></td>
							<td><input type="text" class="form-control" name="2doRecuperatorio"></td>
						</tr>
						<tr>
							<td><a href="MenuProfesorAlumnos.jsp">89991</a></td>
							<td>Leonel furister</td>
							<td>26666666</td>
							<td>
							<div class="custom-control custom-switch">
									<input type="checkbox" class="custom-control-input"
										id="customSwitch3"> <label
										class="custom-control-label" for="customSwitch3"></label>
								</div></td>
							<td><input type="text" class="form-control" name="1erParcial"></td>
							<td><input type="text" class="form-control" name="2doParcial"></td>
							<td><input type="text" class="form-control" name="1erRecuperatorio"></td>
							<td><input type="text" class="form-control" name="2doRecuperatorio"></td>
							
						</tr>
					</tbody>
				</table>
				</div>
				<div class="row">
				<button type="button" class="btn btn-success btn-lg btn-block disabled" name="Btn_Guardar_Cambios">Guardar Cambios</button>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
</html>