<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/Altas.css">
<title>Reserva de pistas</title>
</head>
<body>
	<div class="container shadow">
		<form method="post" class="w-50 mx-auto">
			<label>Cliente</label>
			<select name="dni" class="form-control">
				<option value=0>
				<c:forEach items="${clientes}" var="cliente">
					<option value="${cliente.dni}">${cliente.dni}</option>
				</c:forEach>
			</select>
			<br><br>
			<label>Sala</label>
			<select name="sala" class="form-control">
				<option value=0>
				<c:forEach items="${salas}" var="sala">
					<option value="${sala.codigo}">${sala.codigo}</option>
				</c:forEach>
			</select>
			<br><br>
			<label>Hora</label>
			<select name="horas" class="form-control">
				<option value=0>
				<option value="11:30">11:30</option>
				<option value="14:15">14:15</option>
				<option value="16:45">16:45</option>
				<option value="20:00">20:00</option>
			</select>
			<br>
			<input type="submit" value="Reservar" >
		</form>
		<a href="VerReservas" class="btn btn-dark">Volver</a>
	</div>

	
</body>
</html>