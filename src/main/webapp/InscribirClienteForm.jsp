<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/Altas.css">
<meta charset="ISO-8859-1">
<title>Inscribir Cliente</title>
</head>
<body>
	<div class="container shadow">
		<h1>Inscribir Cliente en Actividad</h1>
		<form  method="post" class="w-50 mx-auto"> 
			<label>Cliente</label>
			<select name="dni" class="form-control">
				<option value=0></option>
				<c:forEach items="${clientes}" var="cliente">
					<option value="${cliente.dni}">${cliente.dni}</option>
				</c:forEach>
			</select>
			<br><br>
			<label>Actividad y grupo</label>
			<select name="actividad" class="form-control">
				<option></option>
				<c:forEach items="${actividades}" var="actividad">
					<optgroup label="${actividad.nombreActividad}">
    					<c:forEach items="${grupos}" var="grupo">
    						<c:if test="${fn:contains(grupo.id_grupo,actividad.id_actividad)}">
    							<option value="${grupo.id_grupo}">${grupo.id_grupo} ${grupo.horarios}</option>
    						</c:if>	
						</c:forEach>
  					</optgroup>	
				</c:forEach>
			</select>
			<br><br>
			<input type="submit" value="Inscribir">
		</form>
		<a href="VerInscripciones" class="btn btn-dark">Volver</a>
	</div>
</body>
</html>