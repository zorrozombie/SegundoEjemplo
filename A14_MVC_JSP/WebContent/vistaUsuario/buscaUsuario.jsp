<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Busca usuario por clave</h1>
	<form action="../Controlador_BuscaUsuario" method="post">
	<label for="id_usu">Id_usuario:</label> 
	<input type="text"  name="id_usu"><br>
	
	<input type="submit" name="buttom" value="Enviar" />
	</form>
</body>
</html>