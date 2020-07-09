<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@page import ="entidad.Materia" %>
  <%@page import ="java.util.ArrayList" %> 
  <%@page import ="entidad.Instancia" %>
    <%@page import ="entidad.Profesor" %>
    <%@page import ="entidad.Alumno" %>
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

	<form method="post" action="ServletProfesor" style="margin:2%">
	<input type="submit" class="btn btn-primary btn-lg" value="Actualizar" name="BtnActualizar"/>
		<div class="form-row">
			<div class="col-3">
			<%
						ArrayList<Materia> ListarMaterias = null;
						if(request.getAttribute("listarMaterias")!=null)
						{
							ListarMaterias = (ArrayList<Materia>) request.getAttribute("listarMaterias");
						}
			%>
				<label>Materia:</label>
				<select class="form-control" name="DDLMaterias" id="IdMateria">
					<option disabled>Seleccione una Materia...</option>
					<% if(ListarMaterias!=null)
						for (Materia a : ListarMaterias)
							{
						%>
					<option value="<%= a.getIdMateria()%>"><%=a.getNombre()%></option>
				<%} %>
				</select>
				<input type="hidden" id="IdMat" name="IdMateria">
			</div>
			<div class="col-3">
			<label>Cuatrimestre:</label>
				<select class="form-control" id="cuatri" name="cuatri">
				<option disabled>Seleccione un cuatrimestre...</option>
				<option value="Primer Cuatrimestre">Primer Cuatrimestre</option>
				<option value = "Segundo Cuatrimestre">Segundo Cuatrimestre</option>
				</select>
			</div>
			
			
			<div class="col-1">
			<label>Año:</label>
				<input type="number" min="2020" max="2100" class="form-control" id = "año" name = "año" required>
			</div>
			<%
						ArrayList<Profesor> ListarProfesor = null;
						if(request.getAttribute("listarProfesor")!=null)
						{
							ListarProfesor = (ArrayList<Profesor>) request.getAttribute("listarProfesor");
						}
				%>
			<div class="col-5">
			<label>Profesor:</label>
				<select class="form-control" name="DDLProfesores" id="IdProfesor">
					<option disabled>Seleccione un Profesor...</option>
					<% if(ListarProfesor!=null)
						for (Profesor p : ListarProfesor)
							{
						%>

					<option value="<%=p.getIdProfesor()%>"><%=p.getNombre() + " " + p.getApellido()%> /<%=p.getLegajo() %> / <%=p.getDni() %></option>
					<%} %>
				</select>
				<input type="hidden" id="IdProf" name="IdProfesor">
			</div>
		</div>
				<%
						ArrayList<Alumno> ListarAlumno = null;
						if(request.getAttribute("listarAlumno")!=null)
						{
							ListarAlumno = (ArrayList<Alumno>) request.getAttribute("listarAlumno");
						}
				%>


	<div class="container">
		<div class="row">
			<div class="col-5">
			<select class="custom-select" size="9" name="Alum" id="Alum">
  			<% if(ListarAlumno!=null)
						for (Alumno a : ListarAlumno)
							{
						%>
  				<option value="<%=a.getIdAlumno()%>"><%=a.getNombre() +" " + a.getApellido()%> / <%=a.getLegajo() %>/<%=a.getDni() %></option>
 				 <%} %>
			</select>
			</div>
			<div class="col-2" style="text-align:center">
			<br>
			<br>
			<input type="submit" class="btn btn-primary" value="Cargar Alumnos" name="BtnCargaDeDatos"/>
			<br>
			<br>
			<input type="submit" class="btn btn-primary" value="inscribir" name="BtnInsertar"/>
			<br>
			<br>
			<input type="submit" class="btn btn-danger" value="Desinscribir" name="Desinscribir"/>
			<br>
			<input type="submit" class="btn btn-success" id="BtnGuardar" name="BtnGuardar"value="Guardar"/>
			<%
						ArrayList<Alumno> ListarAlumnoInscriptos = null;
						if(request.getAttribute("listarAlumnoIns")!=null)
						{
							ListarAlumnoInscriptos = (ArrayList<Alumno>) request.getAttribute("listarAlumnoIns");
						}
				%>
			</div>
			<div class="col-5">

					<select class="custom-select" size="9" name="AlumInscriptos2" id="AlumInscriptos2">
					<% if(ListarAlumnoInscriptos!=null)
						for (Alumno ai : ListarAlumnoInscriptos)
							{
						%>

  						<option value="<%= ai.getIdAlumno()%>">
  						<%=ai.getNombre()+" "+ ai.getApellido() %>/<%=ai.getLegajo() %>/<%=ai.getDni() %></option>
   						<%
   						} 
   						%>
					</select>
   						<% if(ListarAlumnoInscriptos!=null)
   						for (Alumno ai : ListarAlumnoInscriptos)
							{
						%>
					<input type="hidden" value="<%=ai.getIdAlumno()%>" name="AlumInscriptos" id="AlumInscriptos">
						<%
   						} 
   						%>
			</div>
		</div>

	</div>
	</form>
</body>
</html>