<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<h1>Alta empleado</h1> 
		<form method="post" action=" " class="w-50 mx-auto">
			<label>Nombre: </label>
			<input type="text" name="nombre" class="form-control"  placeholder="nombre"/><br>
			<br>
			<label>Apellido: </label>
			<input type="text" name="apellido" class="form-control"  placeholder="apellido"/><br>
			<br>
			<label>Dni: </label>
			<input type="text" name="dni"  class="form-control"  placeholder="dni"/><br>
			<br>
			<label>Edad: </label>
			<input type="text" name="edad"  class="form-control"  placeholder="edad"/><br>
			<br>
			<label for="usuario">Usuario</label>
			<select name="Id_usuario" class="form-control">
				<option value=0></option>
					<c:forEach items ="${usuarios}" var="usuario">
						<option value="${usuario.id_usuario}">${usuario.id_usuario}  </option>
					</c:forEach>
			</select>
			<br>
			<label for="trabajo">Puesto de Trabajo: </label>
			<select name="trabajo" class="form-control">
				<option value=0></option>
					<c:forEach items ="${trabajos }" var="trabajo">
						<option value="${trabajo.nombre }">${trabajo.nombre }  </option>
					</c:forEach>
			</select>
			<br>
			<input type=submit value="Dar de Alta"/>
			<br>
			
		</form>
		<a href="VerEmpleados" class="btn btn-primary">Volver</a>
	</div>
</body>
</html>