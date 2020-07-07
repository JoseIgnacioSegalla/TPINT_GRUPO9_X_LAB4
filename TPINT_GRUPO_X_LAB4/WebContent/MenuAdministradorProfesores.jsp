<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Profesor"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Profesores</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="ServletCurso?Cursos=1">Menu</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ServletAlumnos?Alumnos=1">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link active"
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

<form  action="ServletUsuario" method="get">
						<table class="table table-bordered table-hover"
							style="margin-top: 2%" id="TablaMenuAdminProfesores">

							<!-- CAMBIAR DATOS DE LA TABLA -->
							<thead class="thead-dark">

								<tr>

									<th scope="col">Legajo</th>
									<th scope="col">Nombre y apellido</th>
									<th scope="col">Dni</th>
									<th scope="col">Usuario</th>
									<th scope="col">Clave</th>
									<th scope="col"></th>
									<th scope="col"></th>

								</tr>
							</thead>
							<tbody>


								<%
									List<Profesor> LProfesor = (List<Profesor>) request.getAttribute("Tabla");
									for (Profesor prof : LProfesor) 
									{
										
								%>
								<tr>
								
									
									<td><a class="nav-link" href="ServletPerfil?VerProfesor=<%=prof.getIdProfesor() %>"><%=prof.getLegajo()%> </a></td>
									<td><%=prof.getNombre()%></td>
									<td><%=prof.getDni() %></td>
									<td><input id="Nombre" class="form-control" name="Nombre" type="text" value="<%=prof.getNUs().getNombre() %>"></td>
									<td><input id="Clave" class="form-control" name="Clave" type="text" value="<%=prof.getNUs().getClave() %>"></td>
									
									<td><input id="Guardar" class="form-control btn btn-primary" name="GuardarUsuario" type="submit" value="Guardar"><input id="IdProfesor" type="hidden" name="IdProfesor" value="<%=prof.getIdProfesor()%>"></td>
									
									<td><input id="Eliminar" class="form-control btn btn-danger" name="EliminarProfesor" type="submit" value="Eliminar"></td>
									
								
								</tr>
								<%
									}
								%>
								
							</tbody>
						</table>
		</form>				

<%
    out.print(request.getAttribute("ScriptTabla"));  
%>
<%
if(request.getAttribute("Script")!= null){	
	out.print(request.getAttribute("Script"));  
}
%>

<script src="jquery-3.5.1.min.js"></script>
<script>
$('#TablaMenuAdminProfesores tbody').on('click','#Guardar',function(){
	var currow = $(this).closest('tr');
	var col1 = currow.find("td:eq(3) input[type='text']").val();
	var col2 = currow.find("td:eq(4) input[type='text']").val();
	var col3 = currow.find("td:eq(5) input[type='hidden']").val();
	
	$("#Nombre").val(col1);
	$("#Clave").val(col2);
	$("#IdProfesor").val(col3);
	
	var result = col1 +'\n' + col2 + '\n' + col3;
	alert(result);
	
})
</script>


</body>
</html>