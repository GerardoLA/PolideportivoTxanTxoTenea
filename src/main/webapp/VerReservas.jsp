<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservas</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>

	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerReservasCliente" method="get" style="display: inline-block;">
			<input type="text" name="dni" placeholder="dni">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	
		<form action="VerReservasSala" method="get" style="display: inline-block;">
			<input type="text" name="codigo" placeholder="codigoSala">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	
	<div class="intro">
	<p> <h2 style="color: red;">${error}</h2>  <h2 style="color: green;">${confirmacion}</h2> </p>
		<table class="table table-striped">
		 <thead style="background-color: #002d72;">
		  	<tr>
		  		<th colspan=5 style="text-align:center"><h2>VER RESERVAS</h2></th>
		 	</tr>
			<tr>
				<th scope="row">DNI</th>
				<th scope="row">SALA</th>
				<th scope="row">FECHA</th>
				<th scope="row">HORA</th>
				<th scope="row">CANCELAR</th>
			</tr>
		 </thead>
			<c:forEach items="${reservas}" var="reserva">
				<tr>
					<td>${reserva.cliente.dni}</td>
					<td>${reserva.sala.codigo}</td>
					<td>${reserva.fecha}</td>
					<td>${reserva.hora}</td>
					<td><a href="CancelarReserva?dni=${reserva.cliente.dni}&codigo=${reserva.sala.codigo}" class="btn btn-primary">Eliminar</a></td>
				</tr>	
			</c:forEach>
		</table>
	</div>
	
	<footer>
		<a href="ReservarPista" class="btn btn-dark" >Reservar Pista</a>
		<a href="MenuRecepcionista.jsp" class="btn btn-dark volver">Volver</a>
	</footer>



</body>
</html>