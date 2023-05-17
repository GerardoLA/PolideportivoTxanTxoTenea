<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Empleados</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<link rel="stylesheet" href="css/tablas.css">
<title>Ver Clientes</title>
</head>
<body>
	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerEmpleado" class="ver">
			<input type="text" name="idEmpleado" placeholder="id">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	
	<div class="intro">
		
			<table class="table table-striped">
                      <thead style="background-color: #002d72;">
    			<tr>
      				<th scope="col">ID__EMPLEADO</th>
      				<th scope="col">NOMBRE</th>
      				<th scope="col">APELLIDO</th>
      				<th scope="col">DNI</th>
      				<th scope="col">EDAD</th>
     				<th scope="col">ANTIGÜEDAD</th>
     				<th scope="col">ID_JEFE</th>
     				<th scope="col">USUARIO</th>
     				<th scope="col">NOMBRE_TRABAJO</th>
      				<th scope="col">MODIFICAR</th>  
    				<th scope="col">ELIMINAR</th>
    			</tr>
    			</thead>

  				<c:forEach items="${empleados}" var="empleado"> 
  				<tr>
      				<td scope="row">${empleado.id_empleado}</td>
      				<td scope="row">${empleado.nombre}</td>
      				<td scope="row">${empleado.apellido}</td>
      				<td scope="row">${empleado.dni}</td>
      				<td scope="row">${empleado.edad}</td>
      				<td scope="row">${empleado.antiguedad}</td>
      				<td scope="row">${empleado.id_jefe}</td>
      				<td scope="row">${empleado.usuario.nombre}</td>
      				<td scope="row">${empleado.trabajo.nombre}</td>
    				<td><a href="ModificarEmpleadoForm?id=${empleado.id_empleado}" class="btn btn-secondary ">Modificar</a></td>
    				<td><a href="BajaEmpleado?id=${empleado.id_empleado}" class="btn btn-primary ">Eliminar</a></td>  
    			</tr>
    			
    			
  
 				</c:forEach>  				
				</table>
		
	
		
	
	</div>
	<footer>
		<a href="AltaEmpleado" class="btn btn-dark" >Registrar Empleado nuevo</a>
		<a href="MenuJefe.jsp" class="btn btn-dark volver">Volver</a>
	</footer>



</body>
</html>