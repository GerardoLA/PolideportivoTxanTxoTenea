<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Usuarios</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
		<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerUsuario">
		<input type="text" name="idUsuario" placeholder="id">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
	</div>
	
	<div class="intro">
	
		<table class="table table-striped">
			<thead style="background-color: #002d72;">
    	<tr>
     		<th scope="col">ID__USUARIO</th>
      		<th scope="col">NOMBRE</th>
      		<th scope="col">CONTRASENA</th>
      		<th scope="col">MODIFICAR</th>
   		</tr>
   			</thead>
 
  		<c:forEach items="${usuarios}" var="usuario">
    	<tr>
      		<td scope="row">${usuario.id_usuario}</td>
      		<td scope="row">${usuario.nombre}</td>
      		<td scope="row">${usuario.contrasena}</td>
      		<td><a href="ModificarUsuarioForm?id_usuario=${usuario.id_usuario}" class="btn btn-secondary ">Modificar</a></td>
  		</tr>
 		</c:forEach>
		</table>
	</div>
	<footer>
<a href="AltaUsuario" class="btn btn-dark">Registrar Usuario nuevo</a>
	
	
<a href="MenuJefe.jsp" class="btn btn-dark volver">Volver</a>
	</footer>

</body>
</html>