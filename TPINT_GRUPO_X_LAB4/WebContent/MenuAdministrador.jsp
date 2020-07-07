<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Curso" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Administrador</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link active" href="ServletCurso?Cursos=1">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletAlumnos?Alumnos=1">Alumnos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletProfesor?Profesores=1">Profesores</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletReportes?Reportes=1">Reportes</a>
      </li>
    </ul>
    <ul class="navbar-nav">
     <li class="nav-item align-right">
        <a class="nav-link" href="ServletUsuario?Usuario=1">Cerrar Sesion</a>
      </li>
    </ul>
  </div>	
</nav>

<table id="TablaMenuAdmin" class="table table-bordered table-hover" style="margin-top: 2%">
    <thead class="thead-dark">
        <tr>
            <th>Materia</th>
            <th>Cuatrimestre</th>
            <th>Año</th>
            <th>Nombre de Profesor</th>
            <th>Legajo</th>
            <th></th>
        </tr>
    </thead>
    
    <tbody>
<%
    List<Curso> list = (List<Curso>) request.getAttribute("Tabla");
    for(Curso curso : list) {
    	%>
        <tr>
            <td><%=curso.getNMateria().getNombre() %></td>
            <td><%=curso.getCuatrimestre() %></td>
            <td><%=curso.getAño() %></td>
            <td><%=curso.getNProfesor().getNombre() %></td>
            <td><a href="ServletPerfil?Profesor= <%=curso.getNProfesor().getIdProfesor()%>"> 
            <%=curso.getNProfesor().getLegajo()%>
            </a>
            </td>
            <td><a href="ServletCurso?VerCurso= <%=curso.getIdNumCurso() %>" class="btn btn-primary btn-lg" role="button">Ver Curso</a>
            </td>
            
            
        </tr>
       
<%
}
    
%>
     </tbody>

</table>

<%
out.print(request.getAttribute("ScriptTabla"));  
%>


</body>
</html>