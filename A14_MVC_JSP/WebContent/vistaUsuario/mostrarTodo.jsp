<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
		<tr>
			<td>Id_usuario</td>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>usuario</td>
			<td>contraseña</td>
			<td>pais</td>
			<td>tecnologia</td>
		</tr>
		<c:forEach var="elem" items="${usuario}">
			<tr>
				<td>${elem.id_usuario}</td>
				<td>${elem.nombre}</td>
				<td>${elem.apellido}</td>
				<td>${elem.usuario}</td>
				<td>${elem.contrasena}</td>
				<td>${elem.pais}</td>
				<td>${elem.tecnologia}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>