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
	<form action="../Controlador_AtualizaUsuario" method="get">
	<label for="usuario">Usuario:</label> 
	<input type="text"  name="usuario"><br>
	
	<label for="contrasena">Contraseña:</label> 
	<input type="text"  name="contrasena"><br>
		
		<input type="submit" name="buttom" value="Busca usuario" />
	</form>
	
	<form action="Controlador_AtualizaUsuario" method="post">
		<label for="id">Id</label> 
		<input type="text"  name="id" value="${usuarios.id_usuario}"><br>
		
		<label for="nombre">Nombre:</label> 
		<input type="text"  name="nombre" value="${usuarios.nombre}"><br>
		
		<label for="apellido">Apellido:</label> 
		<input type="text"  name="apellido" value="${usuarios.apellido}"><br>
		
		<label for="usuario">Usuario:</label> 
		<input type="text"  name="usuario" value="${usuarios.usuario}"><br>
		
		<label for="contrasena">Contraseña:</label> 
		<input type="text"  name="contrasena" value="${usuarios.contrasena}"><br>
		
		<label for="pais">Pais:</label> 
		<input type="text"  name="pais" value="${usuarios.pais}"><br>
		
		<label for="tecnologia">Tecnologia:</label> 
		<input type="text"  name="tecnologia" value="${usuarios.tecnologia}"><br>
		
		<input type="submit" name="buttom" value="Atualiza usuario" />
	</form>
	
</body>
</html>