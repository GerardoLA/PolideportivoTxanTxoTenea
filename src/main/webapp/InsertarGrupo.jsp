<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Insertar grupo</title>
</head>
<body>
	<div class="container shadow">
		<h1>Insertar Grupo</h1>
		<form action="InsertarGrupoSolo" method="post" class="w-50 mx-auto">
			<br>
			<small style="color:red;">El id del grupo tiene que ser la id de la actividad insertada + un numero <br>
				Por ejemplo: Id Actividad=TEN, Id grupo =TEN1
			 </small>
			<br><br>
			<select name="id_actividad" class="form-control">
				<option value=0>
				<c:forEach items="${actividades}" var="actividad">
					<option value="${actividad.id_actividad}">${actividad.id_actividad}</option>
				</c:forEach>
			</select>
			<br><br>
			<input type="text" name="id_grupo" placeholder="id_grupo" class="form-control">
			<br><br>
			<input type="text" name="dias" placeholder="dias" class="form-control">
			<br><br>
			<input type="text" name="horas" placeholder="horas" class="form-control">	
			<br><br>
			<input type="text" name="maxPartic" placeholder="maxPartic" class="form-control">
			<br><br>
			<input type="text" name="numPartic" placeholder="numPartic" class="form-control">
			<br><br>
			<input type="submit" value="Crear Grupo">
		</form>
		<a href="VerActividades" class="btn btn-dark">Volver</a>
	</div>	
</body>
</html>