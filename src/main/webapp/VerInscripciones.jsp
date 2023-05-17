<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Inscripciones</title>
</head>
<body>
	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerInscripcionCliente" style="display: inline-block;">
			<input type="text" name="dniCliente" placeholder="dni">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	
		<form action="VerInscripcionActividad" style="display: inline-block;">
			<input type="text" name="NombreActividad" placeholder="NombreActividad">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	<div class="intro">
		<table class="table table-striped">
		 <thead style="background-color: #002d72;">
			<tr>
				<th scope="row">DNI</th>
				<th scope="row">ACTIVIDAD</th>
				<th scope="row">GRUPO</th>
				<th scope="row">HORARIO</th>
				<th scope="row">FECHA</th>
				<th scope="row">ELIMINAR</th>
			</tr>
		</thead>	
			<tr>
				<c:forEach items="${inscripciones}" var="inscripcion">
					<tr>
						<td scope="row">${inscripcion.cliente.dni}</td>
						<td scope="row">${inscripcion.actividad.nombreActividad}</td>
						<td scope="row">${inscripcion.grupo.id_grupo}</td>
						<td scope="row">${inscripcion.grupo.horarios}</td>
						<td scope="row">${inscripcion.fecha}</td>
						<td><a href="EliminarInscripcion?dni=${inscripcion.cliente.dni}&id_grupo=${inscripcion.grupo.id_grupo}" class="btn btn-primary">Eliminar</a></td>	
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
	

	
	
	<footer>
		<a href="InscribirEnActividad" class="btn btn-dark" >Inscribir en Actividad</a>
		<a href="MenuRecepcionista.jsp" class="btn btn-dark volver">Volver</a>
	</footer>
		
</body>
</html>