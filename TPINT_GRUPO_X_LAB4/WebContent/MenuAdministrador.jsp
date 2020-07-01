<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Administrador</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
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
				Tecnico Universitario en Programación
				</h2>
				<hr>
				
					<div class="col-3">
						<input type="submit" class="btn btn-success btn-lg btn-block" value="Crear Curso" name="BtnCrearCurso"/>
					</div>
			
				<div class="container mb-5 mt-3">
				<table class="table table-bordered table-hover"	style="margin-top: 2%" id="TableMenuAdmin">

					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th scope="col">Materia</th>
							<th scope="col">Cuatrimestre</th>
							<th scope="col">Año</th>
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
</div>
</form>
					
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script>					
   $('#TableMenuAdmin').DataTable({

	   pagingType: 'full_numbers'
   });
</script>	
</body>
</html>