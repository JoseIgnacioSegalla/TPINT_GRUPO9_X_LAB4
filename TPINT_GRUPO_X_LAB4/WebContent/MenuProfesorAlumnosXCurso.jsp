<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import ="entidad.Alumno" %>
  <%@page import ="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AlumnosXCurso</title>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="ServletCurso?VerCursosProfesor=<%=session.getAttribute("Nombre") %>">Cursos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="SevletPerfil?VerPefilProfesor=<%=session.getAttribute("Nombre") %>"><%=session.getAttribute("Nombre")%></a>
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
				<h3>
				 <%=request.getAttribute("Materia") %>  | <%=request.getAttribute("Cuatrimestre") %> | <%=request.getAttribute("Año") %>
				</h3>
				<hr>
				<br>	
				
					<%
						ArrayList<Alumno> listarNotas = null;
						if(request.getAttribute("listarNotas")!=null)
						{
							listarNotas = (ArrayList<Alumno>) request.getAttribute("listarNotas");
						}
					%>
				
		<form id='form1' method="post" action="ServletAlumnosXCurso">
				
				<!--TABLA  --> 
				<input type="hidden" name="Materia" value="<%=request.getAttribute("Materia") %>">
				<input type="hidden" name="Cuatrimestre" value="<%=request.getAttribute("Cuatrimestre") %>">
				<input type="hidden" name="Año" value="<%=request.getAttribute("Año") %>">
				<input type="hidden" name="IdCurso" value="<%=request.getAttribute("IdCurso") %>">
				<table class="table table-bordered table-hover" style="margin-top: 2%"  id="TablaAdmin" onchange="val1()" >
				
					<!-- CAMBIAR DATOS DE LA TABLA -->
					<thead class="thead-dark">
						<tr>
							<th colspan="4">Carga Masiva de Notas:</th>
							<th scope="col" style=" padding-right:10px; padding-left:10px;">  <input type="number" class="form-control" name="1erParcial" id= "CargaMasiva1"
							min="0" max="10"></th>
							<th scope="col" style=" padding-right:10px; padding-left:10px;">  <input type="number" class="form-control" name="2doParcial" id= "CargaMasiva2"
							min="0" max="10"></th>
							<th scope="col" style=" padding-right:10px; padding-left:10px;">  <input type="number" class="form-control" name="1erRecuperatorio" id= "CargaMasiva3"
							min="0" max="10"></th>
							<th scope="col" style=" padding-right:10px; padding-left:10px;">  <input type="number" class="form-control" name="2doRecuperatorio" id= "CargaMasiva4"
							min="0" max="10"></th>
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
					
						<% if(listarNotas!=null)
						for (Alumno a : listarNotas)
							{
						%>
						<tr>
							
							<td><a href="ServletPerfil?VerPerfilAlumno=<%=a.getIdAlumno() %>"><%=a.getLegajo() %></a><input type="hidden" name="Legajo" value="<%=a.getLegajo() %>"></td>
							<td><%= a.getNombre() + " " + a.getApellido() %><input type="hidden" name="Apellido" value="<%=a.getApellido() %>">	</td>
							<td><%= a.getDni() %><input type="hidden" name="Dni" value="<%=a.getDni() %>"></td>
							<td>
							<select class="form-control" id="AlumnoEstado" name="AlumnoEstado">
						<%
							if(a.getEstado_Alumno().equals("1")){
							%>
							<option value="1" selected>Regular</option>
							<option value="2" >Libre</option>
						<%
							}else{
								
						%>
							<option value="1" >Regular</option>
							<option value="2" selected>Libre</option>
						<%
							}
						 %>
						
						</select>	
						</td>
							

							<td contenteditable="true"><input type="number" class="form-control" name="1erParcial" id="1erParcial" value="<%= a.getLInst().get(0).getNota()%>"
								min="0" max="10">
							<input type="hidden" name="Nota1" value="<%=a.getLInst().get(0).getNota() %>"></td>
							<td contenteditable="true"><input type="number" class="form-control" name="2doParcial" id="2doParcial" value="<%= a.getLInst().get(1).getNota() %>"
								min="0" max="10">
							<input type="hidden" name="Nota2" value="<%=a.getLInst().get(1).getNota() %>"></td>
							<td contenteditable="true"><input type="number" class="form-control" name="1erRecuperatorio" id="1erRecuperatorio"value="<%= a.getLInst().get(2).getNota() %>"
								min="0" max="10">
							<input type="hidden" name="Nota3" value="<%=a.getLInst().get(2).getNota() %>"></td>
							<td contenteditable="true"><input type="text" class="form-control" name="2doRecuperatorio" id="2doRecuperatorio" value="<%= a.getLInst().get(3).getNota() %>"
								min="0" max="10">
							<input type="hidden" name="Nota4" value="<%=a.getLInst().get(3).getNota() %>"></td>
						
						</tr>
						<%
							}
						%>
						
					</tbody>
				</table>
				
				
				<input type="submit"  class="btn btn-success btn-lg btn-block " value="Guardar Cambios" name="Btn_Guardar_Cambios">
				

			</form>	
		</div>
<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>	
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script src="JS/MenuProfAxC.js"></script>

<%
if(request.getAttribute("Script") != null){
out.print(request.getAttribute("Script")); 
}
%>

</body>
</html>
				
				
				
				
				
				
				
				
				
