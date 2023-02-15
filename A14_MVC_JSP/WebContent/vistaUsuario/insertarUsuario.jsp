<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_InsertarUsuario" method="post">
	<label for="nombre">Nombre:</label> 
	<input type="text"  name="nombre"><br>
	
	<label for="apellido">Apellido:</label> 
	<input type="text"  name="apellido"><br>
	
	<label for="usuario">Usuario:</label> 
	<input type="text"  name="usuario"><br>
	
	<label for="contrasena">Contraseña:</label> 
	<input type="text"  name="contrasena"><br>
	
	<label for="pais">Pais:</label> 
	<input type="text"  name="pais"><br>
	
	<label for="tecnologia">Tecnologia:</label> 
	<input type="text"  name="tecnologia"><br>
	
	<input type="submit" name="buttom" value="Enviar" />
	</form>
</body>
</html>