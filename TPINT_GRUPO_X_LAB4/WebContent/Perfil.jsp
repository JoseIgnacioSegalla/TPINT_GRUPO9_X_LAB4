<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="row">
<div class="col-6">


  <div class="form-group">
    <label for="Tit_Nom">Nombre:</label>
    <input type="Text" class="form-control" name="Nombre" min="3" max="45" required>
    <br>
    <label for="Tit_Leg">Legajo:</label>
    <input type="number" class="form-control" name="Legajo" min="1" max="99999" required>
    <br>
    <label for="Tit_FechNac">Fecha Nacimiento:</label>
    <input type="date" class="form-control" name="FechNac" required>
    <br>
    <label for="Tit_Loc">Localidad:</label>
    <input type="Text" class="form-control" name="Localidad" min="3" max="45" required>
    <br>
    <label for="Tit_Email">Email:</label>
    <input type="email" class="form-control" name="Email" min="8" max="45" required>
  </div>

</div>
<div class="col-6">
 <div class="form-group">

    <label for="Tit_Apellido">Apellido:</label>
    <input type="Text" class="form-control" name="Apellido" min="3" max="45" required>
    <br>
    <label for="Tit_Dni">Dni:</label>
    <input type="number" class="form-control" name="Dni" min="20000000" max="100000000" required>
    <br>
    <label for="Tit_Direc">Direccion:</label>
    <input type="Text" class="form-control" name="Direccion" min="8" max="45" required>
    <br>
    <label for="Tit_Prov">Provincia:</label>
    <input type="Text" class="form-control" name="Provincia" min="6" max="25" required>
    <br>
    <label for="Tit_Tel">Telefono:</label>
    <input type="tel" class="form-control" name="Telefono" min="8" max="25" required>
    
</div>
</div>
</div>
<div class="row">
<div class="col-12">
<button type="submit" class="btn btn-primary btn-block" name="Btn_Guardar_Cambios">Guardar Cambios</button>
</div>
</div>
</div>
</form>
</body>
</html>