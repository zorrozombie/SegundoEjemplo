<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/estilo.css">
</head>
<body>
	<table border="1">
		<tr id="cabeza">
			<td>Cod_Prod</td>
			<td>Seccion</td>
			<td>Nombre_prod</td>
			<td>Precio</td>
			<td>Fecha</td>
			<td>Importado</td>
			<td>Pais_Origen</td>
			<td>Actualizar</td>
		</tr>
		<c:forEach var="elem" items="${produ}">
			<c:url var="linkTemp" value="Controlador_Productos">
				<c:param name="guarda" value="cargaParaActualizar"></c:param>
				<c:param name="codProducto" value="${elem.codProd}"></c:param>
			</c:url>
			<c:url var="linkTempEliminar" value="Controlador_Productos">
				<c:param name="guarda" value="cargaParaEliminar"></c:param>
				<c:param name="codProducto" value="${elem.codProd}"></c:param>
			</c:url>
			<tr tbody id="cambia">
				<td>${elem.codProd}</td>
				<td>${elem.seccion}</td>
				<td>${elem.nombreProd}</td>
				<td>${elem.precio}</td>
				<td>${elem.fecha}</td>
				<td>${elem.importado}</td>
				<td>${elem.pais}</td>
				<td><a href="${linkTemp}">Actualizar</a> <a href="${linkTempEliminar}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	<form
		action="${pageContext.request.contextPath}/vistasProductos/InsertarProducto.jsp"
		method="post">
		<input type="submit" name="buttom" value="Insertar Producto" />
	</form>
</body>
</html>