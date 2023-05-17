<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<title>Alta trabajo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/Altas.css">
</head>
<body>
	<div class="container shadow">
				<h1>Alta Trabajo</h1>

		<form method ="post"action="AltaTrabajo" class="w-50 mx-auto">
			<label>IdTrabajo: </label>	
			<input type="text" name="id_trabajo" placeholder = "id_trabajo"/><br>
			<br>
			<label>Nombre  : </label>
			<input type = "text" name ="nombre" placeholder = "nombre"/><br>
			<br>
		</form>
	</div>


</body>
</html>