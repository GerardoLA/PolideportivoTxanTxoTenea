<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Alta cliente</title>

</head>
<body>
	<div class="container shadow">
		<h1>Alta Cliente</h1> 
		<form action="" method="POST" class="w-50 mx-auto">
			<label>Dni: </label>
			<input type="text" name="dni" class="form-control" placeholder="dni">
			<br><br>
			<label>Nombre: </label>
			<input type="text" name="nombre" class="form-control"  placeholder="nombre">
			<br><br>
			<label>Apellido: </label>
			<input type="text" name="apellido"  class="form-control" placeholder="apellido">
			<br><br>
			<label>Tel�fono: </label>
			<input type="text" name="telefono" class="form-control"  placeholder="telefono">
			<br><br>
			<label>Email: </label>
			<input type="email" name="mail"  class="form-control" placeholder="mail">
			<br><br>
			<label>Fecha Alta: </label>
			<input type="date"  class="form-control" name="antiguedad">	
			<br><br>
			<input type="submit" value="Dar de alta">
		</form>
		<a href="VerClientes" class="btn btn-dark">Volver</a>
	</div>
	
	
</body>
</html>