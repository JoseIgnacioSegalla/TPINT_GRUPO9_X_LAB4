<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidad.Localidad" %>
<%@ page import="entidad.Provincia" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
      <a class="nav-link" href="#" onclick="history.back()" >Volver</a>
      </li>
    </ul>
   
  </div>
</nav>
<form action="ServletPerfil" method="post">
<div class="Container" style="margin:2%">
<%
String x;
if(request.getAttribute("IdAlumno")!= null){
x = "GuardarAlumno";
%>
<input type="hidden" name="IdAlumno" value="<%=request.getAttribute("IdAlumno")%>">
<%
}
else
{
x =  "GuardarProfesor";
%>
<input type="hidden" name="IdProfesor" value="<%=request.getAttribute("IdProfesor")%>">
<% 
}
%>
<div class="row">
<div class="col-6">


  <div class="form-group">
    <label for="Tit_Nom">Nombre:</label>
    <input type="Text" class="form-control" name="Nombre" min="3" max="45" value="<%=request.getAttribute("Nombre") %>" required>
    <br>
    <label for="Tit_Leg">Legajo:</label>
    <input type="number" class="form-control" name="Legajo" min="1" max="99999" value="<%=request.getAttribute("Legajo") %>" required>
    <br>
    <label for="Tit_FechNac">Fecha Nacimiento:</label>
    <input type="date" class="form-control" name="FechaNac" value="<%=request.getAttribute("FechaNac") %>" required>
    <br>
    
	<label for="Tit_Prov">Provincia:</label>
     <%

    if(request.getAttribute("Provincia") != null)
    {
    	System.out.print("Entro");
    List<Provincia> LProv = (List<Provincia>) request.getAttribute("Provincia");	
    %>
    <select class="form-control" name="DDLProvincia" id="IdProvincia" onchange="">
    <option value="0">Seleccione Provincia</option>
    <%
    for(Provincia NProv : LProv){
    	if(NProv.getIdProvincia() == (int) request.getAttribute("IdProvincia"))
    	{
    		%>
    <option value="<%=NProv.getIdProvincia() %>" selected="selected"><%=NProv.getNombre() %></option>
    		<%
    	}else{
    		
    	
    	
    	%>

 	 <option value="<%=NProv.getIdProvincia() %>"><%=NProv.getNombre()%></option>
 	 	
    	<%
    	}
    }
    %>
    </select>
    <%
   	}
    %>
    <br>
    <label for="Tit_Email">Email:</label>
    <input type="email" class="form-control" name="Email" min="8" max="45" value="<%=request.getAttribute("Email") %>" required>
  </div>
	
</div>
<div class="col-6">
 <div class="form-group">

    <label for="Tit_Apellido">Apellido:</label>
    <input type="Text" class="form-control" name="Apellido" min="3" max="45" value="<%=request.getAttribute("Apellido") %>" required>
    <br>
    <label for="Tit_Dni">Dni:</label>
    <input type="number" class="form-control" name="Dni" min="20000000" max="100000000" value="<%=request.getAttribute("Dni") %>" required>
    <br>
    <label for="Tit_Direc">Direccion:</label>
    <input type="Text" class="form-control" name="Direccion" min="8" max="45" value="<%=request.getAttribute("Direccion") %>" required>
    <br>
 	
    <label for="Tit_Loc">Localidad:</label>
    <%

    if(request.getAttribute("Localidad") != null)
    {
    List<Localidad> LLoc = (List<Localidad>) request.getAttribute("Localidad");	
    %>
    
    <select class="form-control" name="DDLLocalidad" id="IdLocalidad">
    <option value="0">Seleccione Localidad</option>
    <%
    for(Localidad NLoc : LLoc){
    	if(NLoc.getIdLocalidad() == (int) request.getAttribute("IdLocalidad"))
    	{
    		%>
    <option value="<%=NLoc.getIdLocalidad() %>" selected="selected"><%=NLoc.getNombre() %></option>
    		<%
    	}else{
    	%>
  <option value="<%=NLoc.getIdLocalidad()%>"><%=NLoc.getNombre()%></option>
    	<%
    	}
    }
    %>
    </select>
    <%
    }
    %>
    <br>
    <label for="Tit_Tel">Telefono:</label>
    <input type="tel" class="form-control" name="Telefono" min="8" max="25" value="<%=request.getAttribute("Telefono") %>" required>
    
</div>
</div>
</div>
<div class="row">
<div class="col-12">
<%
//String x = "GuardarAlumno";
//if(){
//	 x =  "GuardarAlumno";
	 
	 
//}else{
//	 x = "GuardarProfesor";
//}
%>
<input type="submit" name="<%=x%>" class="btn btn-primary btn-lg btn-block" value="Guardar">
</div>
</div>
</div>
</form>
</body>
</html>