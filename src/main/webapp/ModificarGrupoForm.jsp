<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Modificar grupo</title>
</head>
<body>
	<div class="container shadow">
		<h1>Modificar Grupo</h1>
		<br>
		<form action="ModificarGrupo">
			<label> Grupo:${grupo.id_grupo} </label>
			<input type="hidden" name="id_grupo" value="${grupo.id_grupo}" class="form-control">
			<br><br>
			<input type="text" name="dias" placeholder="dias" value="${grupo.dias}" class="form-control">
			<br><br>
			<input type="text" name="horas" placeholder="horas" value="${grupo.horarios}" class="form-control"> 	
			<br><br>
			<input type="text" name="maxPartic" placeholder="maxPartic" value="${grupo.maxPartic}" class="form-control">
			<br><br>
			<input type="text" name="numPartic" placeholder="numPartic" value="${grupo.numPartic}" class="form-control">
			<br>
			<input type="submit" value="Modificar">
		</form>
		<br>
		<a href="VerActividades" class="btn btn-dark">Volver</a>	
	</div>
</body>
</html>