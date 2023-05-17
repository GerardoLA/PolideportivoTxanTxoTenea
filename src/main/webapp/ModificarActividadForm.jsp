<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container shadow">
		<h1>Modificar Actividad</h1>
		<form action="ModificarActividad">
			<label>Actividad:${actividad.id_actividad}</label>
			<input type="hidden" name="id_actividad" value="${actividad.id_actividad}" class="form-control">
			<br><br>
			<input type="text" name="nombre" value="${actividad.nombreActividad}" class="form-control">
			<br><br>
			<input type="text" name="precio" value="${actividad.precio}" class="form-control">	
			<br><br>
			<input type="submit" value="Modificar">
		</form>
		<br>
		<a href="VerActividades" class="btn btn-dark">Volver</a>
	</div>
</body>
</html>