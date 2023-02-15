<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_LoginUsuario" method="post">
	
	<label for="usuario">Usuario:</label> 
	<input type="text"  name="usuario"><br>
	
	<label for="contrasena">Contraseña:</label> 
	<input type="text"  name="contrasena"><br>
	
	
	<input type="submit" name="buttom" value="Enviar" />
	</form>
</body>
</html>