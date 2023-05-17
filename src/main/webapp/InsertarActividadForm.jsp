<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Insertar actividad</title>
</head>
<body>
	<div class="container shadow">
		<h1>Insertar Actividad</h1>
		<br>
		<form action="InsertarActividad" method="post" class="w-50 mx-auto">
			<br> <br>
			<label>ID Actividad</label>
			<input type="text" name="id_actividad" placeholder="id_actividad" class="form-control">
			<br> <br>
			<label>Nombre Actividad</label>
			<input type="text" name="nombre" placeholder="nombre" class="form-control">
			<br><br>
			<label>Precio</label>
			<input type="text" name="precio" placeholder="precio" class="form-control">	
			<br><br>
			<input type="submit" value="Insertar Actividad">
		</form>
		<a href="VerActividades" class="btn btn-dark">Volver</a>
	</div>
</body>
</html>