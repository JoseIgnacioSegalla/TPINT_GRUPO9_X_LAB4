<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Curso" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Administrador</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
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



 
	




<table id="TablaMenuAdmin" class="table table-hover table-bordered" style="width:80%">
    <thead>
        <tr>
            <th>Materia</th>
            <th>Cuatrimestre</th>
            <th>Año</th>
            <th>Nombre de Profesor</th>
            <th>Legajo</th>
            
        </tr>
    </thead>
    
    <tbody>
<%
    ArrayList<Curso> list = (ArrayList<Curso>) request.getAttribute("Tabla");
    for(Curso curso : list) {
    	%>
        <tr>
            <td><%=curso.getNMateria().getNombre() %></td>
            <td><%=curso.getCuatrimestre() %></td>
            <td><%=curso.getAño() %></td>
            <td><%=curso.getNProfesor().getNombre() %></td>
            <td><a href="ServletPerfil?Legajo=<%=curso.getNProfesor().getLegajo()%>"><%=curso.getNProfesor().getLegajo() %></a></td>
          
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