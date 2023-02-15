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
	<form action="${pageContext.request.contextPath}/Controlador_Productos" method="post">
	
		<label for="id">Código del producto</label> 
		<input type="text"  name="codProd" value="${elem.codProd}"><br>
		
		<label for="seccion">seccion:</label> 
		<input type="text"  name="seccion" value="${elem.seccion}"><br>
		
		<label for="apellido">Nombre:</label> 
		<input type="text"  name="nombre" value="${elem.nombreProd}"><br>
		
		<label for="usuario">Fecha:</label> 
		<input type="text"  name="fecha" value="${elem.fecha}"><br>
		
		<label for="importado">Importado:</label> 
		<input type="text"  name="importado" value="${elem.importado}"><br>
		
		<label for="pais">Pais:</label> 
		<input type="text"  name="pais" value="${elem.pais}"><br>
		
		<input type="submit" name="botonActualiza" value="Actualiza Usuario" />
	</form>
	
</body>
</html>