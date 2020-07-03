<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<a class="nav-link active" href="ServletCurso?Value=MenuCurso" >Menu</a>
				<li class="nav-item"><a class="nav-link  active"
					href="MenuAdministradorAlumnos.jsp">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletProfesor?Param=1">Profesores</a></li>
				<li class="nav-item"><a class="nav-link"
					href="MenuAdministradorReportes.jsp">Reportes</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item align-right"><a class="nav-link"
					href="Login.jsp">Cerrar Sesion</a></li>
			</ul>
		</div>
	</nav>

	<div class="Container" style="margin: 2%">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<div class="row">
					<div class="col-4">
						<select class="form-control form-control-lg">
							<option>Buscar por..</option>
							<option>Nombre</option>
							<option>Apellido</option>
							<option>Dni</option>
							<option>Legajo</option>
						</select>
					</div>
					<div class="col-4">
						<input type="text" class="form-control" name="Txt_Buscar" />
					</div>
					<div class="col-2">
						<input type="submit" class=" btn btn-primary btn-lg"
							value="Buscar" name="Btn_Buscar_Usuario" />
					</div>
					<div class="col-2">
						<a href="Perfil.jsp" class="btn btn-success btn-lg" role="button" >Crear</a>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<table class="table table-bordered table-hover" 
							style="margin-top: 2%">

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
								<tr>
									<td><a class="nav-link" href="Perfil.jsp">18888</a></td>
									<td>Nicolas Barraza</td>
									<td>48888888</td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>


								</tr>
								<tr>
									<td>14849</td>
									<td>Maria Laura</td>
									<td>27777777</td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>


								</tr>
								<tr>
									<td>89991</td>
									<td>Leonel furister</td>
									<td>26666666</td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	</div>


</body>
</html>