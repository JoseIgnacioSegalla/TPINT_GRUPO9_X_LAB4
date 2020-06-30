<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Profesor" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Profesores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>

			<%
			String p =null;
			//Profesor prof;
			List<Profesor> listaP= null;
			if(request.getAttribute("listaP")!=null)
			listaP = (List<Profesor>)request.getAttribute("listaP");
			
			
			
			%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="MenuAdministrador.jsp">Inicio</a></li>
				<li class="nav-item"><a class="nav-link"
					href="MenuAdministradorAlumnos.jsp">Alumnos</a></li>
				<li class="nav-item"><a class="nav-link   active"
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
			<div class="col-1"></div>
			<div class="col-10">
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
						<input type="submit" class=" btn btn-primary btn-lg btn-block"
							value="Buscar" name="Btn_Buscar_Usuario" />
					</div>
					<div class="col-2">
						<a href="Perfil.jsp" class="btn btn-success btn-lg btn-block" role="button" >Crear</a>
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
									<th scope="col">Usuario</th>
									<th scope="col">Clave</th>
									<th scope="col"></th>
									<th scope="col"></th>

								</tr>
							</thead>
							<tbody>
							
							
							<%for(Profesor prof: listaP){
								
								
							
								%>
								<tr>
									<td><a class="nav-link" href="Perfil.jsp">18888</a></td>
									<td> <%=prof.getNombre() %></td>
									<td>477777888</td>
									<td><input  class="form-control" type="text"></td>
									<td><input  class="form-control" type="text"></td>
									<td><input type="submit" value="Guardar"
										class="btn btn-primary" /></td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>
									


								</tr>
								<% } %>
								<tr>
									<td>14849</td>
									<td>Lion Foremon</td>
									<td>998778488</td>
									<td><input  class="form-control" type="text"></td>
									<td><input  class="form-control" type="text"></td>
									<td><input type="submit" value="Guardar"
										class="btn btn-primary" /></td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>
									


								</tr>
								<tr>
									<td>89991</td>
									<td>Amalia Grumiera</td>
									<td>999886565</td>
									<td><input  class="form-control" type="text"></td>
									<td><input  class="form-control" type="text"></td>
									<td><input type="submit" value="Guardar"
										class="btn btn-primary" /></td>
									<td><input type="submit" value="Eliminar"
										class="btn btn-primary" /></td>
									

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-1"></div>
		</div>
	</div>
</body>
</html>