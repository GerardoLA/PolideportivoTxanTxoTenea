<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grupos</title>
</head>
<body>
	<table border=1>
			<tr>
				<th scope="row">ID</th>
				<th scope="row">DIAS</th>
				<th scope="row">HORARIOS</th>
				<th scope="row">MAXPARTIC</th>
				<th scope="row">NUMPARTIC</th>
				<th scope="row">MODIFICAR</th>
				<th scope="row">ELIMINAR</th>
			</tr>
			<c:forEach items="${grupos}" var="grupo">
				<tr>
					<td>${grupo.id_grupo}</td>
					<td>${grupo.dias }</td>
					<td>${grupo.horarios }</td>
					<td>${grupo.maxPartic }</td>
					<td>${grupo.numPartic }</td>
					<td ><a href="ModificarGrupo?id_grupo=${grupo.id_grupo}">Modificar</a></td>		
					<td><a href="EliminarGrupo?id_grupo=${grupo.id_grupo}">Eliminar</a></td>		
				</tr>
			
			</c:forEach>
		</table>
		
	<form action="VerGrupo">
		<input type="text" name="idGrupo" placeholder="id">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
</body>
</html>