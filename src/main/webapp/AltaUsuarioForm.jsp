<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/Altas.css">
</head>
<body>

	<div class="container shadow">
				<h1>Alta Usuario</h1>

		<form method ="post"action="AltaUsuario" class="w-50 mx-auto" >
			<label>Id Usuario :</label>	
			<input type="text" name="id_usuario" class="form-control" placeholder = "id_usuario"/><br>
			<br>
			<label>Nombre:</label>
			<input type = "text" name ="nombre" class="form-control" placeholder = "nombre"/><br>
			<br>
			<label>Password: </label>
			<input type = "text" name ="contrasena"  class="form-control" placeholder = "contrasena"/> <br>
			<small style="color: red;">${error}</small>
			<br>
		
			<input type ="submit" value="Crear">
		</form>
	
		<a href="VerUsuarios" class="btn btn-dark">Volver</a>
	</div>
	

</body>
</html>