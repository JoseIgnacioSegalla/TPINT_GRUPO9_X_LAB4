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
String x = "";
if(request.getAttribute("IdAlumno")!= null && request.getAttribute("Tipo") == "0"){
x = "VerPerfilAlumno";
}
else if(request.getAttribute("IdProfesor") != null && request.getAttribute("Tipo") == "0")
{
x="GuardarPerfilProfesor";
%>
<input type="hidden" name="IdProfesor" value="<%=request.getAttribute("IdProfesor")%>">
<% 
}else if(request.getAttribute("IdProfesor") != null && request.getAttribute("Tipo") == "1"){
x= "GuardarProfesor";
%>
<input type="hidden" name="IdProfesor" value="<%=request.getAttribute("IdProfesor")%>">
<% 
}else{
%>
<input type="hidden" name="IdAlumno" value="<%=request.getAttribute("IdAlumno")%>">
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
    
    
    
    
    
    <!-- PROVINCIA -->
    
    
	<label for="Tit_Prov">Provincia:</label>
     <%

    if(request.getAttribute("Provincia") != null)
    {	
    List<Provincia> LProv = (List<Provincia>) request.getAttribute("Provincia");	
    %>
    <select class="form-control" name="DDLProvincia" id="IdProvincia" onchange="document.form1.submit()">
    
    <option value="0" disabled>Seleccione Provincia</option>
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
 	
 	
 	
 	<!-- LOCALIDAD -->
 	
 	
    <label for="Tit_Loc">Localidad:</label>
    <%

    if(request.getAttribute("Localidad") != null)
    {
    List<Localidad> LLoc = (List<Localidad>) request.getAttribute("Localidad");	
    %>
    
    <select class="form-control" name="DDLLocalidad" id="IdLLocalidad">
    <option value="0" disabled>Seleccione Localidad</option>
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

<%if(x.equals("VerPerfilAlumno")){
%>
<input type="submit" name="<%=x%>" class="btn btn-primary btn-lg btn-block" value="Guardar" disabled>
<%
}else if(x.equals("GuardarPerfilProfesor"))
{
%>
<input type="submit" name="<%=x%>" class="btn btn-primary btn-lg btn-block" value="Guardar">
<%	
}else if(x.equals("GuardarProfesor")){
%>
<input type="submit" name="<%=x%>" class="btn btn-primary btn-lg btn-block" value="Guardar">
<% 
}else{
%>
<input type="submit" name="GuardarAlumno" class="btn btn-primary btn-lg btn-block" value="Guardar">
<%
}
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#IdProvincia").on('change',function(){
		var IdProvincia = $('#IdProvincia option:selected').val();
	$.post( "ServletLocalidades",
	{
		Prov: IdProvincia
	},
	function(data){
		$('#IdLocalidad').html(data);
	});

	});
});

</script>


</div>
</div>
</div>
</form>
</body>
</html>