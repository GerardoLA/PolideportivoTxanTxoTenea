<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/tablas.css">
<title>Ver Puesto Trabajo</title>
</head>
<body>
	<div class="cabecera">
		<h1>Logo<a href="LogOut">Logout</a></h1>
		<form action="VerTrabajo" class="ver">
			<input type="text" name="id_trabajo" placeholder="id">
			<input type="submit" value="Ver" class="btn btn-secondary">
		</form>
	</div>
	<div class="intro">
	<p> <h2 style="color: red;">${error}</h2>  <h2 style="color: green;">${confirmacion}</h2> </p>
			<table class="table table-striped">
                      <thead style="background-color: #002d72;">
               <tr>
		  			<th colspan=2 style="text-align:center"><h2>VER TRABAJOS</h2></th>
		  		</tr>
    			<tr>
     				 <th scope="col">ID__TRABAJO</th>
      				<th scope="col">NOMBRE</th>
    			</tr>
    			</thead>
			  <c:forEach items="${trabajos}" var="trabajo">
			    <tr>
			      <td scope="row">${trabajo.id_trabajo}</td>
			      <td scope="row">${trabajo.nombre}</td>
			    </tr>
			 </c:forEach>

			</table>
		</div>
			
				


<footer>
<form action="AltaTrabajo" method="GET" style="display: inline-block;">
				  <input type="text" name="nombre" placeholder="nombre">
				  <input type="submit" value="Dar de alta">
				</form>
<a href="MenuJefe.jsp" class="btn btn-dark volver">Volver</a>
</footer>
</body>
</html>