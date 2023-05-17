<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/Altas.css">
<title>Insert title here</title>
</head>
<body>
<div class="container shadow">
	<h1>Modificar Usuario</h1> 
<form Action ="ModificarDatosUsuario" >
<br>
<br>
		<label>${usuario.id_usuario}</label>
		<input type = "hidden" name= "id_usuario" class="form-control" value="${usuario.id_usuario}" > <br>
		<label>Nombre: </label>
		<br>
		<input type="text" name="nombre"  placeholder="nombre" class="form-control" value="${usuario.nombre}"/><br>
		<br>
			<label>Password: </label>
			<input type="text" name="contrasena"  placeholder="contrasena"  class="form-control" value="${usuario.contrasena}"/><br>
			<small style="color: red;">${error}</small>
		<br>
		
		<input type=submit value="Modificar"/>
	</form>

	<a href="VerUsuarios" class="btn btn-dark">Volver</a>
	</div>
</body>
</html>