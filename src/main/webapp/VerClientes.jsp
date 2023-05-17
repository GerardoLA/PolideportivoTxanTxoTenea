<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerCliente">
			<input type="text" name="dni" placeholder="dni">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	<div class="intro">
		<table class="table table-striped">
		 <thead style="background-color: #002d72;">
			<tr>
				<th scope="row">DNI</th>
				<th scope="row">NOMBRE</th>
				<th scope="row">APELLIDO</th>
				<th scope="row">TELEFONO</th>
				<th scope="row">MAIL</th>
				<th scope="row">ANTIGUEDAD</th>
				<th scope="row">MODIFICAR</th>
				<th scope="row">ELIMINAR</th>
			</tr>
		</thead>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td scope="row">${cliente.dni}</td>
					<td scope="row">${cliente.nombre}</td>
					<td scope="row">${cliente.apellido}</td>
					<td scope="row">${cliente.telefono}</td>
					<td scope="row">${cliente.mail}</td>
					<td scope="row">${cliente.antiguedad}</td>
					<td ><a href="ModificarClienteForm?dni=${cliente.dni}" class="btn btn-secondary"> Modificar </a></td>		
					<td><a href="EliminarCliente?dni=${cliente.dni}" class="btn btn-primary"> Eliminar </a></td>	
				</tr>			
			</c:forEach>
		</table>
	</div>
	
	<footer>
		<a href="AltaCliente" class="btn btn-dark" >Insertar Cliente</a>
		<a href="MenuRecepcionista.jsp" class="btn btn-dark volver">Volver</a>
	</footer>
</body>
</html>