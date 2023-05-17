<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
<title>Actividades</title>
</head>
<body>
	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerActividad">
			<input type="text" name="idActividad" placeholder="id_actividad">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	<div class="intro">
		<table class="table table-striped">
		  <thead style="background-color: #002d72;">
			<tr>
				<th scope="col">ACTIVIDAD</th>
				<th scope="col">GRUPO</th>
				<th scope="col">DIAS</th>
				<th scope="col">HORAS</th>
				<th scope="col">NUM_PARTIC</th>
				<th scope="col">MODIFICAR ACTIVIDAD</th>
				<th scope="col">MODIFICAR GRUPO</th>
				<th scope="col">ELIMINAR</th>
			</tr>
		 </thead>	
			<c:forEach items="${actividades}" var="actividad">
				<tr>
					<td scope="row">${actividad.actividad.id_actividad}</td>
					<td scope="row">${actividad.grupo.id_grupo}</td>
					<td scope="row">${actividad.grupo.dias}</td>
					<td scope="row">${actividad.grupo.horarios}</td>
					<td scope="row">${actividad.grupo.numPartic}</td>
					<td><a href="ModificarActividadForm?id_actividad=${actividad.actividad.id_actividad}" class="btn btn-secondary">Modificar actividad</a></td>
					<td ><a href="ModificarGrupoForm?id_grupo=${actividad.grupo.id_grupo}" class="btn btn-secondary">Modificar Grupo</a></td>		
					<td ><a href="EliminarActividad?id_actividad=${actividad.actividad.id_actividad}&id_grupo=${actividad.grupo.id_grupo}" class="btn btn-primary">Eliminar</a></td>		
				</tr>
			</c:forEach>
		 	
		</table>
	</div>
	
	<footer>
		<a href="InsertarActividad" class="btn btn-dark" >Insertar Actividad</a>
		<a href="InsertarGrupoSolo" class="btn btn-dark">Insertar Grupo</a>
	</footer>	
</body>
</html>