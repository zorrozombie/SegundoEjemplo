<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/bloqueo.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Controlador_ActualizaUsuarioV2" method="post">
	<label for="usuario1">Usuario:</label> 
	<input type="text"  name="usuario1"><br>
	
	<label for="contrasena1">Contraseña:</label> 
	<input type="text" name="contrasena1"><br>
		
		<input type="submit" name="botonLogin" value="Login Usuario" /><br>
	
	
		<label for="id">Id</label> 
		<input type="text"  name="id" value="${usuarios.id_usuario}"><br>
		
		<label for="nombre">Nombre:</label> 
		<input type="text"  name="nombre" value="${usuarios.nombre}"><br>
		
		<label for="apellido">Apellido:</label> 
		<input type="text"  name="apellido" value="${usuarios.apellido}"><br>
		
		<label for="usuario">Usuario:</label> 
		<input type="text"  name="usuario"  id="usuario" value="${usuarios.usuario}"><br>
		
		<label for="contrasena">Contraseña:</label> 
		<input type="text"  name="contrasena" id="contrasena" value="${usuarios.contrasena}"><br>
		
		<label for="pais">Pais:</label> 
		<input type="text"  name="pais" value="${usuarios.pais}"><br>
		
		<label for="tecnologia">Tecnologia:</label> 
		<input type="text"  name="tecnologia" value="${usuarios.tecnologia}"><br>
		
		<input type="submit" name="botonActualiza" id="update" value="Actualiza Usuario" disabled />
	</form>
	
</body>
</html>