<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/Altas.css">
<title>Modificar empleado</title>
</head>
<body>
<div class="container shadow">
	<h1>Modificar Usuario</h1> 
	<form Action ="ModificarDatosEmpleado" class="w-50 mx-auto" >
		<label>${empleado.id_empleado}</label>
		<br>
		<input type="hidden" name="id" value="${empleado.id_empleado}" ><br>
		<label>Nombre: </label>
		<br>
		<input type="text" name="nombre"  class="form-control" placeholder="nombre" value="${empleado.nombre}"/><br>
		<br>
		<label>Apellido: </label>
		<br>
		<input type="text" name="apellido" class="form-control"  placeholder="apellido" value="${empleado.apellido}"/><br>
		<br>
		<label>Dni: </label>
		<br>
		<input type="text" name="dni" class="form-control"  placeholder="dni" value="${empleado.dni}"/><br>
		<br>
		<label>Edad: </label>
		<br>
		<input type="text" name="edad"  class="form-control"  placeholder="edad" value="${empleado.edad}"/><br>
		<br>
		<label>Fecha: </label>
		<br>
		<input type="date" class="form-control"  name="fecha" value="${empleado.antiguedad}"/><br>
		<br>
		<label>${empleado.usuario.id_usuario}</label>
		<br>
		<input type="hidden"  class="form-control" name="id_usuario"  placeholder="id_usuario" value="${empleado.usuario.id_usuario}"/><br>
		<label>Trabajos</label>
		<select name="trabajo" class="form-control">
			<c:forEach items="${trabajos}" var="trabajo">
				<c:choose>
					<c:when test="${empleado.trabajo.id_trabajo==trabajo.id_trabajo}">
						<option selected value="${trabajo.nombre}">${trabajo.nombre}</option>
					</c:when>
					<c:when test="${empleado.trabajo.id_trabajo!=trabajo.id_trabajo}">
						<option value="${trabajo.nombre}">${trabajo.nombre}</option>
					</c:when>
				</c:choose>
				
			</c:forEach>
		</select>
		<br>
		<input type=submit value="Modificar"/>
	</form>	
	<a href="VerEmpleados" class="btn btn-dark">Volver</a>
	</div>



</body>
</html>