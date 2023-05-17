<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Insertar Grupo</h1><br>
		<form action="InsertarGrupo" method="post" class="w-50 mx-auto">
			<br>
			<small style="color:red;">El id del grupo tiene que ser la id de la actividad insertada + un numero <br>
				Por ejemplo: Id Actividad=TEN, Id grupo =TEN1
			 </small>
			<br><br>
			<label>Id de grupo</label>
			<input type="text" name="id_grupo" value="${actividad.id_actividad}" placeholder="id_grupo" class="form-control">
			<br><br>
			<label>Dias</label>
			<input type="text" name="dias" placeholder="dias" class="form-control">
			<br><br>
			<label>Horas</label>
			<input type="text" name="horas" placeholder="horas" class="form-control">	
			<br><br>
			<label>Maximos participantes</label>
			<input type="text" name="maxPartic" placeholder="maxPartic" class="form-control">
			<br><br>
			<input type="submit" value="Crear Grupo">
		</form>
		<a href="VerActividades" class="btn btn-dark">Volver</a>
	</div>	
</body>
</html>